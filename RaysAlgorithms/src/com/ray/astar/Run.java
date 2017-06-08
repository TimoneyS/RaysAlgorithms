package com.ray.astar;

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
	
	public Run() {
		frame = new JFrame("A star show");
		panel = new AStartPanel();
		
		
		JMenuBar jb = new JMenuBar();
		JMenu jm1 = new JMenu("≤Àµ•");
		jb.add(jm1);
		
		JMenuItem jmi1 = new JMenuItem("‘ÿ»Î");
		jm1.add(jmi1);
		
		jmi1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
		frame.setJMenuBar(jb);
		
		
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
//		SwingUtilities.invokeLater(doRun);
		// ‘§∂©À¢–¬
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
			public void run() {
				frame.repaint();
			}
		}, 100, 50, TimeUnit.MILLISECONDS);
	}
	
	public void regiterMap(Cell[][] map) {
		panel.registerMap(map);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void run() {
		try {
			AStar astar = new AStar(); 
			Cell[][] map = astar.initMap();
//			regiterMap(map);
//			astar.search(map);
//			map[map.length-1][map.length-1].parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new Run().run();
	}
	
}
