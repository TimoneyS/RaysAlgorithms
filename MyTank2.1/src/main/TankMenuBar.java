package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import global.Conf;
import map.BattleField;

@SuppressWarnings("serial")
public class TankMenuBar extends JMenuBar {
	
	private JMenu func;
	private JMenu ai_option;
	private JMenu pla_option;
	
	private JMenuItem mi_reload;
	
	private JMenuItem mi_ai_die;
	private JMenuItem mi_ai_move;
	
	private JMenuItem mi_pla_cheat;
	private JMenuItem mi_pla_die;
	private JMenuItem mi_pla_reborn;

	public TankMenuBar() {
		initFuncMenue();
		func.addSeparator();
		initAiOption();
		func.addSeparator();
		initPlaOption();
	}
	
	// ��ʼ�� ���ѡ��
	private void initPlaOption() {
		pla_option = new JMenu("���ѡ��");
		func.add(pla_option);
		
		// ��Ҹ���Ĺ���
		mi_pla_reborn = new JMenuItem("��Ҹ���");
		mi_pla_reborn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BattleField.get().getPlayerTank().reborn();
			}
		});
		pla_option.add(mi_pla_reborn);
		
		// ������� ѡ��
		mi_pla_cheat = new JCheckBoxMenuItem("�������");
		mi_pla_cheat.setSelected(Conf.PLA_CHEAT);
		mi_pla_cheat.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)   Conf.PLA_CHEAT = true;
				if(e.getStateChange() == ItemEvent.DESELECTED) Conf.PLA_CHEAT = false;
			}
		});
		pla_option.add(mi_pla_cheat);
		
		// ��ҿ������� ѡ��
		mi_pla_die = new JCheckBoxMenuItem("��ҿ�������");
		mi_pla_die.setSelected(Conf.PLA_DIE);
		mi_pla_die.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)   Conf.PLA_DIE = true;
				if(e.getStateChange() == ItemEvent.DESELECTED) Conf.PLA_DIE = false;
			}
		});
		pla_option.add(mi_pla_die);
	}

	// ��ʼ�����ܲ˵���
	public void initFuncMenue(){
		func = new JMenu("����");
		add(func);
		
		// ��������Ĺ���
		mi_reload = new JMenuItem("��������");
		mi_reload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BattleField.get().lunchEnemy();
			}
		});
		func.add(mi_reload);
	}
	
	// ��ʼ������ѡ��˵���
	public void initAiOption(){
		ai_option = new JMenu("����ѡ��");
		func.add(ai_option);
		
		// �������� ѡ��
		mi_ai_die = new JCheckBoxMenuItem("���Կ�������");
		mi_ai_die.setSelected(Conf.AI_DIE);
		mi_ai_die.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)   Conf.AI_DIE = true;
				if(e.getStateChange() == ItemEvent.DESELECTED) Conf.AI_DIE = false;
			}
		});
		ai_option.add(mi_ai_die);
		
		// �����ƶ� ѡ��
		mi_ai_move = new JCheckBoxMenuItem("���Կ����ƶ�");
		mi_ai_move.setSelected(Conf.AI_MOVE);
		mi_ai_move.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)   Conf.AI_MOVE = true;
				if(e.getStateChange() == ItemEvent.DESELECTED) Conf.AI_MOVE = false;
			}
		});
		ai_option.add(mi_ai_move);
	}
	
	
}
