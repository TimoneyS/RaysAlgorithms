package com.ray.astar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Run {
	
	JFrame frame;
	AStartPanel panel;
	AStar seacher;
	ExecutorService es;
	
	public Run() {
		es = Executors.newCachedThreadPool();
		seacher = new AStar();
		
		frame = new JFrame("A star show");
		panel = new AStartPanel();
		panel.setPreferredSize(new Dimension(600, 600));
		
		JMenuBar jb = new JMenuBar();
		
		JMenu m1 = new JMenu("菜单"); 
		jb.add(m1);
		
		JMenuItem jm1 = new JMenuItem("载入");
		m1.add(jm1);
		
		jm1.addActionListener( (ActionEvent e) -> {
				seacher.initMap();
				panel.registerMap(seacher.getMap());
		});
		
		JMenuItem jm2 = new JMenuItem("开始");
		m1.add(jm2);
		jm2.addActionListener( (ActionEvent e) -> seacher.search());
		
		frame.setJMenuBar(jb);
		
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// 预订刷新
		loop(frame);
	}
	
	public static void loop(JFrame frame) {
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> frame.repaint(), 100, 50, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) throws Exception {
		new Run();
	}
	
}
