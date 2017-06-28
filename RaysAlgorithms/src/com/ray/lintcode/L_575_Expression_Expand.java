package com.ray.lintcode;

import static com.ray.utils.TestUnit.*;

import java.util.LinkedList;

/**
 * Given an expression s includes numbers, letters and brackets. 
 * Number represents the number of repetitions inside the brackets(can be a string or another expression)．
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
	    	// 初始化参数
	    	LinkedList<int[]> stack = new LinkedList<int[]>(); // 用于记录每个表达式的起点
	    	int coefficient = 0;
	    	int length = s.length();
	    	// 循环体
	    	for (int i = 0; i < length; i ++) {
	    		char c = s.charAt(i);
	    		// 命中数字，作为系数处理
	    		if(Character.isDigit(c)) coefficient = coefficient * 10 + Character.getNumericValue(c);
	    		// 命中左半括号，作为表达式起点处理
	    		if( c == '[') {
	    			stack.push(new int[]{i, coefficient});
	    			coefficient = 0;
	    		}
	    		// 命中右半括号，作为表达式结束处理
	    		if( c == ']') {
	    			int[] arr = stack.pop();
	    			int start 	= arr[0];	// 表达式起点
	    			int count 	= arr[1];	// 表达式系数
	    			//  解析表达式的值
	    			StringBuilder sb = new StringBuilder();
	    			String sub = s.substring( start+1, i);
	    			for (int j = 0; j < count; j++) sb.append(sub);
	    			// 替换表达式和原值
	    			s = s.substring(0, start-String.valueOf(count).length())
	    					+ sb.toString()
	    					+ s.substring(i+1, length);
	    			// 调整边界和游标
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
