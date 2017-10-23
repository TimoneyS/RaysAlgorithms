package com.ray.utils;

public class TestUnit {
	
	public static void assertEqual(Object a, Object b) {
		if(a.equals(b)) Out.pf("`%s` equals `%s`\n", a, b);
		else 			Out.err(String.format("`%s` not equals `%s`", a, b));
	}
	
	public static void assertTrue(boolean result) {
		if(result) Out.p("result is true, expect true");
		else 	   Out.err("result is false, expect true");
	}
	
	public static void assertFalse(boolean result) {
		if(result) Out.err("result is true, expect false");
		else 	   Out.p(  "result is false, expect false");
	}
	
}
