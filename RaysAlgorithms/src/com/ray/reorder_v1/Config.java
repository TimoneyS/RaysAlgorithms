package com.ray.reorder_v1;

import java.awt.event.KeyEvent;

public class Config {
	public static int WIDTH = 400;
	public static int HEIGTH = 400;
	public static int SIZE = 3;
	public static int CELL_WIDTH = Math.min(WIDTH, HEIGTH)/SIZE;
	
	
	public static final int UP = KeyEvent.VK_W, DOWN = KeyEvent.VK_S, LEFT = KeyEvent.VK_A, RIGHT = KeyEvent.VK_D;
	public static final int RESET = KeyEvent.VK_F1;
	public static final int SAVE  = KeyEvent.VK_F5;
	public static final int LOAD  = KeyEvent.VK_F6;

	
	static void sleep(int milSecond) {
		try {
			Thread.sleep(milSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
