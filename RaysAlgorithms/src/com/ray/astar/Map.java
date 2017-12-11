package com.ray.astar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.utils.Out;

public class Map {
    
    private int         rowNum, colNum;
    private Cell[][]    map;
    
    public Map(Scanner in) {
        rowNum    = in.nextInt();
        colNum    = in.nextInt();
        map  = new Cell[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) map[i][j] = Cell.create(i, j, in.nextInt());
            Out.p(Arrays.toString(map[i]));
        }
    }
    
    public Cell[][] cells() {
        return map;
    }
    
    public Cell getCell(int row, int col) {
        return map[row][col];
    }
    
    public int colNum() {
        return colNum;
    }
    
    public int rowNum() {
        return rowNum;
    }
    
    // я╟урвскО
    public List<Cell> adj(int i, int j) {
        List<Cell> chs = new LinkedList<Cell>();
        if (i > 0)          chs.add(map[i - 1][j]); // ио
        if (i < rowNum - 1)   chs.add(map[i + 1][j]); // об
        if (j > 0)          chs.add(map[i][j - 1]); // вС
        if (j < colNum - 1)   chs.add(map[i][j + 1]); // ср
        return chs;
    }
    
}
