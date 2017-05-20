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
	
	// 初始化 玩家选项
	private void initPlaOption() {
		pla_option = new JMenu("玩家选项");
		func.add(pla_option);
		
		// 玩家复活的功能
		mi_pla_reborn = new JMenuItem("玩家复活");
		mi_pla_reborn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BattleField.get().getPlayerTank().reborn();
			}
		});
		pla_option.add(mi_pla_reborn);
		
		// 玩家作弊 选项
		mi_pla_cheat = new JCheckBoxMenuItem("玩家作弊");
		mi_pla_cheat.setSelected(Conf.PLA_CHEAT);
		mi_pla_cheat.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)   Conf.PLA_CHEAT = true;
				if(e.getStateChange() == ItemEvent.DESELECTED) Conf.PLA_CHEAT = false;
			}
		});
		pla_option.add(mi_pla_cheat);
		
		// 玩家可以死亡 选项
		mi_pla_die = new JCheckBoxMenuItem("玩家可以死亡");
		mi_pla_die.setSelected(Conf.PLA_DIE);
		mi_pla_die.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)   Conf.PLA_DIE = true;
				if(e.getStateChange() == ItemEvent.DESELECTED) Conf.PLA_DIE = false;
			}
		});
		pla_option.add(mi_pla_die);
	}

	// 初始化功能菜单栏
	public void initFuncMenue(){
		func = new JMenu("功能");
		add(func);
		
		// 重新载入的功能
		mi_reload = new JMenuItem("重新载入");
		mi_reload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BattleField.get().lunchEnemy();
			}
		});
		func.add(mi_reload);
	}
	
	// 初始化电脑选项菜单栏
	public void initAiOption(){
		ai_option = new JMenu("电脑选项");
		func.add(ai_option);
		
		// 电脑死亡 选项
		mi_ai_die = new JCheckBoxMenuItem("电脑可以死亡");
		mi_ai_die.setSelected(Conf.AI_DIE);
		mi_ai_die.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)   Conf.AI_DIE = true;
				if(e.getStateChange() == ItemEvent.DESELECTED) Conf.AI_DIE = false;
			}
		});
		ai_option.add(mi_ai_die);
		
		// 电脑移动 选项
		mi_ai_move = new JCheckBoxMenuItem("电脑可以移动");
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
