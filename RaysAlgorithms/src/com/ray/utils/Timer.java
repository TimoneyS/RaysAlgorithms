package com.ray.utils;

import static com.ray.utils.Out.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计时器类
 * @author Ray
 *
 */
public class Timer {
	
	private static Date RECORD_DATE = null;// = new Date();
	private static Integer RECORD_COUNT = 1;
    private static SimpleDateFormat dateFormater = new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss:ms]"); 
	
	
	/**
	 * “点击” 计时器， 第一次点击 开始记录时间，之后每次按下将显示前一次的计时并开始下一次计时
	 */
	public static void click() {
		if(RECORD_DATE == null) begin();
		else record();
	}
	
	private static void begin() {
		RECORD_DATE = new Date();
		RECORD_COUNT = 1;
	}
	
	private static void record() {
		pf("第%2d次耗时记录：%s ms. \n", RECORD_COUNT ++, new Date().getTime() - RECORD_DATE.getTime());
		RECORD_DATE = new Date();	// 消除打印的时间差，因此在后
	}
	
	public static final void stop() {
		pf("第%2d次耗时记录：%s ms. \n", RECORD_COUNT ++, new Date().getTime() - RECORD_DATE.getTime());
		RECORD_DATE  = null;
		RECORD_COUNT = 1;
	}
	
	/**
	 * 时间戳
	 */
	public static String tag() {
        return dateFormater.format(new Date());
	    
	}
	
}
