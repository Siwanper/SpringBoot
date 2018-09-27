package com.swp.schedule_mail.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述:
 * 定时任务2
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-27 11:00 AM
 */
@Component
public class SchedulerTask2 {

    private static final SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled(fixedRate = 6000)
    private void process(){
        System.out.println("currentTime : " + dataformat.format(new Date()));
    }

}
