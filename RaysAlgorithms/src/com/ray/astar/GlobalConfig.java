package com.ray.astar;

public class GlobalConfig {
	
	public static int xPix = 0;
	public static int yPix = 0;
	
	public static String MAP_PATH = System.getProperty("user.dir") + "/src/com/ray/astar/map.txt";
	public static boolean IS_AUTO = false;		// 自动/手动搜索，手动情况下要主动点击下一步来执行下一步的搜索
}
