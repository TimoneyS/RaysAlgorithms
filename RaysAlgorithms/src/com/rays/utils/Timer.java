package com.rays.utils;

import java.util.Date;
import static com.rays.utils.StdOut.*;

/**
 * ��ʱ����
 * @author Ray
 *
 */
public class Timer {
	
	private static Date RECORD_DATE = null;// = new Date();
	private static Integer RECORD_COUNT = 1;
	
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
		Date oldDate = RECORD_DATE;
		RECORD_DATE = new Date();
//		RECORD_MESSAGE.append(String.format("��%2d�κ�ʱ��¼��%s ms. \n", RECORD_COUNT ++, RECORD_DATE.getTime() - oldDate.getTime()));
		pf("��%2d�κ�ʱ��¼��%s ms. \n", RECORD_COUNT ++, RECORD_DATE.getTime() - oldDate.getTime());
		RECORD_DATE = new Date();
	}
	
}
