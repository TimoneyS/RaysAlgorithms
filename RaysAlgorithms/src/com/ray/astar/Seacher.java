package com.ray.astar;

import java.util.*;

import static com.ray.astar.CellType.*;

import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * A * �㷨�Ĺ�����ʾ
 * @author Ray
 * 
 */
public class Seacher {
	
	private List<Cell> 	open;
	private boolean[][] marked;
	private int startRow, startCol, endRow, endCol;
	
	public Seacher(Map m, int x1, int y1, int x2, int y2) {
	    marked  = new boolean[m.rowNum()][m.colNum()];
	    open = new LinkedList<Cell>();
	    
	    startRow   = x1;
	    startCol   = y1;
	    endRow     = x2;
	    endCol     = y2;
	    
	    search( m, startRow, startCol, endRow, endCol);
	    
    }
	
	// �� open�б���ȡ�� "��С"��Ԫ��
	private Cell findMin() {
		Cell min = null;
		for (Cell cell : open) {
			cell.initPath(endRow, endCol);
			if (min == null || min.sum() > cell.sum()) min = cell; 
		}
		if (min!=null) min.stat = CURRENT_MIN;
		return min;
	}
	
	// �㷨����
	private void search(Map m, int startRow, int startCol, int endRow, int endCol) {
		// ��ʼ����
		open.add(m.getCell(startRow, startCol));
		if (!Global.IS_AUTO) return;
		while (open.size() != 0) {
		    
		      Cell cellMin            = findMin();                            // �ҵ���ǰСԪ��
		        List<Cell> children     = m.adj(cellMin.x, cellMin.y);        // ���ɿɴ�Ԫ���б�
		        parseChildren(children, cellMin);                             // �����ɴ�Ԫ���б�
		        cellMin.stat    = CLOSE;                                      // �ر���СԪ��
		        open.remove(cellMin);
		    
		}
		
	}
	
	public LinkedList<Cell> getPath(Map m) {
		LinkedList<Cell> stack = new LinkedList<Cell>();
		
		Cell c = m.getCell(endRow, endCol);
		while(c != null) {
			stack.push(c);
			c = c.parent;
		}
		
		return stack;
	}
	
	
	// �����ɴ��Ԫ���б�
	private void parseChildren(List<Cell> chs, Cell min) {
		for (Cell child : chs) {
			if (child.isTypes(CLOSE, BLOCK)) continue;
			if (child.parent == null) {
				open.add(child);
				child.stat = OPEN;
				child.setParent(min);
			} else if (child.sum() < min.parent.sum()) {
				 min.setParent(child);
			}
		}
	}
	
	public static void main(String[] args) {
        Map m = new Map(In.getProjectScanner(Global.MAP_PATH));
        Seacher s = new Seacher(m, 0, 0, m.rowNum()-1, m.colNum() -1);
        
       for( Cell c : s.getPath(m)) {
           Out.pf("[%d,%d] -> ", c.x,c.y);
       }
    }
	
}
