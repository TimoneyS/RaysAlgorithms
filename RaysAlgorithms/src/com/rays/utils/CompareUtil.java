package com.rays.utils;

public class CompareUtil {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean less(Comparable x, Comparable y){
		return x.compareTo(y) > 0;
	}
	
}
