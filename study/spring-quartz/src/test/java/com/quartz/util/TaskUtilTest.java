package com.quartz.util;

import com.quartz.bo.TaskBo;
import com.quartz.task.MyTask;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author yugi
 * @apiNote
 * @since 2017-09-28
 */
public class TaskUtilTest {

    private static TaskBo getTaskBo(String jobName, String taskGroup, String trigger) {
        int time = 2;
        int count = 10;
        return new TaskBo(jobName, taskGroup, time, count, trigger, MyTask.class);
    }


    public static void main(String[] args) throws Exception {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        TaskBo taskBo = TaskUtilTest.getTaskBo("任务1", "组1", "触发器1");
        TaskUtil.addJob(scheduler, taskBo);
        Thread.sleep(3000);
        TaskUtil.pauseJob(scheduler, taskBo);
        Thread.sleep(2000);
        TaskUtil.restartJob(scheduler, taskBo);
        Thread.sleep(2000);
        taskBo.setTime(1);
        taskBo.setRepeatCount(15);
        TaskUtil.modifyJobTime(scheduler, taskBo);
        Thread.sleep(3000);
        TaskUtil.shutdown(scheduler);
    }


}