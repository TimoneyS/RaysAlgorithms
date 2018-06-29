package com.rays.fun.astar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Run {
	
	private JFrame 				frame;           // 主框架   
	private AStarContentPanel	contentPanel;    // 内容面板
	private JMenuBar 			menuBar;         // 菜单栏
	
	public Run() {
	    loadContentPanel();
	    loadJMenu();
	    assmbleCompoment();
	    refreshFrame(50, TimeUnit.MILLISECONDS);
	    
	    contentPanel.generateMap(Global.MAP_PATH);
	}
	/**
     * 加载内容面板
     */
    public void loadContentPanel() {
        contentPanel    = new AStarContentPanel(Global.WIN_WIDTH, Global.WIN_HEIGHT);
        contentPanel.generateMap(Global.MAP_PATH);
    }
    /**
	 * 加载菜单
	 */
	public void loadJMenu() {
	    menuBar = new JMenuBar();
	    // 加载菜单
        JMenu m1    = new JMenu("地图");
        addJMenuItem (m1, "载入", (ActionEvent e) -> {
            contentPanel.generateMap(Global.MAP_PATH);
        });
//        addJMenuItem(
//                m1,
//                "寻路", (ActionEvent e) -> es.execute( () -> {
//                            contentPanel.moveTo(0, 0, 4, 4);
//                            for (Cell c : contentPanel.getPath(4, 4)) {
//                                c.setCellType(CellType.PATH);
//                            }
//                        })
//                );
        menuBar.add(m1);
	}
	
	/**
     * 组装图形组件
     */
    public void assmbleCompoment() {
        frame = new JFrame("A star show");
        // 拼装
        frame.setLayout(new FlowLayout());
        frame.add(contentPanel);
        frame.setJMenuBar(menuBar);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * 刷新
     */
    public void refreshFrame(int delay, TimeUnit unit) {
        // 预订刷新
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> frame.repaint(), 100, delay, unit);
    }

    public static JMenuItem addJMenuItem(JMenu parent, String name, ActionListener listener) {
		JMenuItem item = new JMenuItem(name);
		parent.add(item);
		item.addActionListener(listener);
		return item;
	}
	
	public static void main(String[] args) throws Exception {
		new Run();
	}
	
}
