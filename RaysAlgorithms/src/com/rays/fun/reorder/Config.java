package com.rays.fun.reorder;

public class Config {
	public static int WIDTH = 400;
	public static int HEIGTH = 400;
	public static int SIZE = 3;
	public static int CELL_WIDTH = Math.min(WIDTH, HEIGTH)/SIZE;
	
	static void sleep(int milSecond) {
		try {
			Thread.sleep(milSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
