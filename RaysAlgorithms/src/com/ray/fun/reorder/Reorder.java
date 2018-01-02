package com.ray.fun.reorder;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Reorder {
	
	private JFrame frame;
	private Panel panel;
	
	public Reorder() {
		frame = new JFrame("ƴͼ");
		panel = new Panel();
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
