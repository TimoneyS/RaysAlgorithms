package com.ray.astar;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Cell extends JComponent {
	public int 	i,		// 横坐标
				j,		// 纵坐标
				past,	// 从起点到该点的路程
				fore,	// 从终点到该点的路程预期
				cost;	// 该点的路程花费
	public CellType stat = CellType.UNCHECK;
	public Cell parent = null;

	public Cell(int i, int j, int type) {
		this.i = i;
		this.j = j;
		cost = 1;
		switch (type) {
		case 1 : stat = CellType.BLOCK;break;
		}
		setBorder(BorderFactory.createEtchedBorder());	
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getSize().width;
		int h = getSize().height;
		
		switch (stat) {
		case UNCHECK	: g.setColor(Color.GRAY);break;
		case OPEN 		: g.setColor(Color.GREEN);break;
		case CLOSE 		: g.setColor(Color.DARK_GRAY);break;
		case CHOOSE 	: g.setColor(Color.PINK);break;
		case BLOCK		: g.setColor(Color.BLACK);break;
		}
		g.fillRect(0 , 0, w, h);
		
		g.setColor(Color.BLACK);
		g.drawString(String.format("[ %d, %d ,%2s]",i,j,stat), w/3, h/2);
	}

	public void initPath(int size) {
		fore = Math.abs(size - i - 1) + Math.abs(size - j - 1);
		if (past == 0 && parent != null)
			past = cost + parent.past;
	}

	public int sum() {
		return past + fore;
	}

	public void parse() {
		System.out.printf("[%2d,%2d]", i, j);
		if (parent != null) {
			System.out.print(" <- ");
			stat = CellType.CHOOSE;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			parent.parse();
		}
	}

}
