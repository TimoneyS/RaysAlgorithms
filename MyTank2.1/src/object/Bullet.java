package object;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import global.Conf;
import map.BattleField;

public class Bullet extends CollideItem {
	public Bullet(double x, double y, double direction,Color color ) {
		super(x, y, direction, color);
		this.x = x + Math.sin(this.direction)*Conf.SIZE*8;
		this.y = y - Math.cos(this.direction)*Conf.SIZE*8;
	}
	
	public void draw(Graphics2D g2) {
		Ellipse2D shape = 											//��״��Բ��
				new Ellipse2D.Double(x-Conf.SIZE, y-Conf.SIZE, 2.5*Conf.SIZE, 2.5*Conf.SIZE);
		g2.setColor(color);											//��ɫ
		g2.fill(shape);												//���
		g2.setColor(Color.BLACK);									//�߿���ɫ
		g2.draw(shape);												//�滭�߿�
	}
	
	public void upDate() {
		move();
		//��ײ���
		collide(BattleField.get().getTanks());
		collide(BattleField.get().getBullets());
	}
	
	public void move(){
		if( getColor().equals(Conf.PLA_COLOR) || Conf.AI_MOVE ) {
		//����
		x += Math.sin(direction)*Conf.BULLET_SPEED;
		y -= Math.cos(direction)*Conf.BULLET_SPEED;
		}
	}
	
	public void onCollide(CollideItem target) {
		if(!color.equals(target.getColor())) {
			die();
			target.die();
		}
	}
	
	public void onOutOfBound() {
		die();
	}
	
	@Override
	public void die() {
		super.die();
		BattleField.get().add(new Explode(x,y));
	}
	
	public double getRadius() { return Conf.SIZE*1.25; }
}