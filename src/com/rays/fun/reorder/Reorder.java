package com.rays.fun.reorder;

import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import com.ray.util.RFrame;

public class Reorder {

	private JFrame              frame;
	private Panel               panel;

	public Reorder() {
        panel = new Panel();
		frame = RFrame.commonFrame("ƴͼ");
		frame.add(panel, BorderLayout.CENTER);
		frame.addKeyListener(panel.getKeyListener());
		
		RFrame.showFrame(frame);
		RFrame.refreshFrame(frame, 100, TimeUnit.MILLISECONDS);
	}
	
	public static void main(String[] args) {
		new Reorder();
	}
	
}
