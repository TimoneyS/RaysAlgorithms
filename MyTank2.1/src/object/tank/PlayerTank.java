package object.tank;

import java.awt.Color;
import java.awt.event.KeyEvent;

import global.Conf;
import interfaces.Listenable;
import map.BattleField;
import object.Bullet;
import object.Direction;

public class PlayerTank extends Tank implements Listenable {
	public PlayerTank(double x, double y, double direction, Color color) {
		super(x, y, direction, color);
	}
	private Direction v_direction = new Direction(0, 0);
	private boolean down 	= false;
	private boolean fire 	= false;
	private boolean up 		= false;
	private boolean right 	= false;
	private boolean left 	= false;
	
	//生命周期结束
	public void die() {
		alive = !Conf.PLA_DIE;
		BattleField.get().add(new object.Explode(x,y));
	}
	//移动操作
	public void move() {
//		super.move();
		double speed = getMoveSpeed();
		locationSave();		
		
		//备份坐标
		if(!v_direction.isZero()) {
			x += Math.sin(direction)*speed;					//坐标变化
			y -= Math.cos(direction)*speed;
		}
	}
	
	public void chooseDirection(){
		if(up) 	  v_direction = v_direction.plus(Direction.UP);
		if(down)  v_direction = v_direction.plus(Direction.DOWN);
		if(left)  v_direction = v_direction.plus(Direction.LEFT);
		if(right) v_direction = v_direction.plus(Direction.RIGHT);
		v_direction.inspect_print();
		if(!v_direction.isZero()) direction = v_direction.toRadians();
	}
	
	@Override	//发射子弹
	public void fire() {
		if(fire) {
			if(Conf.PLA_CHEAT)
				for(int i=0;i<360;i+=1) BattleField.get().add(new Bullet(x, y, Math.toRadians(i), color));
			else
				super.fire();
			fire = false;
		}
	}
	@Override	//键盘事件的处理
	public void keyPress(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W : {up = true;down = false;}break;
			case KeyEvent.VK_S : {down = true;up = false;}break;
			case KeyEvent.VK_D : {right = true;left = false;}break;
			case KeyEvent.VK_A : {left = true;right = false;}break;
		}
		chooseDirection();
	}
	@Override	//键盘释放监听方法
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W : up = false;break;
			case KeyEvent.VK_S : down = false;break;
			case KeyEvent.VK_D : right = false;break;
			case KeyEvent.VK_A : left = false;break;
			case KeyEvent.VK_J : fire = true;break;						//点发
		}
		chooseDirection();
	}
	
	@Override
	public double getMoveSpeed() {
		return Conf.TANK_MOVE_SPEED;
	}
}
