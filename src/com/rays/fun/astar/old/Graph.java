package com.rays.fun.astar.old;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 地图的抽象对象
 * @author rays1
 *
 */
public class Graph {
    
    private int         maxRow, maxCol;
    private Cell[][]    map;
    
    public Graph(Scanner in) {
        maxRow    = in.nextInt();
        maxCol    = in.nextInt();
        map  = new Cell[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++)
                map[i][j] = Cell.create(i, j, in.nextInt());
        }
    }
    
    public Cell[][] cells() {
        return map;
    }
    
    public Cell getCell(int row, int col) {
        return map[row][col];
    }
    
    public int maxCol() {
        return maxCol;
    }
    
    public int maxRow() {
        return maxRow;
    }
    
    /**
     * 获取邻接点
     * @param row
     * @param col
     * @return
     */
    public List<Cell> adj(int row, int col) {
        List<Cell> chs = new LinkedList<Cell>();
        if (row > 0)
            chs.add(map[row - 1][col]); // 上
        if (row < maxRow - 1)
            chs.add(map[row + 1][col]); // 下
        if (col > 0)
            chs.add(map[row][col - 1]); // 左
        if (col < maxCol - 1)
            chs.add(map[row][col + 1]); // 右
        return chs;
    }
    
    public int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x2- x1) + Math.abs(y2-y1);
    }
    
    public int toIndex(int x, int y) {
        return x * maxRow + y;
    }
    
    public int toX(int index) {
        return index / maxRow;
    }
    
    public int toY(int index) {
        return index % maxCol;
    }
    
}
