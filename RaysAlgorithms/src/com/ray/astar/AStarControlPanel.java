package com.ray.astar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AStarControlPanel extends JPanel {
	
	public AStarControlPanel() {
		this(200, 600);
	}
	
	public AStarControlPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
}
