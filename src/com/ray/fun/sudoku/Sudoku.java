package com.ray.fun.sudoku;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import com.ray.gui.FrameUtil;

/**
 * 
 * 数独自动机版本 1
 * 
 * 目前仅能解决，依靠基本限制就能解决的数独问题
 *          1. 即任意行、列、小九宫中不能有数字重复
 * 
 * @author rays1
 *
 */
public class Sudoku {
    
    public Sudoku() {
        JFrame frame = FrameUtil.commonFrame("Rays Sudoku");
        
        SudokuPanel p1 = new SudokuPanel(new Board("0.txt"));
        frame.add(p1);

        p1.checkMod();
        
        FrameUtil.showFrame(frame);
        FrameUtil.refreshFrame(frame, 100, TimeUnit.MILLISECONDS);
    }
    
    public static void main(String[] args) {
        new Sudoku();
    }
    
}
