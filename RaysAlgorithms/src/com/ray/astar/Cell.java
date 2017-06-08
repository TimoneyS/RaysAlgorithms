package com.ray.astar;

public class Cell {
	public int 	i,		// 横坐标
				j,		// 纵坐标
				past,	// 从起点到该点的路程
				fore,	// 从终点到该点的路程预期
				cost;	// 该点的路程花费
	public CellType stat = CellType.UNCHECK;
	public Cell parent = null;

	public Cell(int i, int j, int type) {
		this.i = i;
		this.j = j;
		cost = 1;
		switch (type) {
		case 1 : stat = CellType.BLOCK;break;
		}
	}
	public void initPath(int size) {
		fore = Math.abs(size - i - 1) + Math.abs(size - j - 1);
		if (past == 0 && parent != null)
			past = cost + parent.past;
	}

	public int sum() {
		return past + fore;
	}

	public void parse() {
		System.out.printf("[%2d,%2d]", i, j);
		System.out.print(" <- ");
		stat = CellType.CHOOSE;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(parent != null) parent.parse();
	}
	
	public String inspect() {
		return String.format("[%2d,%2d]\n[ %2d, %2d ,%2s]", i, j, past, fore, stat);
	}

}
