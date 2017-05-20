package main;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import global.Conf;
import map.BattleField;
@SuppressWarnings("serial")
public class TankPanel extends JPanel {
	
	//�滭����
	protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;	
			Color c = g.getColor();
			
			BattleField.get().draw(g2);
			//��ʾ��Ϣ
			g.setColor(Color.BLACK);
			g.drawString("̹�� : " + BattleField.get().getTanks().size(), 30, 10);
			g.drawString("�ӵ� : " + BattleField.get().getBullets().size(), 30, 30);
			g.drawString("̹���ٶ� : " + Conf.TANK_MOVE_SPEED, 30, 50);
			
			g.setColor(c);
	}
	
	//����
	public TankPanel lunch () {
		
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(Conf.D_WIDTH, Conf.D_HEIGTH));
		setFocusable(true);
		
		//��Ӽ�����
		addKeyListener(new KeyAdapter() {
			public synchronized void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_MINUS  : Conf.TANK_MOVE_SPEED --;break;
				case KeyEvent.VK_EQUALS : Conf.TANK_MOVE_SPEED ++;break;
				default : BattleField.get().keyPress(e);
				}
			}
			public synchronized void keyReleased(KeyEvent e) {
				BattleField.get().keyReleased(e);
			}
		});
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true) {
					repaint();
					try {
						Thread.sleep(Conf.REFRESH_TIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}
			
		}).start();
		
		return this;
	}

}
