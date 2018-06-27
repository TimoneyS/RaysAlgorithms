package com.rays.fun.astar;

public class Edge implements Comparable<Edge> {
	
    public int      rowNum;   // 行数
    public int      colNum;   // 列数
    public int      past;     // 从起点到该点的路程
    public int      forcast;  // 从终点到该点的路程预期
    public int      weighted; // 该点权重
    public CellType stat;
    public Edge     parent;

	private Edge(int row, int col, int type) {
		this.rowNum = row;
		this.colNum = col;
		
		switch (type) {
		case 1 	: stat = CellType.BLOCK;break;
		case 2 	: stat = CellType.TRAP;
				  weighted = 2;
				  break;
		default : stat = CellType.UNCHECK;weighted = 1;break;
		}
	}
	public static Edge create(int row, int col, int type) { return new Edge( row, col, type);}
	
	public void initPath(int endX, int endY) {
		forcast = Math.abs(endX - rowNum) + Math.abs(endY - colNum);
		if (past == 0 && parent != null)
			past = weighted + parent.past;
	}
	
	public void setParent(Edge parent) {
		this.past 	= parent.past + this.weighted;
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

	public int costWithThis() { return past + forcast; }

	public void parse() {
		System.out.printf("[%2d,%2d]", rowNum, colNum);
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
	
	public void close() {
	    stat = CellType.CLOSE;
	}
	
    public boolean isClosed() {
        return stat.equals(CellType.CLOSE);
    }
    
    public void open() {
        stat = CellType.OPEN;
    }
    
    public boolean isOpne() {
        return stat.equals(CellType.OPEN);
    }
	
	public String inspect() {
		return String.format("[%2d,%2d]\n[ %2d, %2d ,%2s]", rowNum, colNum, past, forcast, stat);
	}
	
	@Override
	public String toString() {
		return ( stat == CellType.BLOCK ) ? "1" : "0";
	}
    @Override
    public int compareTo(Edge o) {
        return Integer.valueOf(costWithThis()).compareTo(o.costWithThis());
    }

}
