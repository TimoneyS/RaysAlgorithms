package com.rays.fun.astar;

import java.awt.FlowLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import com.ray.gui.FrameUtil;

public class Run {
	
	private JFrame 				frame;           // 主框架   
	private AStarContentPanel	contentPanel;    // 内容面板
	
	public Run() {
	    frame = FrameUtil.commonFrame("A star show");
	    frame.setLayout(new FlowLayout());
	    
	    loadContentPanel();
	    
	    FrameUtil.refreshFrame(frame, 20, TimeUnit.MILLISECONDS);
	    FrameUtil.showFrame(frame);
	    
	}
	/**
     * 加载内容面板
     */
    public void loadContentPanel() {
        contentPanel    = new AStarContentPanel(Global.WIN_WIDTH, Global.WIN_HEIGHT);
        frame.setContentPane(contentPanel);
        contentPanel.generateMap(Global.MAP_PATH);
    }
	
	public static void main(String[] args) throws Exception {
		new Run();
	}
	
}
