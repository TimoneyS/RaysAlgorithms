package com.rays.fun.reorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Reorder {
	private JFrame              frame;
	private Panel               panel;
	
	public Reorder() {
		frame = new JFrame("ƴͼ");
		panel = new Panel();
		panel.setPreferredSize(new Dimension(Config.WIDTH, Config.HEIGTH));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		frame.addKeyListener(panel.getKeyListener());
		
		refreshFrame(100, TimeUnit.MILLISECONDS);
	}
	
    /**
     * ˢ��
     */
    public void refreshFrame(int delay, TimeUnit unit) {
        // Ԥ��ˢ��
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> frame.repaint(), 100, delay, unit);
    }
	
	public static void main(String[] args) {
		new Reorder();
	}
	
}
