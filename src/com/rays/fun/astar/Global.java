package com.rays.fun.astar;

import static com.rays.fun.astar.CellType.BLOCK;
import static com.rays.fun.astar.CellType.CHOOSE;
import static com.rays.fun.astar.CellType.CLOSE;
import static com.rays.fun.astar.CellType.CURRENT_MIN;
import static com.rays.fun.astar.CellType.OPEN;
import static com.rays.fun.astar.CellType.TRAP;
import static com.rays.fun.astar.CellType.UNCHECK;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Global {
	
	public static int xPix = 0;
	public static int yPix = 0;
	
	public static String MAP_PATH = "src/com/rays/fun/astar/map.txt";
	
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
