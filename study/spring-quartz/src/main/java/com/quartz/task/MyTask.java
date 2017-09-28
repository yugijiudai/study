package com.quartz.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author yugi
 * @apiNote
 * @since 2017-09-28
 */
public class MyTask implements Job {

    @Override
    public void execute(JobExecutionContext arg) throws JobExecutionException {
        JobKey key = arg.getJobDetail().getKey();
        String name = key.getName();
        String group = key.getGroup();
        System.out.println("任务组【" + group + "】【" + name + "】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "★★★★★★★★★★★");
    }
}
