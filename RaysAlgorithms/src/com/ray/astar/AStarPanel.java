package com.ray.astar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AStarPanel extends JPanel  {
	private Cell[][] map;
	private int size;
	
	public AStarPanel() {
		this(600, 600);
	}
	
	public AStarPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
	}
	
	private void paintCell(Cell cell, Graphics g) {
		int w = getSize().width/size;
		int h = getSize().height/size;
		switch (cell.stat) {
		case UNCHECK	: g.setColor(Color.GRAY);break;
		case OPEN 		: g.setColor(Color.GREEN);break;
		case CLOSE 		: g.setColor(Color.DARK_GRAY);break;
		case CHOOSE 	: g.setColor(Color.PINK);break;
		case BLOCK		: g.setColor(Color.BLACK);break;
		}
		g.fillRect(cell.j*w , cell.i*h, w, h);
		g.setColor(Color.BLACK);
		g.drawRect(cell.j*w , cell.i*h, w, h);
		g.drawString(cell.inspect(), cell.j*w+w/4, cell.i*h + h/2);
	}
	
	public void registerMap (Cell[][] map) {
		this.map = map;
		size = map.length;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (map!=null) for (Cell[] row : map) for (Cell cell : row) paintCell(cell, g);
	}
}
