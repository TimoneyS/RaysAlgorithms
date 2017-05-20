package object.tank;

import java.awt.Color;

import global.Conf;
import map.BattleField;
import object.Collider;

public class BotTank extends Tank {
	
	public BotTank(double x, double y, double direction, Color color) {
		super(x, y, direction, color);
	}
	
	public void move() {
		if(Conf.AI_MOVE) {
			super.move(); 
			int i = (int) (Math.random()*30);
			if(i==1) chooseDirection();
		}
	}
	
	@Override
	public void onCollide(Collider target) {
		 chooseDirection();
		 locationLoad();
	}
	
	//选择方向
	public void chooseDirection() {
		switch((int)(Math.random()*4)) {
			case 0 : direction = 0;break;
			case 1 : direction = Math.PI/2;break;
			case 2 : direction = Math.PI;break;
			case 3 : direction = Math.PI/2*3;break;
			default : direction = 0;
		}
	}
	@Override
	public void fire() {
		if(Conf.AI_FIRE&&(int)(Math.random()*Conf.AI_SHOOT_RATE)==1)		//百分之一的几率开枪
			super.fire();
	}
	
	public double getMoveSpeed() {
		return Conf.TANK_MOVE_SPEED/2;
	}
	
	@Override
	public void die() {
		alive = !Conf.AI_DIE;
		BattleField.get().add(new object.Explode(x,y));
	}
	
}