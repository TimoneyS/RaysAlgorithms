package com.rays.fun.astar;

import java.util.Deque;
import java.util.LinkedList;

import com.ray.io.In;
import com.ray.util.Timer;
import com.ray.util.collections.RaysIndexMinPQ;

/**
 * A * 算法的搜索方法
 * @author Ray
 * 
 */
public class AStarSeacher {
	
    private RaysIndexMinPQ<Integer> open;
    
    private int                     width;
    private int                     height;
    private int[][]                 distTo;
    private int[][]                 manhattanDist;
    private boolean[][]             isClose;
    private int[][][]               pathTo;
	
	public AStarSeacher(Graph G, int sX, int sY, int tX, int tY) {
	    
	    width = G.width();
	    height = G.height();
	    
	    open = new RaysIndexMinPQ<Integer>(G.height() * G.width());
	    
        distTo = new int[width][height];
        manhattanDist = new int[width][height];
        isClose = new boolean[width][height];
        pathTo = new int[width][height][2];
	    
        pathTo[sX][sY][0] = -1;
        pathTo[sX][sY][1] = -1;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                distTo[i][j] = -1;
            }
        }
        
	    search( G, sX, sY, tX, tY);
	 
    }
	
	/**
	 * A*算法，搜索算法
	 * @param G
	 * @param sX
	 * @param sY
	 * @param tX
	 * @param tY
	 */
    private void search(Graph G, int sX, int sY, int tX, int tY) {
        
        distTo[sX][sY] = 0;
        manhattanDist[sX][sY] = G.manhattanDistance(sX, sY, tX, tY);
        open.insert(toIndex(sX, sY), distTo[sX][sY] + manhattanDist[sX][sY] + G.weight(sX, sY));
        
        while (!open.isEmpty()) {
            int min = open.delMin();
            int minX = toX(min);
            int minY = toY(min);
            
            for (int[] pos : G.adj(minX, minY)) {       // 解析可达节点
                
                int x = pos[0];
                int y = pos[1];
                int v = G.weight(x, y);
                
                if ( v == 9 || v < 0 || isClose[x][y]) continue;
                
                if (distTo[x][y] == -1 || distTo[minX][minY] + v < distTo[x][y]) {
                    distTo[x][y] = distTo[minX][minY] + v;
                    
                    pathTo[x][y][0] = minX;
                    pathTo[x][y][1] = minY;
                    
                    open.insert(toIndex(x,y), distTo[x][y] + G.manhattanDistance(x, y, tX, tY));
                }
            }
            
            isClose[minX][minY] = true;

        }

    }
	
	public Deque<int[]> getPath(Graph G, int tX, int tY) {
        Deque<int[]> stack = new LinkedList<int[]>();
        int x = tX;
        int y = tY;
        
    	while(true) {
            stack.push(new int[] {x, y});
            int[] pos = pathTo[x][y];
            
            x = pos[0];
            y = pos[1];
            
            if (x == -1 && y == -1) break;
            
    	}
    	
    	return stack;
    }

    private int toIndex(int x, int y) {
        return x * width + y;
    }
    
    private int toX(int index) {
        return index / width;
    }
    
    private int toY(int index) {
        return index % width;
    }
	
    public static void main(String[] args) {
        Graph m = new Graph(In.getClassPathScanner(Graph.class, "map2.txt"));
        
        Timer t = Timer.create();
        
        t.click();
        AStarSeacher s = new AStarSeacher(m, 1, 0, 25, 25);
        s.getPath(m, 25, 25);
        t.click();
        
        t.show();
//        for (int[] c : s.getPath(m, 25, 25)) {
//            Out.pf("[%d,%d] -> ", c[0], c[1]);
//        }

    }
	
}
