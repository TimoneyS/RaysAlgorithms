package com.ray.utils;

import static com.ray.utils.Out.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��ʱ����
 * @author Ray
 *
 */
public class Timer {
	
	private static Date RECORD_DATE = null;// = new Date();
	private static Integer RECORD_COUNT = 1;
    private static SimpleDateFormat dateFormater = new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss:ms]"); 
	
	
	/**
	 * ������� ��ʱ���� ��һ�ε�� ��ʼ��¼ʱ�䣬֮��ÿ�ΰ��½���ʾǰһ�εļ�ʱ����ʼ��һ�μ�ʱ
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
		pf("��%2d�κ�ʱ��¼��%s ms. \n", RECORD_COUNT ++, new Date().getTime() - RECORD_DATE.getTime());
		RECORD_DATE = new Date();	// ������ӡ��ʱ������ں�
	}
	
	public static final void stop() {
		pf("��%2d�κ�ʱ��¼��%s ms. \n", RECORD_COUNT ++, new Date().getTime() - RECORD_DATE.getTime());
		RECORD_DATE  = null;
		RECORD_COUNT = 1;
	}
	
	/**
	 * ʱ���
	 */
	public static String tag() {
        return dateFormater.format(new Date());
	    
	}
	
}
