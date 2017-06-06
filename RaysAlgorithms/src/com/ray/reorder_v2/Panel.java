package com.ray.reorder_v2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import static com.ray.reorder_v2.Board.DIR;

/**
 * 主要负责处理界面的类
 * @author Ray
 *
 */
@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	private Board board;
	private int size;
	private int cell_width;
	private Font currFont;
	
	public Panel() {
		size = Config.SIZE;
		cell_width = Config.CELL_WIDTH;
		currFont = new Font("微软雅黑",Font.BOLD, size * 10);
		
		board = new Board(size);
		board.reset();
		
		requestFocusInWindow();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c = g.getColor();
		g.setFont(currFont);
		
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){
				int num = board.getNum(i, j);
				if(num == size*size){
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
	
	public KeyListener getKeyListener(){
		return new KeyAdapter(){
			public void keyPressed(KeyEvent e) { 
					// 定义一些键盘事件对应的操作
					switch(e.getKeyCode()){
					case Config.UP         : board.move(DIR[0]);break;
					case Config.DOWN       : board.move(DIR[1]);break;
					case Config.LEFT       : board.move(DIR[2]);break;
					case Config.RIGHT      : board.move(DIR[3]);break;
					case KeyEvent.VK_F1    : board.reset();break;
					case KeyEvent.VK_F2    : ;break;
					case KeyEvent.VK_F10 :   ;break;
					}
					board.get_dist();
				
				repaint();
			}
		};
	}
	
}
