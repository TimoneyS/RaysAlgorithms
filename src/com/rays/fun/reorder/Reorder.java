package com.rays.fun.reorder;

import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import com.ray.gui.FrameUtil;

public class Reorder {

	private JFrame              frame;
	private Panel               panel;

	public Reorder() {
        panel = new Panel();
		frame = FrameUtil.commonFrame("ƴͼ");
		frame.add(panel, BorderLayout.CENTER);
		frame.addKeyListener(panel.getKeyListener());
		
		FrameUtil.showFrame(frame);
		FrameUtil.refreshFrame(frame, 100, TimeUnit.MILLISECONDS);
	}
	
	public static void main(String[] args) {
		new Reorder();
	}
	
}
