package com.ray.reorder_v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
	
	private Board board;
	private int size;
	private int cell_width;
	private Font currFont;
	
	public BoardPanel() {
		size = Config.SIZE;
		cell_width = Config.CELL_WIDTH;
		currFont = new Font("Î¢ÈíÑÅºÚ",Font.BOLD, size * 10);
		
		board = new Board(size);
		board.reset();
		
		requestFocusInWindow();
		
	}
	
	public KeyListener getKeyListener(){
		return new KeyAdapter(){
			public void keyPressed(KeyEvent e) { 
				board.action(e.getKeyCode()); 
				repaint();
			}
		};
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = g.getColor();
		g.setFont(currFont);
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){
				int num = board.getNum(i, j);
				if(num == 0){
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(j*cell_width, i*cell_width, cell_width, cell_width);
				} else {
					g.setColor(Color.GRAY);
					g.fillRect(j*cell_width, i*cell_width, cell_width, cell_width);
					g.setColor(Color.BLACK);
					g.drawString(String.valueOf(num), j*cell_width+cell_width/2, i*cell_width+cell_width/2);
				}
			}
		}
		
		g.setColor(Color.BLACK);
		for(int i = 0; i <= size; i ++){
			g.drawLine(0, i*cell_width, size*cell_width, i*cell_width);
			g.drawLine(i*cell_width, 0, i*cell_width, size*cell_width);
		}
		g.setColor(c);
	}
	
}
