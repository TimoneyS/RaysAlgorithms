package com.ray.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ray.common.utils.io.Out;

/**
 * 计时器类
 * @author Ray
 *
 */
public class Timer {
	
    private static Date             RECORD_DATE;
    private static Integer          RECORD_COUNT;
    private static SimpleDateFormat DATE_FORMATTER;
	
    static {
        RECORD_COUNT   = 0;
        DATE_FORMATTER = new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss:ms]");
    }
    
	/**
	 * "按下" 计时器<br/>
	 * 第一次按下 开始记录时间，之后每次按下将显示距离上一次的时间，并开始下一次计时
	 */
	public static void click() {
		if(RECORD_COUNT == 0) begin();
		else record();
	}
	
	/**
	 * "停止" 计时器
	 */
	public static final void stop() {
	    record();
    	RECORD_COUNT = 0;
    	Out.p(tag() + "结束计时...");
    }

    private static void begin() {
        Out.p(tag() + "开始计时...");
		RECORD_DATE = new Date();
		RECORD_COUNT = 1;
	}
	
	private static void record() {
		Out.pf(tag()+"第%2d次耗时记录 : %sms.\n", RECORD_COUNT ++, new Date().getTime() - RECORD_DATE.getTime());
		RECORD_DATE = new Date();	// 消除打印的时间差，因此在后
	}
	
	/**
	 * 时间戳
	 */
	public static String tag() {
        return DATE_FORMATTER.format(new Date());
	}
	
}
