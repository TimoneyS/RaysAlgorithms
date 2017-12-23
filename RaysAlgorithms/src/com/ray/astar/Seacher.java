package com.ray.astar;

import java.util.*;

import static com.ray.astar.CellType.*;

import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * A * 算法的搜索方法
 * @author Ray
 * 
 */
public class Seacher {
	
	// private List<Cell> 	open;
	private PriorityQueue<Cell> open;
	private int[][] distTo;
	private int endRow, endCol;
	
	public Seacher(Map m, int startRow, int startCol, int endRow, int endCol) {
	    //open = new LinkedList<Cell>();
	    open = new PriorityQueue<Cell>();
	    distTo = new int[m.maxRow()][m.maxCol()];
	    
	    for (int i = 0; i < distTo.length; i++) {
	        for (int j = 0; j < distTo[i].length; j++) {
                distTo[i][j] = Integer.MAX_VALUE;
            }
        }
	    
	    this.endRow     = endRow;
	    this.endCol     = endCol;
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
    private void search(Map m, int startRow, int startCol, int endRow, int endCol) {
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
	
	public Deque<Cell> getPath(Map map) {
        Deque<Cell> stack = new LinkedList<Cell>();
    	Cell c = map.getCell(endRow, endCol);
    	while(c != null) {
    		stack.push(c);
    		c = c.parent;
    	}
    	
    	return stack;
    }

    public static void main(String[] args) {
        Map m = new Map(In.getProjectScanner(Global.MAP_PATH));
        Seacher s = new Seacher(m, 1, 1, 9, 9);
        
       for( Cell c : s.getPath(m)) {
           Out.pf("[%d,%d] -> ", c.rowNum,c.colNum);
       }
    }
	
}
