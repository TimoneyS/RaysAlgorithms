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
	
	JFrame 			frame;
	AStarPanel 		panel;
	Seacher 		seacher;
	ExecutorService es;
	
	public Run() {
		es 		= Executors.newCachedThreadPool();
		seacher = new Seacher();
		frame 	= new JFrame("A star show");
		
		panel 	= new AStarPanel(600, 600);
		frame.setContentPane(panel);
		
		JMenuBar jb = new JMenuBar();
		JMenu m1 	= new JMenu("菜单"); 
		addJMenuItem (m1, "载入", (ActionEvent e) -> {
			seacher.initMap();
			panel.registerMap(seacher.getMap());
		});
		addJMenuItem (m1, "开始", (ActionEvent e) -> es.execute(()->seacher.search()));
		jb.add(m1);
		frame.setJMenuBar(jb);		
		
		// 预订刷新
		show(frame);
	}
	
	public static JMenuItem addJMenuItem(JMenu parent, String name, ActionListener listener) {
		JMenuItem item = new JMenuItem(name);
		parent.add(item);
		item.addActionListener(listener);
		return item;
	}
	
	public static void show(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> frame.repaint(), 100, 50, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) throws Exception {
		new Run();
	}
	
}
