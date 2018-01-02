package com.rays.fun.astar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Deque;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.ray.common.utils.In;

@SuppressWarnings("serial")
public class AStarContentPanel extends JPanel {
	
    private Map map;
    private Seacher seacher;
	private Cell[][] cells;
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
				cells[y][x].changeState();
			}
			
		});
	}
	
	private void paintCell(Cell cell, Graphics g) {
		int w = Global.xPix;
		int h = Global.yPix;
		g.setColor(Global.COLOR_MAP.get(cell.stat));
		g.fillRect(cell.colNum*w , cell.rowNum*h, w, h);
		g.setColor(Color.BLACK);
		g.drawRect(cell.colNum*w , cell.rowNum*h, w, h);
		g.drawString(cell.inspect(), cell.colNum*w+w/4, cell.rowNum*h + h/2);
	}
	
	public void generateMap(String path) {
	    map = new Map(In.getProjectScanner(path));
	    
        this.cells = map.cells();
        yNum = cells.length;
        xNum = cells[0].length;

        Global.xPix = getWidth() / xNum;
        Global.yPix = getHeight() / yNum;
	}
	
	public void startSearch(int sRow, int sCol, int eRow, int eCol) {
	    seacher = new Seacher(map, sRow, sCol, eRow, eCol);
	}
	
	public Deque<Cell> getPath(int eRow, int eCol) {
	    return seacher.getPath(map, eRow, eCol);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (cells==null) return;
		
	    for (Cell[] row : cells)
	        for (Cell cell : row)
	            paintCell(cell, g);
	}
}
