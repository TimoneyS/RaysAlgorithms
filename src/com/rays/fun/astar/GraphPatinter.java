package com.rays.fun.astar;

import java.awt.Color;
import java.awt.Graphics;

import com.ray.util.io.Out;

public class GraphPatinter {

    private Graph G;

    public void paint(Graphics g) {
        for (Cell[] row : G.cells())
            for (Cell cell : row)
                paintCell( g, cell);
    }

    public void paintCell(Graphics g, Cell cell) {
        int w = Global.xPix;
        int h = Global.yPix;
        g.setColor(Global.COLOR_MAP.get(cell.getCellType()));
        g.fillRect(cell.y() * w, cell.x() * h, w, h);
        g.setColor(Color.BLACK);
        g.drawRect(cell.y() * w, cell.x() * h, w, h);
        // g.drawString(cell.inspect(), cell.y()*w+w/4, cell.x()*h + h/2);
    }

    public void setG(Graph g) {
        G = g;
    }

    public void paint(Graphics g, Mouse mouse) {
        
        int w = Global.xPix;
        int h = Global.yPix;
        
        int width = Global.xPix/2;
        g.setColor(new Color(59, 172, 230));
        
        g.fillRect(mouse.y() * w + width/2, mouse.x() * h + width/2, width, width);
        
    }

}
