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
	protected double xbak,ybak;						// 备份的 坐标
	protected double moveState = 0;					// 用于描述动态效果
	
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
		
		//绘制
		double size = Conf.SIZE;
		
		AffineTransform odlTramsform = g2.getTransform();	//旋转参数备份
		g2.rotate(direction, x, y);							//设置旋转的角度和中心点
		//主舱室
		g2.setColor(getColor());
		Rectangle2D rbody = new  Rectangle2D.Double(x-3*size, y-3*size, 6*size, 6*size);
		g2.fill(rbody);
		g2.setColor(Color.BLACK);
		g2.draw(rbody);
		//轮子
		g2.setColor(Color.LIGHT_GRAY);
		Rectangle2D rweell = new Rectangle2D.Double(x-5*size, y-5*size, 2*size, 10*size);
		Rectangle2D rweelr = new Rectangle2D.Double(x+3*size, y-5*size, 2*size, 10*size);
		g2.fill(rweell);
		g2.fill(rweelr);
		g2.setColor(Color.BLACK);
		g2.draw(rweell);
		g2.draw(rweelr);
		//履带
		double y2;
		for(int i = -2; i < 3; i++) {
			y2 = y + size*moveState/10 + size*2*i;
			g2.draw(new Line2D.Double(x-5*size, y2, x-3*size, y2));
			g2.draw(new Line2D.Double(x+5*size, y2, x+3*size, y2));
		}
		//炮管
		g2.setColor(Color.DARK_GRAY);
		Rectangle2D rfire = new Rectangle2D.Double(x-0.4*size, y-8*size, 1*size, 8*size);
		g2.fill(rfire);
		//炮台
		Ellipse2D rfilePlat = new Ellipse2D.Double(x-1.5*size, y-1.5*size, 3*size, 3*size);
		g2.fill(rfilePlat);
		
		g2.setTransform(odlTramsform); //恢复备份的旋转参数
	}
	
	// 移动方法
	public void move() {
		double speed = getMoveSpeed();
		if(speed!=0) moveState+=(speed<0?0.5:-0.5);				//履带变化
		moveState = (moveState+10)%10;
		locationSave();											//备份坐标
		x += Math.sin(direction)*speed;							//坐标变化
		y -= Math.cos(direction)*speed;			
	}
	
	// 坦克碰撞回调
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
