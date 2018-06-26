package com.rays.fun.astar;

import static com.rays.fun.astar.CellType.*;

import java.util.*;

import com.ray.util.io.In;
import com.ray.util.io.Out;

/**
 * A * 算法的搜索方法
 * @author Ray
 * 
 */
public class Seacher {
	
	private PriorityQueue<Cell> open;
	private int[][] distTo;
	
	public Seacher(Graph m, int startRow, int startCol, int endRow, int endCol) {
	    open = new PriorityQueue<Cell>();
	    distTo = new int[m.maxRow()][m.maxCol()];
	    
	    for (int i = 0; i < distTo.length; i++) {
	        for (int j = 0; j < distTo[i].length; j++) {
                distTo[i][j] = Integer.MAX_VALUE;
            }
        }
	    
	    search( m, startRow, startCol, endRow, endCol);
    }
	
	/**
	 * A*算法，搜索算法
	 * @param m
	 * @param startRow
	 * @param startCol
	 * @param endRow
	 * @param endCol
	 */
    private void search(Graph m, int startRow, int startCol, int endRow, int endCol) {
        // 初始步骤
        Cell s = m.getCell(startRow, startCol);
        s.initPath(endRow, endCol);
        
        open.add(s);

        while (open.size() != 0) {
            Cell min = open.poll();                                     // 找到当前节点
            for (Cell cell : m.adj(min.rowNum, min.colNum)) {           // 解析可达节点
                if (cell.isTypes(CLOSE, BLOCK)) continue;
                if (cell.parent == null) {
                    cell.initPath(endRow, endCol);
                    cell.open();
                    cell.setParent(min);
                    open.add(cell);
                } else if (cell.costWithThis() < min.parent.costWithThis()) {
                     min.setParent(cell);
                }
            }
            min.close();                                                // 关闭最小节点
        }

    }
	
	public Deque<Cell> getPath(Graph map, int eRow, int eCol) {
        Deque<Cell> stack = new LinkedList<Cell>();
    	Cell c = map.getCell(eRow, eCol);
    	while(c != null) {
    		stack.push(c);
    		c = c.parent;
    	}
    	return stack;
    }

    public static void main(String[] args) {
        Graph m = new Graph(In.getProjectScanner(Global.MAP_PATH));
        Seacher s = new Seacher(m, 1, 1, 9, 9);
        
       for( Cell c : s.getPath(m, 9, 9)) {
           Out.pf("[%d,%d] -> ", c.rowNum,c.colNum);
       }
    }
	
}
