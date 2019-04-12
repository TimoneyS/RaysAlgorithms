package com.rays.fun.sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

@SuppressWarnings("serial")
public class SudokuPanel extends JPanel {
    
    Board board;
    
    public SudokuPanel(Board board) {
        this.board = board;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCrossLine(g);
        drawBoardNumber(g);
    }
    
    /**
     * 会面数字
     * @param g
     */
    private void drawBoardNumber(Graphics g) {
        
        int w = getWidth()/9;
        int h = getHeight()/9;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                drawCell(i, j, w, h, board.cells[i][j], g);
            }
        }
    }

    /**
     * 绘制单独的格子
     * @param i
     * @param j
     * @param w
     * @param h
     * @param cell
     * @param g
     */
    private void drawCell(int i, int j, int w, int h, Cell cell, Graphics g) {
        int block_size = Math.min(w, h);
        
        if (cell.number > 0) {
            g.setFont(new Font("黑体", Font.BOLD, block_size));
            g.drawString(cell.number+"", j*w, i*h+h);
        } else {
            g.setFont(new Font("黑体", Font.PLAIN, block_size/3));
            int idx = 0;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y ++) {
                    if (cell.avliable[idx]) {
                        g.drawString((idx+1)+"",  j*w + w * x / 3, (i+1)*h + h * (y-2) / 3);
                    }
                    idx ++;
                }
            }
        }
    }

    /**
     * 绘制大九宫和小九宫线条
     * @param g
     */
    private void drawCrossLine(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        
        g.setColor(Color.LIGHT_GRAY);
        
        for (int i = 0; i <= 9; i++) {
            if (i%3==0) continue;
            g.drawLine(w/9*i, 0, w/9*i, h);
            g.drawLine(0, h/9*i, w, h/9*i);
        }
        
        g.setColor(Color.DARK_GRAY);
        
        for (int i = 0; i <= 3; i++) {
            g.drawLine(w/3*i, 0, w/3*i, h);
            g.drawLine(0, h/3*i, w, h/3*i);
        }
        
    }
    
    PanelClickCheckListener checkListener = new PanelClickCheckListener();
    
    public void checkMod() {
        removeMouseListener(checkListener);
        addMouseListener(checkListener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(540, 540);
    }
    
    class PanelClickCheckListener extends MouseInputAdapter {
        
        @Override
        public void mouseClicked(MouseEvent e) {
            board.check();
        }
        
    }
    
}