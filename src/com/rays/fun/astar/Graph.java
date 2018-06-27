package com.rays.fun.astar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.util.io.Out;

/**
 * 地图的抽象对象
 * @author rays1
 *
 */
public class Graph {
    
    private int         maxRow, maxCol;
    private Edge[][]    map;
    
    public Graph(Scanner in) {
        maxRow    = in.nextInt();
        maxCol    = in.nextInt();
        map  = new Edge[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) map[i][j] = Edge.create(i, j, in.nextInt());
            Out.p(Arrays.toString(map[i]));
        }
    }
    
    public Edge[][] cells() {
        return map;
    }
    
    public Edge getCell(int row, int col) {
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
    public List<Edge> adj(int row, int col) {
        List<Edge> chs = new LinkedList<Edge>();
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
    
}
