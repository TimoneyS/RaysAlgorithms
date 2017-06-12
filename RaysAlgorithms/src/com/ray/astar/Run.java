package com.ray.astar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Run {
	
	JFrame frame;
	AStarPanel panel;
	AStar seacher;
	ExecutorService es;
	
	public Run() {
		es = Executors.newCachedThreadPool();
		seacher = new AStar();
		frame = new JFrame("A star show");
		panel = new AStarPanel(600, 600);
		
		JMenuBar jb = new JMenuBar();
		JMenu m1 = new JMenu("菜单"); 
		
		addJMenuItem (m1, "载入", (ActionEvent e) -> {
			seacher.initMap();
			panel.registerMap(seacher.getMap());
		} );
		addJMenuItem (m1, "开始", (ActionEvent e) -> seacher.search() );
		
		jb.add(m1);
		frame.setJMenuBar(jb);
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// 预订刷新
		loop(frame);
	}
	
	public static JMenuItem addJMenuItem(JMenu parent, String name, ActionListener listener) {
		JMenuItem item = new JMenuItem("开始");
		parent.add(item);
		item.addActionListener(listener);
		return item;
	}
	
	public static void loop(JFrame frame) {
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> frame.repaint(), 100, 50, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) throws Exception {
		new Run();
	}
	
}
