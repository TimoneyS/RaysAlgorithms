package com.ray.astar;

public class Cell {
	
	public int 	x,		// 横坐标
				y,		// 纵坐标
				past,	// 从起点到该点的路程
				fore,	// 从终点到该点的路程预期
				cost;	// 该点的路程花费
	public CellType stat;
	public Cell parent;

	public Cell(int i, int j, int type) {
		this.x = i;
		this.y = j;
		
		switch (type) {
		case 1 	: stat = CellType.BLOCK;break;
		case 2 	: stat = CellType.TRAP;
				  cost = 2;
				  break;
		default : stat = CellType.UNCHECK;cost = 1;break;
		}
	}
	
	public void initPath(int endX, int endY) {
		fore = Math.abs(endX - x) + Math.abs(endY - y);
		if (past == 0 && parent != null)
			past = cost + parent.past;
	}
	
	public void setParent(Cell parent) {
		this.past 	= parent.past + this.cost;
		this.parent = parent;
	}
	
	public boolean isTypes(CellType...types) {
		for(CellType type : types) if (type == stat) return true;
		return false;
	}
	
	public boolean isNotTypes(CellType...types) {
		for(CellType type : types) if (type == stat) return false;
		return true;
	}

	public int sum() { return past + fore; }

	public void parse() {
		System.out.printf("[%2d,%2d]", x, y);
		System.out.print(" <- ");
		stat = CellType.CHOOSE;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(parent != null) parent.parse();
	}
	
	public void changeState() {
//		UNCHECK,
//		OPEN,
//		CLOSE,
//		TRAP,
//		BLOCK,
//		CHOOSE,
//		CURRENT_MIN,
		switch(stat) {
		case BLOCK:
			stat = CellType.TRAP;
			break;
		case TRAP:
			stat = CellType.UNCHECK;
			break;
		case UNCHECK:
			stat = CellType.BLOCK;
			break;
		default:
			break;
		}
		
		
	}
	
	public String inspect() {
		return String.format("[%2d,%2d]\n[ %2d, %2d ,%2s]", x, y, past, fore, stat);
	}
	
	@Override
	public String toString() {
		return ( stat == CellType.BLOCK ) ? "1" : "0";
	}

}
