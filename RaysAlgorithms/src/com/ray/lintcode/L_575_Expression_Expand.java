package com.ray.lintcode;

import static com.ray.utils.TestUnit.*;

import java.util.LinkedList;

/**
 * Given an expression s includes numbers, letters and brackets. 
 * Number represents the number of repetitions inside the brackets(can be a string or another expression)��
 * Please expand expression to be a string.
 * @author rays1
 *
 */
public class L_575_Expression_Expand {
	
	static class ExpressionExpand {
		
		/**
	     * @param s  an expression includes numbers, letters and brackets
	     * @return a string
	     */
	    public String expressionExpand(String s) {
	    	// ��ʼ������
	    	LinkedList<int[]> stack = new LinkedList<int[]>(); // ���ڼ�¼ÿ�����ʽ�����
	    	int coefficient = 0;
	    	int length = s.length();
	    	// ѭ����
	    	for (int i = 0; i < length; i ++) {
	    		char c = s.charAt(i);
	    		// �������֣���Ϊϵ������
	    		if(Character.isDigit(c)) coefficient = coefficient * 10 + Character.getNumericValue(c);
	    		// ����������ţ���Ϊ���ʽ��㴦��
	    		if( c == '[') {
	    			stack.push(new int[]{i, coefficient});
	    			coefficient = 0;
	    		}
	    		// �����Ұ����ţ���Ϊ���ʽ��������
	    		if( c == ']') {
	    			int[] arr = stack.pop();
	    			int start 	= arr[0];	// ���ʽ���
	    			int count 	= arr[1];	// ���ʽϵ��
	    			//  �������ʽ��ֵ
	    			StringBuilder sb = new StringBuilder();
	    			String sub = s.substring( start+1, i);
	    			for (int j = 0; j < count; j++) sb.append(sub);
	    			// �滻���ʽ��ԭֵ
	    			s = s.substring(0, start-String.valueOf(count).length())
	    					+ sb.toString()
	    					+ s.substring(i+1, length);
	    			// �����߽���α�
	    			int d = sb.length() - (i-start+1+String.valueOf(count).length());
	    			length += d;
	    			i 	   += d;
	    		}
	    	}
			return s;
	    }
	}
	
	public static void test(ExpressionExpand e, String input, String result) {
		assertEqual(result, e.expressionExpand(input));
	}
	
	public static void main (String[] args) {
		String[] cases = new String[] {
				"abc3[a]",			"abcaaa",
				"3[abc]",  			"abcabcabc",
				"4[ac]dy",  		"acacacacdy",
				"3[2[ad]3[pf]]xyz", "adadpfpfpfadadpfpfpfadadpfpfpfxyz",
		};
		ExpressionExpand e = new ExpressionExpand();
		for(int i = 0; i < cases.length/2; i++) test(e, cases[i*2], cases[i*2+1]);
	}
	
}
