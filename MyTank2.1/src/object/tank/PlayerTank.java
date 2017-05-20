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
	private boolean fire 	= false;
	
	//生命周期结束
	public void die() {
		alive = !Conf.PLA_DIE;
		BattleField.get().add(new object.Explode(x,y));
	}
	
	//移动操作
	public void move() {
		if(!v_direction.isZero()) {
			direction = v_direction.toRadians();
			super.move();
		}
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
			case KeyEvent.VK_W : v_direction.plus(Direction.UP);break;
			case KeyEvent.VK_S : v_direction.plus(Direction.DOWN);break;
			case KeyEvent.VK_A : v_direction.plus(Direction.LEFT);break;
			case KeyEvent.VK_D : v_direction.plus(Direction.RIGHT);break;
		}
	}
	@Override	//键盘释放监听方法
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W : v_direction.plus(Direction.DOWN);break;
			case KeyEvent.VK_S : v_direction.plus(Direction.UP);break;
			case KeyEvent.VK_A : v_direction.plus(Direction.RIGHT);break;
			case KeyEvent.VK_D : v_direction.plus(Direction.LEFT);break;
			case KeyEvent.VK_J : fire = true;break;						//点发
		}
	}
	
	@Override
	public double getMoveSpeed() {
		return Conf.TANK_MOVE_SPEED;
	}
}
