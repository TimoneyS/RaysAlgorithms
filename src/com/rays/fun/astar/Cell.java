package com.rays.fun.astar;

public class Cell implements Comparable<Cell> {

    private int    x;        // 行数
    private int    y;        // 列数
    private double weight;   // 该点权重
    private CellType  cellType; // 该点类型

	private Cell(int row, int col, int type) {
		
	    this.x = row;
		this.y = col;
		
		switch (type) {
		case 1 	: 
		    weight = Double.POSITIVE_INFINITY;
		    cellType = CellType.WALL;
		    break;
		case 2 	: 
		    weight = 2;
		    cellType = CellType.TRAP;
		    break;
		default : 
		    weight = 1;
		    cellType = CellType.GROUND;
		    break;
		}
		
	}
	
	public int x() {
	    return x;
	}
	
	public int y() {
	    return y;
	}
	
	public double weight() {
	    return weight;
	}
	
	public static Cell create(int row, int col, int type) { 
	    return new Cell( row, col, type);
	}
	
	public CellType getCellType() {
        return cellType;
    }
	
	public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
	
    @Override
    public int compareTo(Cell o) {
        return 0;
    }
    
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

}
