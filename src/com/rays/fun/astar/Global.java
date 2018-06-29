package com.rays.fun.astar;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Global {
	
	public static int xPix = 0;
	public static int yPix = 0;
	
	public static String MAP_PATH = "src/com/rays/fun/astar_new/map.txt";
	
	public static Map<CellType, Color> COLOR_MAP;
	
	static {
		COLOR_MAP = new HashMap<CellType, Color>();
        COLOR_MAP.put(CellType.WALL, new Color(41, 49, 52));
        COLOR_MAP.put(CellType.TRAP, new Color(254, 54, 54));
        COLOR_MAP.put(CellType.GROUND, new Color(188, 142, 99));
        COLOR_MAP.put(CellType.PATH, new Color(255, 226, 139));
	}
	
}
