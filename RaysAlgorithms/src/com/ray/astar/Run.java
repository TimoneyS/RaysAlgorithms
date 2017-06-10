package com.ray.astar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	public Run() {
		seacher = new AStar();
		
		frame = new JFrame("A star show");
		panel = new AStartPanel();
		
		JMenuBar jb = new JMenuBar();
		
		JMenu m1 = new JMenu("菜单"); 
		jb.add(m1);
		
		JMenuItem jm1 = new JMenuItem("载入");
		m1.add(jm1);
		jm1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seacher.initMap();
				panel.registerMap(seacher.getMap());
			}
		});
		
		JMenuItem jm2 = new JMenuItem("开始");
		m1.add(jm2);
		jm2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seacher.search();
			}
		});
		
		frame.setJMenuBar(jb);
		
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(600, 600));
		frame.pack();
		frame.setVisible(true);
		// 预订刷新
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
			public void run() {
				frame.repaint();
			}
		}, 100, 50, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) throws Exception {
		new Run();
	}
	
}
