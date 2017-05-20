package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.*;

import global.Conf;
import object.Bullet;
import object.CollideItem;
import object.Explode;
import object.Item;
import object.tank.BotTank;
import object.tank.PlayerTank;
import object.tank.Tank;

public class BattleField {
	private static BattleField BATTLE_FIELD = null;

	PlayerTank playerTank; 
	private List<Bullet> bullets;						//���е��ӵ�����
	private List<Explode> explodes;						//���еı�ը����
	private List<Tank> tanks;							//����̹�˼���
	
	// ���ù�����������
	public static BattleField create() {
		BATTLE_FIELD = new BattleField();
		return BATTLE_FIELD;
	}
	
	// ���ص����Ķ���
	public static BattleField get() {
		return (BATTLE_FIELD == null) ? create() : BATTLE_FIELD;
	}
	
	private BattleField() {
		tanks 		= new LinkedList<Tank>();
		bullets 	= new LinkedList<Bullet>();
		explodes 	= new LinkedList<Explode>();
		playerTank = new PlayerTank(400, 300, 0, Conf.PLA_COLOR);
		add(playerTank);
	}
	
	public void lunchEnemy() {
		//����
		for(int i = 0; i < 10; i++) {
			int j = i*50+175;
			add(new BotTank(j, 25, Math.toRadians(180), Color.RED));		//��ɫ��
			add(new BotTank(j, 75, Math.toRadians(180), Color.RED));		//��ɫ��
			add(new BotTank(j, 575, 0, Color.BLUE));		//��ɫ��
			add(new BotTank(j, 525, 0, Color.BLUE));		//��ɫ��
		}
		//����
		for(int i = 0; i < 10; i++) {
			int j = i*50+75;
			add(new BotTank(25, j, Math.toRadians(90), Color.GREEN));		//��ɫ��
			add(new BotTank(75, j, Math.toRadians(90), Color.GREEN));		//��ɫ��
			add(new BotTank(775, j, Math.toRadians(270), Color.CYAN));		//��ɫ��
			add(new BotTank(725, j, Math.toRadians(270), Color.CYAN));		//��ɫ��
		}
	}
	//���Ʒ���
	public void draw(Graphics2D g2) {
		draw(tanks, g2);
		draw(bullets, g2);
		draw(explodes, g2);
	}
	//�����б�
	private synchronized void draw(List<? extends Item> list,Graphics2D g2){
		Iterator<? extends Item> i = list.iterator();
		while(i.hasNext()) {
			Item o = i.next();
			if(o.isAlive()){
				o.draw(g2);
				o.upDate();
			}
			else i.remove();
		}
	}
	//��ӷ���
	public synchronized void add(Explode e){
		explodes.add(e);
	}
	//��ӷ���
	public synchronized void add(Tank t){
		tanks.add(t);
	}
	//��ӷ���
	public synchronized void add(Bullet b){
		bullets.add(b);
	}
	public List<? extends CollideItem> getTanks() { return tanks; }
	public List<? extends CollideItem> getBullets() { return bullets; }

	public PlayerTank getPlayerTank() {
		return playerTank;
	}
	
	public void keyPress(KeyEvent e) {
		playerTank.keyPress(e);
	}

	public void keyReleased(KeyEvent e) {
		playerTank.keyReleased(e);
	}
}