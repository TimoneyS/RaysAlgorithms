package com.ray.reorder_v1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Reorder {
	
	JFrame frame;
	BoardPanel panel;
	
	public Reorder() {
		frame = new JFrame("Fake Draw");
		panel = new BoardPanel();
		panel.setPreferredSize(new Dimension(Config.WIDTH, Config.HEIGTH));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		frame.addKeyListener(panel.getKeyListener());
	}
	
	
	public static void main(String[] args) {
		new Reorder();
	}
	
}
