package com.ray.astar;

import static com.ray.astar.CellType.BLOCK;
import static com.ray.astar.CellType.CHOOSE;
import static com.ray.astar.CellType.CLOSE;
import static com.ray.astar.CellType.CURRENT_MIN;
import static com.ray.astar.CellType.OPEN;
import static com.ray.astar.CellType.TRAP;
import static com.ray.astar.CellType.UNCHECK;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Global {
	
	public static int xPix = 0;
	public static int yPix = 0;
	
	public static String MAP_PATH = System.getProperty("user.dir") + "/src/com/ray/astar/map.txt";
	public static boolean IS_AUTO = true;		// 自动/手动搜索，手动情况下要主动点击下一步来执行下一步的搜索
	
	public static Map<CellType, Color> COLOR_MAP;
	
	static {
		COLOR_MAP = new HashMap<CellType, Color>();
		COLOR_MAP.put(UNCHECK, 		Color.GRAY);
		COLOR_MAP.put(OPEN, 		Color.GREEN);
		COLOR_MAP.put(CLOSE, 		Color.DARK_GRAY);
		COLOR_MAP.put(CHOOSE, 		Color.PINK);
		COLOR_MAP.put(BLOCK, 		Color.BLACK);
		COLOR_MAP.put(TRAP, 		Color.RED);
		COLOR_MAP.put(CURRENT_MIN, 	Color.CYAN);
	}
	
}
