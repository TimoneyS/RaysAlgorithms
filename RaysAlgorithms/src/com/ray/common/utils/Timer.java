package com.ray.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ray.common.utils.io.Out;

/**
 * ��ʱ����
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
	 * "����" ��ʱ��<br/>
	 * ��һ�ΰ��� ��ʼ��¼ʱ�䣬֮��ÿ�ΰ��½���ʾ������һ�ε�ʱ�䣬����ʼ��һ�μ�ʱ
	 */
	public static void click() {
		if(RECORD_COUNT == 0) begin();
		else record();
	}
	
	/**
	 * "ֹͣ" ��ʱ��
	 */
	public static final void stop() {
	    record();
    	RECORD_COUNT = 0;
    	Out.p(tag() + "������ʱ...");
    }

    private static void begin() {
        Out.p(tag() + "��ʼ��ʱ...");
		RECORD_DATE = new Date();
		RECORD_COUNT = 1;
	}
	
	private static void record() {
		Out.pf(tag()+"��%2d�κ�ʱ��¼ : %sms.\n", RECORD_COUNT ++, new Date().getTime() - RECORD_DATE.getTime());
		RECORD_DATE = new Date();	// ������ӡ��ʱ������ں�
	}
	
	/**
	 * ʱ���
	 */
	public static String tag() {
        return DATE_FORMATTER.format(new Date());
	}
	
}
