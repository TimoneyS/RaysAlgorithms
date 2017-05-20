package object;

import java.awt.Graphics2D;

public abstract class Item {
	protected boolean alive;
	protected double x;				// x×ø±ê
	protected double y;				// y×ø±ê
	
	public Item() {
		alive = true;
	}
	
	public abstract void draw(Graphics2D g);
	public abstract void upDate();
	public void 	   die(){ alive = false;};
	public boolean isAlive(){ return alive;}
	public double getX() { return x; }
	public double getY() { return y; }
	
}
