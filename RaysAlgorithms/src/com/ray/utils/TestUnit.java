package com.ray.utils;

public class TestUnit {
	
	public static void assertEqual(Object a, Object b) {
		if(a.equals(b)) StdOut.pf("`%s` equals `%s`\n", a, b);
		else 			StdOut.err(String.format("`%s` not equals `%s`", a, b));
	}
	
	
}
