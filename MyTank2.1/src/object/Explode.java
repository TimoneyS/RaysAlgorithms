package object;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import global.Conf;

public class Explode extends Item{
	private double state = 1;				//×´Ì¬£¬ÃèÊö¶¯»­½øÐÐµ½ºÎÖÖ³Ì¶ÈµÄ±êÖ¾
	private	final double x,y;				//±¬Õ¨µÄÖÐÐÄÎ»ÖÃ

	public Explode (double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public void draw(Graphics2D g2) {	
		int radius = Conf.MaxExplodRadius;								
		if(state>(radius*4/5)) g2.setColor(Color.RED);					//±¬Õ¨½×¶Î5ÑÕÉ«
			else if(state>(radius*3/5)) g2.setColor(Color.ORANGE);		//±¬Õ¨½×¶Î4ÑÕÉ«	
			else if(state>(radius*2/5)) g2.setColor(Color.YELLOW);		//±¬Õ¨½×¶Î3ÑÕÉ«
			else if(state>(radius*1/5)) g2.setColor(Color.WHITE);		//±¬Õ¨½×¶Î2ÑÕÉ«
			else g2.setColor(Color.CYAN);								//±¬Õ¨½×¶Î1ÑÕÉ«
		double size = Conf.SIZE;
		Ellipse2D s = new Ellipse2D.Double(								//½¨Á¢ÐÎ×´
				x-state*size/5, y-state*size/5, state*size/2.5, state*size/2.5);
		
		g2.fill(s);														//Ìî³äÐÎ×´
	}
	@Override
	public void upDate() {
		state = state + Conf.EXPLODE_SPEED;
		if(state > Conf.MaxExplodRadius)
			die();
	}
	
}