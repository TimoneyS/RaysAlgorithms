package com.rays.fun.astar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.util.io.Out;

/**
 * ��ͼ�ĳ������
 * @author rays1
 *
 */
public class Map {
    
    private int         maxRow, maxCol;
    private Cell[][]    map;
    
    public Map(Scanner in) {
        maxRow    = in.nextInt();
        maxCol    = in.nextInt();
        map  = new Cell[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) map[i][j] = Cell.create(i, j, in.nextInt());
            Out.p(Arrays.toString(map[i]));
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
     * ��ȡ�ڽӵ�
     * @param row
     * @param col
     * @return
     */
    public List<Cell> adj(int row, int col) {
        List<Cell> chs = new LinkedList<Cell>();
        if (row > 0)
            chs.add(map[row - 1][col]); // ��
        if (row < maxRow - 1)
            chs.add(map[row + 1][col]); // ��
        if (col > 0)
            chs.add(map[row][col - 1]); // ��
        if (col < maxCol - 1)
            chs.add(map[row][col + 1]); // ��
        return chs;
    }
    
}
