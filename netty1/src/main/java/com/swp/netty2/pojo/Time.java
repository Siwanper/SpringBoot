package com.swp.netty2.pojo;

import java.util.Date;

/**
 * 描述:
 * 时间
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-20 3:25 PM
 */
public class Time {

    private final long value;

    public Time(){
        this(System.currentTimeMillis()/1000l);
    }

    public Time(long value) {
        this.value = value;
    }

    public long value(){
        return value;
    }

    @Override
    public String toString() {
        return new Date(value() * 1000l).toString();
    }
}
