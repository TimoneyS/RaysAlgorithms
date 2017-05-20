package object;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import global.Conf;

public class Explode extends Item{
	private double state = 1;				//״̬�������������е����̶ֳȵı�־
	private	final double x,y;				//��ը������λ��

	public Explode (double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public void draw(Graphics2D g2) {	
		int radius = Conf.MaxExplodRadius;								
		if(state>(radius*4/5)) g2.setColor(Color.RED);					//��ը�׶�5��ɫ
			else if(state>(radius*3/5)) g2.setColor(Color.ORANGE);		//��ը�׶�4��ɫ	
			else if(state>(radius*2/5)) g2.setColor(Color.YELLOW);		//��ը�׶�3��ɫ
			else if(state>(radius*1/5)) g2.setColor(Color.WHITE);		//��ը�׶�2��ɫ
			else g2.setColor(Color.CYAN);								//��ը�׶�1��ɫ
		double size = Conf.SIZE;
		Ellipse2D s = new Ellipse2D.Double(								//������״
				x-state*size/5, y-state*size/5, state*size/2.5, state*size/2.5);
		
		g2.fill(s);														//�����״
	}
	@Override
	public void upDate() {
		state = state + Conf.EXPLODE_SPEED;
		if(state > Conf.MaxExplodRadius)
			die();
	}
	
}