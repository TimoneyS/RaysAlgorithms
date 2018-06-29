package com.rays.fun.astar;

/**
 * 
 * @author rays1
 *
 */
public class Mouse {
    
    private Graph G;
    private int x;
    private int y;
    
    public Mouse(Graph g, int x, int y) {
        super();
        G = g;
        this.x = x;
        this.y = y;
    }
    
    public void moveUp()    { y-=1; }
    public void moveDown()  { y+=1; }
    public void moveLeft()  { x-=1; }
    public void moveRight() { x+=1; }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
    
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
                
    }
    
}
