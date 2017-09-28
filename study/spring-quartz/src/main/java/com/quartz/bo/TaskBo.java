package com.quartz.bo;

import com.quartz.constant.TaskUnitEnum;
import lombok.Data;
import lombok.NonNull;
import org.quartz.Job;

/**
 * @author yugi
 * @apiNote 任务调度器Bo类
 * @since 2017-09-28
 */
@Data
public class TaskBo {

    private String jobName;

    private String jobGroup;

    private int time;

    private int repeatCount;

    private String triggerGroup;

    private TaskUnitEnum taskUnitEnum;

    private Class<? extends Job> clazz;

    public TaskBo(@NonNull String jobName, @NonNull String jobGroup, int time, int repeatCount, @NonNull String triggerGroup, @NonNull Class<? extends Job> clazz) {
        this(jobName, jobGroup, time, repeatCount, triggerGroup, clazz, TaskUnitEnum.SECOND);
    }

    public TaskBo(String jobName, String jobGroup, int time, int repeatCount, String triggerGroup, Class<? extends Job> clazz, TaskUnitEnum taskUnitEnum) {
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.time = time;
        this.repeatCount = repeatCount;
        this.triggerGroup = triggerGroup;
        this.clazz = clazz;
        this.taskUnitEnum = taskUnitEnum;
    }
}
