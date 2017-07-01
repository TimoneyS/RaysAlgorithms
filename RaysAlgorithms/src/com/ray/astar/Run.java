package com.ray.astar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Run {
	
	private JFrame 				frame;
	private AStarContentPanel	panel;
	private AStarControlPanel	controlPanel;
	private JMenuBar 			menuBar;
	
	private Seacher 			seacher;
	private ExecutorService 	es;
	
	public Run() {
		// 初始化
		es 		= Executors.newCachedThreadPool();
		seacher = new Seacher();
		frame 	= new JFrame("A star show");
		panel 	= new AStarContentPanel();
		controlPanel = new AStarControlPanel();
		menuBar = new JMenuBar();
		// 构造菜单
		JMenu m1 	= new JMenu("菜单");
		addJMenuItem (m1, "载入", (ActionEvent e) -> {
			seacher.init();
			panel.registerMap(seacher.getMap());
		});
		addJMenuItem (m1, "开始", (ActionEvent e) -> es.execute(() -> seacher.search()));
		menuBar.add(m1);
		JButton b1 = new JButton("下一步");
		b1.addActionListener((ActionEvent e) -> seacher.nextStep());
		controlPanel.add(b1);
		// 拼装
//		frame.setContentPane(panel);
		frame.setLayout(new FlowLayout());
		frame.add(panel);
		frame.add(controlPanel);
		frame.setJMenuBar(menuBar);
		// 预订刷新
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> frame.repaint(), 100, 50, TimeUnit.MILLISECONDS);
	}
	
	public static JMenuItem addJMenuItem(JMenu parent, String name, ActionListener listener) {
		JMenuItem item = new JMenuItem(name);
		parent.add(item);
		item.addActionListener(listener);
		return item;
	}
	
	public static void main(String[] args) throws Exception {
		new Run();
	}
	
}
