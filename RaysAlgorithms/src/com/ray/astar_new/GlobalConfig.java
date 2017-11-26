package com.ray.astar_new;

import static com.ray.astar_new.CellType.BLOCK;
import static com.ray.astar_new.CellType.CHOOSE;
import static com.ray.astar_new.CellType.CLOSE;
import static com.ray.astar_new.CellType.CURRENT_MIN;
import static com.ray.astar_new.CellType.OPEN;
import static com.ray.astar_new.CellType.TRAP;
import static com.ray.astar_new.CellType.UNCHECK;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class GlobalConfig {
	
	public static int xPix = 0;
	public static int yPix = 0;
	
	public static String MAP_PATH = System.getProperty("user.dir") + "/src/com/ray/astar_new/map.txt";
	public static boolean IS_AUTO = true;		// �Զ�/�ֶ��������ֶ������Ҫ���������һ����ִ����һ��������
	
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
	
	/**
	 * �ȴ��ķ���
	 * @param milliSec
	 */
    public static void sleep(int milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
}
