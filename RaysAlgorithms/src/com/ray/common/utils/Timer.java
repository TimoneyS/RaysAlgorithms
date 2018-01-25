package com.ray.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import com.ray.common.utils.io.Out;

/**
 * ��ʱ����
 * @author Ray
 *
 */
public class Timer {
	
    private static AtomicInteger    BEAN_COUNT = new AtomicInteger(0);
    private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss:ms]");
	
	private String name;
    private int record_count = 0;
    private long[] dateArr = new long[2];

    /**
	 * ʱ���
	 */
	public static String tag() {
        return DATE_FORMATTER.format(new Date());
	}
	
	public static Timer create(String name) {
	    return new Timer(name);
	}
	
	public static Timer create() {
	    return new Timer("TIMER " + (BEAN_COUNT.get() + 1) );
	}
	
	private Timer(String name) {
	    if (name == null) name = "";
	    this.name = name;
	    BEAN_COUNT.incrementAndGet();
    }
	
	/**
     * "����" ��ʱ��<br/>
     * ��һ�ΰ��� ��ʼ��¼ʱ�䣬֮��ÿ�ΰ��½���ʾ������һ�ε�ʱ�䣬����ʼ��һ�μ�ʱ
     */
	public void click() {
        adjustDateArray();
        dateArr[record_count ++] = new Date().getTime();
	}
	
    /**
     * "ֹͣ" ��ʱ��
     */
    public void stop() {
        click();
        show();
        record_count = 0;
    }
    
    /**
     * "��ʾ" ��ʱ�����
     */
    public void show() {
       for (int i = 1; i < record_count; i++) {
           Out.pf("[%s]��%2d�κ�ʱ %s ms\n", name, i, dateArr[i] - dateArr[i-1]);
       } 
    }
    
    /**
     * ��������
     */
    private void adjustDateArray() {
        if (record_count+1 >= dateArr.length) {
            long[] temp = new long[dateArr.length * 2];
            for (int i = 0; i < dateArr.length; i++) {
                temp[i] = dateArr[i];
            }
            dateArr = temp;
        }
    }
	   
}
