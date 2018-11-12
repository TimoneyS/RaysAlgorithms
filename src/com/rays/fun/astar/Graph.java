package com.rays.fun.astar;

import java.util.Scanner;

/**
 * 地图的抽象对象
 * @author rays1
 *
 */
public class Graph {
    
    private int         width, height;
    private int[][]     blocks;
    
    public Graph(Scanner in) {
        
        width    = in.nextInt();
        height    = in.nextInt();
        
        blocks  = new int[width][height];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++)
                blocks[x][y] = in.nextInt();
        }
    }
    
    public int weight(int x, int y) {
        return blocks[x][y];
    }
    
    public int width() {
        return width;
    }
    
    public int height() {
        return height;
    }
    
    /**
     * 获取邻接点
     * @param row
     * @param col
     * @return
     */
    public int[][] adj(int row, int col) {
        
        int[][] arr = new int[4][2];
        int index = 0;
        
        if (row > 0)
            arr[index++] = new int[]{row - 1, col}; // 上
        if (row < width - 1)
            arr[index++] = new int[]{row + 1, col}; // 下
        if (col > 0)
            arr[index++] = new int[]{row, col - 1}; // 左
        if (col < height - 1)
            arr[index++] = new int[]{row, col + 1}; // 右
        
        int[][] chs = new int[index][2];
        
        for (int i = 0; i < index; i++) {
            chs[i] = arr[i];
        }
        return chs;
    }
    
    public int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
    
}
