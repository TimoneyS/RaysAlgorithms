package com.ray.utils;

public class TimeUnit {
    
    public static final TimeUnit SECOND = new TimeUnit(1000);
    public static final TimeUnit MILL_SECOND = new TimeUnit(1);
    
    private int interval;
    private TimeUnit(int i) {
        interval = i;
    }
    
    public final void sleep(int time) {
        try {
            Thread.sleep(time * interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
