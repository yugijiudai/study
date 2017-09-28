package com.quartz.util;

import com.quartz.bo.TaskBo;
import com.quartz.constant.TaskUnitEnum;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.SimpleTriggerImpl;

/**
 * @author yugi
 * @apiNote Quartz调度管理器(任务名字一样时, 任务组名字和触发器名字一定要不同, 不然会当成同一个任务)
 * @since 2017-09-28
 */
@UtilityClass
@Slf4j
public class TaskUtil {


    /**
     * 添加任务
     *
     * @param scheduler 调度器
     * @param taskBo    {@link TaskBo}
     */
    public void addJob(Scheduler scheduler, TaskBo taskBo) {
        try {
            String jobName = taskBo.getJobName();
            JobDetail jobDetail = JobBuilder.newJob(taskBo.getClazz()).withIdentity(jobName, taskBo.getJobGroup()).build();
            SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
            SimpleScheduleBuilder sc = setTriggerTime(taskBo, simpleScheduleBuilder);
            // 触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, taskBo.getTrigger()).withSchedule(sc).build();
            scheduler.scheduleJob(jobDetail, trigger);
            startScheduler(scheduler);
        }
        catch (ObjectAlreadyExistsException e) {
            log.warn("已经存在任务【groupName:{}-taskName:{}-trigger:{}】,请不要重复添加", taskBo.getJobGroup(), taskBo.getJobName(), taskBo.getTrigger());
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    /**
     * 修改任务
     *
     * @param scheduler 调度器
     * @param taskBo    {@link TaskBo}
     */
    public void modifyJobTime(Scheduler scheduler, TaskBo taskBo) {
        try {
            Trigger trigger = scheduler.getTrigger(TaskHolder.getTriggerKey(taskBo));
            if (trigger == null) {
                return;
            }
            SimpleTriggerImpl simpleTrigger = (SimpleTriggerImpl) trigger;
            long repeatInterval = simpleTrigger.getRepeatInterval() / 1000;
            int repeatCount = simpleTrigger.getRepeatCount() + 1;
            if (repeatInterval == taskBo.getTime() && repeatCount == taskBo.getRepeatCount()) {
                log.warn("修改失败!时间或者间隔没改变,repeatInterval:【{}】,repeatCount:【{}】,{}", repeatInterval, repeatCount, taskBo);
                return;
            }
            removeJob(scheduler, taskBo);
            addJob(scheduler, taskBo);
            log.info("任务修改成功,重新开始任务{}", taskBo);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除任务
     *
     * @param scheduler 调度器
     * @param taskBo    {@link TaskBo}
     */
    public void removeJob(Scheduler scheduler, TaskBo taskBo) {
        try {
            TriggerKey triggerKey = TaskHolder.getTriggerKey(taskBo);
            // 停止触发器
            scheduler.pauseTrigger(triggerKey);
            // 移除触发器
            scheduler.unscheduleJob(triggerKey);
            JobKey jobKey = new JobKey(taskBo.getJobName(), taskBo.getJobGroup());
            // 删除任务
            scheduler.deleteJob(jobKey);
            log.warn("任务被删除{}", taskBo);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 停止任务
     *
     * @param scheduler 调度器
     * @param taskBo    {@link TaskBo}
     */
    public void pauseJob(Scheduler scheduler, TaskBo taskBo) {
        JobKey jobKey = TaskHolder.getJobKey(taskBo);
        try {
            scheduler.pauseJob(jobKey);
            log.warn("停止任务{}", taskBo);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 重启任务
     *
     * @param scheduler 调度器
     * @param taskBo    {@link TaskBo}
     */
    public void restartJob(Scheduler scheduler, TaskBo taskBo) {
        JobKey jobKey = TaskHolder.getJobKey(taskBo);
        try {
            scheduler.resumeJob(jobKey);
            log.info("重新启动任务{}", taskBo);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 停止触发器
     *
     * @param scheduler 调度器
     * @param taskBo    {@link TaskBo}
     */
    public void pauseTrigger(Scheduler scheduler, TaskBo taskBo) {
        TriggerKey triggerKey = TaskHolder.getTriggerKey(taskBo);
        try {
            scheduler.pauseTrigger(triggerKey);
            log.info("停止触发器{}", taskBo);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 重启触发器
     *
     * @param scheduler 调度器
     * @param taskBo    {@link TaskBo}
     */
    public void restartTrigger(Scheduler scheduler, TaskBo taskBo) {
        TriggerKey triggerKey = TaskHolder.getTriggerKey(taskBo);
        try {
            scheduler.resumeTrigger(triggerKey);
            log.info("重新启动触发器{}", taskBo);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    /**
     * 开始调度器
     *
     * @param scheduler 调度器
     */
    private void startScheduler(Scheduler scheduler) {
        try {
            scheduler.start();
            log.debug("开启调度器成功");
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置调度器执行的时间和执行次数
     *
     * @param taskBo                {@link TaskBo}
     * @param simpleScheduleBuilder {@link SimpleScheduleBuilder}
     */
    private SimpleScheduleBuilder setTriggerTime(TaskBo taskBo, SimpleScheduleBuilder simpleScheduleBuilder) {
        TaskUnitEnum taskUnit = taskBo.getTaskUnitEnum();
        switch (taskUnit) {
            case HOUR:
                simpleScheduleBuilder.withIntervalInHours(taskBo.getTime());
                break;
            case MIN:
                simpleScheduleBuilder.withIntervalInMinutes(taskBo.getTime());
                break;
            case SECOND:
                simpleScheduleBuilder.withIntervalInSeconds(taskBo.getTime());
                break;
            default:
                simpleScheduleBuilder.withIntervalInSeconds(taskBo.getTime());
                break;
        }
        return taskBo.getRepeatCount() > 0 ? simpleScheduleBuilder.withRepeatCount(taskBo.getRepeatCount() - 1) : simpleScheduleBuilder.repeatForever();
    }

    /**
     * 关闭调度器
     *
     * @param scheduler 调度器
     */
    public void shutdown(Scheduler scheduler) {
        try {
            log.warn("开始关闭调度器");
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
                log.warn("关闭调度器成功");
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @UtilityClass
    private class TaskHolder {

        private JobKey getJobKey(TaskBo taskBo) {
            return new JobKey(taskBo.getJobName(), taskBo.getJobGroup());
        }

        private TriggerKey getTriggerKey(TaskBo taskBo) {
            return new TriggerKey(taskBo.getJobName(), taskBo.getTrigger());
        }

    }
}
