package com.rays.fun.reorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

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
		currFont = new Font("微软雅黑", Font.BOLD, size * 10);
		board = new Board(size);
		
		requestFocusInWindow();
        setPreferredSize(new Dimension(Config.WIDTH, Config.HEIGHT));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color bak_color = g.getColor();
		Font  bak_font  = g.getFont();
		
		g.setFont(currFont);
		
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){
				int num = board.getNum(i, j);
				if(num == size*size-1){
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
		g.setFont(bak_font);
		g.setColor(bak_color);
	}
	
	public KeyListener getKeyListener(){
		return new KeyAdapter(){
			public void keyPressed(KeyEvent e) { 
				// 定义一些键盘事件对应的操作
				switch(e.getKeyCode()){
    				case KeyEvent.VK_W   : board.move(Dir.UP);break;
    				case KeyEvent.VK_S   : board.move(Dir.DOWN);break;
    				case KeyEvent.VK_A   : board.move(Dir.LEFT);break;
    				case KeyEvent.VK_D   : board.move(Dir.RIGHT);break;
    				case KeyEvent.VK_F1  : board.reset();break;
    				case KeyEvent.VK_F2  : board.shuffe();break;
    				case KeyEvent.VK_F10 : board.reorder();break;
				}
			}
		};
	}
	
}
