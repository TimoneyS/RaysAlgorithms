package com.ray.astar;

import java.util.*;

import com.ray.common.utils.In;
import com.ray.common.utils.Out;

import static com.ray.astar.CellType.*;

/**
 * A * �㷨����������
 * @author Ray
 * 
 */
public class Seacher {
	
	// private List<Cell> 	open;
	private PriorityQueue<Cell> open;
	private int[][] distTo;
	
	public Seacher(Map m, int startRow, int startCol, int endRow, int endCol) {
	    //open = new LinkedList<Cell>();
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
	 * A*�㷨�������㷨
	 * @param m
	 * @param startRow
	 * @param startCol
	 * @param endRow
	 * @param endCol
	 */
    private void search(Map m, int startRow, int startCol, int endRow, int endCol) {
        // ��ʼ����
        Cell s = m.getCell(startRow, startCol);
        s.initPath(endRow, endCol);
        
        open.add(s);

        while (open.size() != 0) {
            Cell min = open.poll();                                     // �ҵ���ǰ�ڵ�
            for (Cell cell : m.adj(min.rowNum, min.colNum)) {           // �����ɴ�ڵ�
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
            min.close();                                                // �ر���С�ڵ�
        }

    }
	
	public Deque<Cell> getPath(Map map, int eRow, int eCol) {
        Deque<Cell> stack = new LinkedList<Cell>();
    	Cell c = map.getCell(eRow, eCol);
    	while(c != null) {
    		stack.push(c);
    		c = c.parent;
    	}
    	return stack;
    }

    public static void main(String[] args) {
        Map m = new Map(In.getProjectScanner(Global.MAP_PATH));
        Seacher s = new Seacher(m, 1, 1, 9, 9);
        
       for( Cell c : s.getPath(m, 9, 9)) {
           Out.pf("[%d,%d] -> ", c.rowNum,c.colNum);
       }
    }
	
}
