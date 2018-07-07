package com.rays.fun.astar;

import java.util.Deque;
import java.util.LinkedList;

import com.ray.common.collections.RaysIndexMinPQ;
import com.ray.io.In;
import com.ray.io.Out;

/**
 * A * 算法的搜索方法
 * @author Ray
 * 
 */
public class Seacher {
	
    private RaysIndexMinPQ<Double> open;
    private int[]                  pathTo;
    private boolean[]              isClose;
    private double[]               distToS;
    private double[]               distToE;
    private double[]               costWith;
	
	public Seacher(Graph m, int startRow, int startCol, int endRow, int endCol) {
	    
	    int V = m.maxRow()*m.maxCol(); 
	    
	    open = new RaysIndexMinPQ<Double>(V);
	    pathTo  = new int[V];
	    distToS = new double[V];
	    distToE = new double[V];
	    costWith = new double[V];;
	    isClose  = new boolean[V];;
	    
	    for (int i = 0; i < distToE.length; i++) {
            distToE[i] = Integer.MAX_VALUE;
            pathTo[i] = -1;
        }
	    
	    search( m, startRow, startCol, endRow, endCol);
    }
	
	/**
	 * A*算法，搜索算法
	 * @param G
	 * @param startRow
	 * @param startCol
	 * @param endRow
	 * @param endCol
	 */
    private void search(Graph G, int startRow, int startCol, int endRow, int endCol) {
        
        int startIndex = G.toIndex(startRow, startCol);
        
        distToS[startIndex] = 0;
        distToE[startIndex] = G.manhattan(startRow, startCol, endRow, endCol);
        costWith[startIndex] = distToS[startIndex] +  distToE[startIndex];
        
        open.insert(startIndex, costWith[startIndex]);
        
        while (!open.isEmpty()) {
            int min = open.delMin();
            for (Cell cell : G.adj(G.toX(min), G.toY(min))) {       // 解析可达节点
                
                int current = G.toIndex(cell.x(), cell.y());
                
                if (cell.getCellType().equals(CellType.WALL) || isClose[current])
                    continue;
                
                if (pathTo[current] == -1) {
                    distToS[current] = distToS[min] + cell.weight();
                    distToE[current] = G.manhattan(cell.x(), cell.y(), endRow, endCol);
                    
                    costWith[current] = distToS[current] +  distToE[current];
                    pathTo[current] = min;
                    
                    open.insert(current, costWith[current]);
                } else if (costWith[pathTo[current]] < costWith[pathTo[min]]) {
                    pathTo[min] = current;
                }
            }
            
            isClose[min] = true;

        }

    }
	
	public Deque<Cell> getPath(Graph G, int eRow, int eCol) {
	    
        Deque<Cell> stack = new LinkedList<Cell>();
    	
        int index = G.toIndex(eRow, eCol);
//        stack.push(G.getCell( G.toX(index), G.toY(index)));
        
    	while(pathTo[index] != -1) {
            Cell c = G.getCell( G.toX(index), G.toY(index));
            stack.push(c);
            index = pathTo[index];
    	}
    	
    	return stack;
    }

    public static void main(String[] args) {
        Graph m = new Graph(In.getProjectScanner(Global.MAP_PATH));
        Seacher s = new Seacher(m, 0, 0, 4, 4);

        for (Cell c : s.getPath(m, 4, 4)) {
            Out.pf("[%d,%d] -> ", c.x(), c.y());
        }

    }
	
}
