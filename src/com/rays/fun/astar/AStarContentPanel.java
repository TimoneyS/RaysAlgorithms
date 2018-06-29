package com.rays.fun.astar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Deque;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.ray.util.io.In;
import com.ray.util.io.Out;

@SuppressWarnings("serial")
public class AStarContentPanel extends JPanel {
	
    private Graph G;
    private GraphPatinter painter;
    private Seacher seacher;
    private Mouse mouse; 
    private long count = 0;
    private boolean mouseMoving;
    private Deque<Cell> mousePath;
	
	public AStarContentPanel(int width, int height) {
	    painter = new GraphPatinter();
	    
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addMouseListener(new MouseHandler());
		
	}
	
	public void generateMap(String path) {
	    
	    G = new Graph(In.getProjectScanner(path));
	    mouse =  new Mouse( 1, 0);
	    
	    painter.setG(G);
	    
        Global.xPix = getWidth() / G.maxCol();
        Global.yPix = getHeight() / G.maxRow();
        
	}
	
	private void mouseMoveTo(int eRow, int eCol) {
	    seacher = new Seacher(G, mouse.x(), mouse.y(), eRow, eCol);
	    mousePath = seacher.getPath(G, eRow, eCol);
	    mouseMoving = true;
	}
	
	private void mouseMoving(long count) {
	    if (!mouseMoving || count % 3 != 0) return;
	    
	    if (mousePath != null && mousePath.isEmpty()) {
	        mouseMoving = false;
	    } else {
	        Cell cell = mousePath.pop();
	        mouse.moveTo(cell.x(), cell.y());
	    }
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		painter.paint(g);
		painter.paint(g, mouse);
		mouseMoving(count);
		
		count ++;
	}
	
	class MouseHandler extends MouseAdapter {
	    
	    boolean click = false;
        
        @Override
        public void mousePressed(MouseEvent e) {
            
            if (click || mouseMoving) {
                Out.p("mouse is moving");
            } else {
                click = true;
                int y = e.getX()/Global.xPix;
                int x = e.getY()/Global.yPix;
                Out.pf("%d Click %2s %2s \n", new Date().getTime(), x, y);
                mouseMoveTo(x, y);
                click = false;
            }
            
        }
        
	}
	
}
