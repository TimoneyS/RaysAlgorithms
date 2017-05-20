package object.tank;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import global.Conf;
import map.BattleField;
import object.Bullet;
import object.CollideItem;
import object.Explode;

public abstract class Tank extends CollideItem {
	
	public Tank(double x, double y, double direction, Color color) {
		super(x, y, direction, color);
	}
	protected double xbak,ybak;						// ���ݵ� ����
	protected double moveState = 0;					// ����������̬Ч��
	
	public abstract double getMoveSpeed();
	
	public void fire() {
		BattleField.get().add(new Bullet(x, y, direction, color));
	}
	
	public void upDate() {
		move();
		collide(BattleField.get().getTanks());
		fire();
	}

	public void draw(Graphics2D g2){
		
		//����
		double size = Conf.SIZE;
		
		AffineTransform odlTramsform = g2.getTransform();	//��ת��������
		g2.rotate(direction, x, y);							//������ת�ĽǶȺ����ĵ�
		//������
		g2.setColor(getColor());
		Rectangle2D rbody = new  Rectangle2D.Double(x-3*size, y-3*size, 6*size, 6*size);
		g2.fill(rbody);
		g2.setColor(Color.BLACK);
		g2.draw(rbody);
		//����
		g2.setColor(Color.LIGHT_GRAY);
		Rectangle2D rweell = new Rectangle2D.Double(x-5*size, y-5*size, 2*size, 10*size);
		Rectangle2D rweelr = new Rectangle2D.Double(x+3*size, y-5*size, 2*size, 10*size);
		g2.fill(rweell);
		g2.fill(rweelr);
		g2.setColor(Color.BLACK);
		g2.draw(rweell);
		g2.draw(rweelr);
		//�Ĵ�
		double y2;
		for(int i = -2; i < 3; i++) {
			y2 = y + size*moveState/10 + size*2*i;
			g2.draw(new Line2D.Double(x-5*size, y2, x-3*size, y2));
			g2.draw(new Line2D.Double(x+5*size, y2, x+3*size, y2));
		}
		//�ڹ�
		g2.setColor(Color.DARK_GRAY);
		Rectangle2D rfire = new Rectangle2D.Double(x-0.4*size, y-8*size, 1*size, 8*size);
		g2.fill(rfire);
		//��̨
		Ellipse2D rfilePlat = new Ellipse2D.Double(x-1.5*size, y-1.5*size, 3*size, 3*size);
		g2.fill(rfilePlat);
		
		g2.setTransform(odlTramsform); //�ָ����ݵ���ת����
	}
	
	// �ƶ�����
	public void move() {
		double speed = getMoveSpeed();
		if(speed!=0) moveState+=(speed<0?0.5:-0.5);				//�Ĵ��仯
		moveState = (moveState+10)%10;
		locationSave();											//��������
		x += Math.sin(direction)*speed;							//����仯
		y -= Math.cos(direction)*speed;			
	}
	
	// ̹����ײ�ص�
	public void onCollide(CollideItem target) {
		locationLoad();
	}
	
	@Override
	public void onOutOfBound() {
		locationLoad();
	}
	
	@Override
	public void die() {
		super.die();
		BattleField.get().add(new Explode(x,y));
	}
	
	public void reborn() {
		BattleField.get().add(this);
		alive = true;
	}
	
	public final void locationSave() {
		xbak = x;
		ybak = y;
	}
	public final void locationLoad() {
		x = xbak;
		y = ybak;
	}
	@Override
	public double getRadius() {
		return Conf.SIZE * 5;
	}
}
