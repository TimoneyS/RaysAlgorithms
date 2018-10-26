package com.rays.fun.astar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.ray.util.TimeUnit;

public class Painter {
    
    private Graph G;
    private JFrame frame;
    private BufferedImage offscreenImage;
    private BufferedImage onscreenImage;
    private Graphics2D offGraph;
    private Graphics2D onGraph;
    private int width;
    private int height;
    private AStarSeacher seacher;
    private int bw;
    private int bh;
    
    public Painter() {
        
        width = 800;
        height = 800;
        
        if (frame != null) frame.setVisible(false);
        frame = new JFrame();
        offscreenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        onscreenImage  = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        offGraph = offscreenImage.createGraphics();
        onGraph  = onscreenImage.createGraphics();
        offGraph.setColor(Color.WHITE);
        offGraph.fillRect(0, 0, width, height);
        
        offGraph.setColor(Color.BLACK);
        
        BasicStroke stroke = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        offGraph.setStroke(stroke);
        
        // frame stuff
        ImageIcon icon = new ImageIcon(onscreenImage);
        JLabel draw = new JLabel(icon);

        frame.setContentPane(draw);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            // closes all windows
        frame.setTitle("Standard Draw");
        frame.pack();
        frame.requestFocusInWindow();
        frame.setVisible(true);
        
    }
    
    public void bindGraph(Graph G) {
        this.G = G;
        bw = width/G.width();
        bh = height/G.height();
    }
    
    public void bindSeacher(AStarSeacher seacher) {
        this.seacher = seacher;
    }
    
    public void paint() {
        paintGraph();
            
        show();
    }
    
    private void paintGraph() {
        for (int i = 0; i < G.height(); i++) {
            for (int j = 0; j < G.width(); j++) {
                
                Color c = null;
                if (G.weight(i, j) == 1)
                    c = Color.LIGHT_GRAY;                    
                else
                    c = Color.DARK_GRAY;
                
                Shape s = new Rectangle2D.Double(j*bw, i*bh, bw, bh);
                
                drawShape(s, c);
            }
        }
        
        if (seacher != null) {
            int sx = seacher.getsX();
            int sy = seacher.getsY();
            int tx = seacher.gettX();
            int ty = seacher.gettY();
            
            drawShape(new Rectangle2D.Double(sy*bw, sx*bh, bw, bh), Color.RED);
            drawShape(new Rectangle2D.Double(ty*bw, tx*bh, bw, bh), Color.GREEN);
            
        }
        
    }
    
    public void paintPath() {
          for (int[] c : seacher.getPath(G)) {
              
              paintGraph();
              
              drawShape(new Rectangle2D.Double(c[1]*bw, c[0]*bh, bw, bh), Color.GREEN);
              
              show();
              
              TimeUnit.MILL_SECOND.sleep(100);
              
          }
    }
    
    private void drawShape(Shape s, Color color) {
        offGraph.setColor(color);
        offGraph.fill(s);
        offGraph.setColor(Color.BLACK);
        offGraph.draw(s);
    }
    
    public void show() {
        onGraph.drawImage(offscreenImage, 0, 0, null);
        frame.repaint();
    }
    
}
