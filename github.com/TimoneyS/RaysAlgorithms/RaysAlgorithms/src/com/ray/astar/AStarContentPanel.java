package com.ray.astar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AStarContentPanel extends JPanel {
	
	private Cell[][] map;
	private int xNum, yNum;
	
	public AStarContentPanel() {
		this(600, 600);
	}
	
	public AStarContentPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX()/Global.xPix;
				int y = e.getY()/Global.yPix;
				//StdOut.pf("%d %4s Click %2s %2s \n", new Date().getTime(), count++, x, y);
				map[y][x].changeState();
			}
			
		});
	}
	
	private void paintCell(Cell cell, Graphics g) {
		int w = Global.xPix;
		int h = Global.yPix;
		g.setColor(Global.COLOR_MAP.get(cell.stat));
		g.fillRect(cell.y*w , cell.x*h, w, h);
		g.setColor(Color.BLACK);
		g.drawRect(cell.y*w , cell.x*h, w, h);
		g.drawString(cell.inspect(), cell.y*w+w/4, cell.x*h + h/2);
	}
	
	public void registerMap (Cell[][] map) {
		this.map = map;
		yNum = map.length;
		xNum  = map[0].length;
		
		Global.xPix = getWidth()/xNum;
		Global.yPix = getHeight()/yNum;
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (map!=null) for (Cell[] row : map) for (Cell cell : row) paintCell(cell, g);
	}
}
