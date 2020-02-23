package com.ray.fun.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.ray.io.Out;

public class Board {
    
    Cell[][] cells;
    
    public Board(String fileName) {
        
        try (Scanner sc = new Scanner(new File(Board.class.getResource(fileName).getFile()))) {
            cells = new Cell[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int n = sc.nextInt();
                    Out.pt(n + " ");
                    cells[i][j] = new Cell(n);

                }
                Out.p();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    public void check() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                check(i, j);
            }
        }
    }

    public void check(int x, int y) {
        if (cells[x][y].number > 0) return;
        for (int k = 0; k < 9; k ++) {
            cells[x][y].forbiden(cells[x][k].number); // if (k != y)
            cells[x][y].forbiden(cells[k][y].number); // if (k != x)
            cells[x][y].forbiden(cells[x / 3 * 3 + k / 3][y / 3 * 3 + k % 3].number); // if (i != x && j != y)
        }
    }
    
}

class Cell {
    
    int number;
    boolean[] avliable = new boolean[9];
    int       range    = 0;
    
    public Cell(int number) {
        this.number = number;
        if (number <= 0) {
            range = 9;
            Arrays.fill(avliable, true);
        } else {
            range = 1;
        }
    }

    public void forbiden(int number2) {
        
        if (number2 == 0) return;
        
        if (avliable[number2-1]) {
            range --;
            avliable[number2-1] = false;
        }
        if (range == 1 && number <= 0) {
            while (number++ <= 9) {
                if (avliable[number-1]) break;
            }
        }
        
    }
    
}