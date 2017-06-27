package com.ray.lintcode;

import static com.ray.utils.TestUnit.*;

/**
 * Given an expression s includes numbers, letters and brackets. 
 * Number represents the number of repetitions inside the brackets(can be a string or another expression)го
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
			return s;
	    }
	}
	
	public static void test(ExpressionExpand e, String input, String result) {
		assertEqual(result, e.expressionExpand(input));
	}
	
	public static void main (String[] args) {
		
		String[] cases = new String[] {
			         "abc3[a]", 					       "abcaaa",
			          "3[abc]", 					    "abcabcabc",
			         "4[ac]dy", 					   "acacacacdy",
			"3[2[ad]3[pf]]xyz", "adadpfpfpfadadpfpfpfadadpfpfpfxyz"
		};
		ExpressionExpand e = new ExpressionExpand();
		for(int i = 0; i < cases.length/2; i++)
			test(e, cases[i*2], cases[i*2+1]);
		
	}
	
}
