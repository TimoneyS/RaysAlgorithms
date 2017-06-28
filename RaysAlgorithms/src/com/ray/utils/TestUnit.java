package com.ray.utils;

public class TestUnit {
	
	public static void assertEqual(Object a, Object b) {
		if(a.equals(b)) StdOut.pf("`%s` equals `%s`\n", a, b);
		else 			StdOut.err(String.format("`%s` not equals `%s`", a, b));
	}
	
	public static void assertTrue(boolean result) {
		if(result) StdOut.p("result is true, expect true");
		else 	   StdOut.err("reult is false, expect true");
	}
	
	public static void assertFalse(boolean result) {
		if(result) StdOut.err("result is true, expect false");
		else 	   StdOut.p(  "result is false, expect false");
	}
	
}
