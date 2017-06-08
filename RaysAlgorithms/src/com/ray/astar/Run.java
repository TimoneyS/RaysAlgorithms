package com.ray.astar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Run {

	public static void astarShow(Cell[][] map) {
		JFrame frame = new JFrame("A star show");
		JPanel panel = new JPanel();

		int size = map.length;
		panel.setLayout(new GridLayout(size, size));
		panel.setPreferredSize(new Dimension(600, 600));
		for (Cell[] rows : map) 
			for (Cell cell : rows) panel.add(cell);

		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Ô¤¶©Ë¢ÐÂ
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
			public void run() {
				frame.repaint();
			}
		}, 100, 50, TimeUnit.MILLISECONDS);
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_1 : run();
				}
			}
			
		});
	}
	
	public static void run() {
		try {
			Cell[][] map = AStar.initMap();
			astarShow(map);
			AStar.astar(map);
			map[4][4].parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Cell[][] map = AStar.initMap();
		astarShow(map);
		AStar.astar(map);
		map[4][4].parse();
	}

	
}
