package com.ray.common.utils;

public class TestUtil {
	
	public static void assertEqual(Object a, Object b) {
		if(a.equals(b)) Out.pf("`%s` equals `%s`\n", a, b);
		else 			Err.pf("`%s` not equals `%s`", a, b);
	}
	
	public static void assertTrue(boolean result) {
		if(result) Out.p("result is true, expect true");
		else 	   Err.p("result is false, expect true");
	}
	
	public static void assertFalse(boolean result) {
		if(result) Err.p("result is true, expect false");
		else 	   Out.p(  "result is false, expect false");
	}
	
}
