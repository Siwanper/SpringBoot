package com.swp.schedule_mail.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 定时任务一
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-27 10:57 AM
 */
@Component
public class SchedulerTask1 {

    private int count = 0;
    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("task running " + (count++));
    }

}
