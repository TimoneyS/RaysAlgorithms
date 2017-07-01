package com.ray.astar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import static com.ray.astar.CellType.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.ray.utils.StdOut;

@SuppressWarnings("serial")
public class AStarContentPanel extends JPanel {
	
	private Cell[][] map;
	private int xNum, yNum;
	private static Map<CellType, Color> COLOR_MAP;
	
	static {
		COLOR_MAP = new HashMap<CellType, Color>();
		COLOR_MAP.put(UNCHECK, 		Color.GRAY);
		COLOR_MAP.put(OPEN, 		Color.GREEN);
		COLOR_MAP.put(CLOSE, 		Color.DARK_GRAY);
		COLOR_MAP.put(CHOOSE, 		Color.PINK);
		COLOR_MAP.put(BLOCK, 		Color.BLACK);
		COLOR_MAP.put(TRAP, 		Color.RED);
		COLOR_MAP.put(CURRENT_MIN, 	Color.CYAN);
	}
	
	public AStarContentPanel() {
		this(600, 600);
	}
	
	public AStarContentPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX()/GlobalConfig.xPix;
				int y = e.getY()/GlobalConfig.yPix;
				StdOut.pf("Click %2s %2s \n", x, y);
				map[y][x].changeState();
			}
			
		});
	}
	
	private void paintCell(Cell cell, Graphics g) {
		int w = GlobalConfig.xPix;
		int h = GlobalConfig.yPix;
		g.setColor(COLOR_MAP.get(cell.stat));
		g.fillRect(cell.y*w , cell.x*h, w, h);
		g.setColor(Color.BLACK);
		g.drawRect(cell.y*w , cell.x*h, w, h);
		g.drawString(cell.inspect(), cell.y*w+w/4, cell.x*h + h/2);
	}
	
	public void registerMap (Cell[][] map) {
		this.map = map;
		yNum = map.length;
		xNum  = map[0].length;
		
		GlobalConfig.xPix = getWidth()/xNum;
		GlobalConfig.yPix = getHeight()/yNum;
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (map!=null) for (Cell[] row : map) for (Cell cell : row) paintCell(cell, g);
	}
}
