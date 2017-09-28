package com.quartz.bo;

import com.quartz.constant.TaskUnitEnum;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.quartz.Job;

/**
 * @author yugi
 * @apiNote 任务调度器Bo类
 * @since 2017-09-28
 */
@Data
@Accessors(chain = true)
public class TaskBo {


    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务组
     */
    private String jobGroup;

    /**
     * 执行的间隔
     */
    private int time;

    /**
     * 重复执行的次数,如果少于等于0表示无限重复
     */
    private int repeatCount;

    /**
     * 触发器名字
     */
    private String trigger;

    private TaskUnitEnum taskUnitEnum;

    /**
     * 要执行的类
     */
    private Class<? extends Job> clazz;

    public TaskBo(@NonNull String jobName, @NonNull String jobGroup, int time, int repeatCount, @NonNull String trigger, @NonNull Class<? extends Job> clazz) {
        this(jobName, jobGroup, time, repeatCount, trigger, clazz, TaskUnitEnum.SECOND);
    }

    public TaskBo(String jobName, String jobGroup, int time, int repeatCount, String trigger, Class<? extends Job> clazz, TaskUnitEnum taskUnitEnum) {
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.time = time;
        this.repeatCount = repeatCount;
        this.trigger = trigger;
        this.clazz = clazz;
        this.taskUnitEnum = taskUnitEnum;
    }
}
