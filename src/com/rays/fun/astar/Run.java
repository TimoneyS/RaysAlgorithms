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
	
	private JFrame 				frame;           // �����   
	private AStarContentPanel	contentPanel;    // �������
	private JMenuBar 			menuBar;         // �˵���
	
	public Run() {
	    loadContentPanel();
	    loadJMenu();
	    assmbleCompoment();
	    refreshFrame(50, TimeUnit.MILLISECONDS);
	    
	    contentPanel.generateMap(Global.MAP_PATH);
	}
	/**
     * �����������
     */
    public void loadContentPanel() {
        contentPanel    = new AStarContentPanel(Global.WIN_WIDTH, Global.WIN_HEIGHT);
        contentPanel.generateMap(Global.MAP_PATH);
    }
    /**
	 * ���ز˵�
	 */
	public void loadJMenu() {
	    menuBar = new JMenuBar();
	    // ���ز˵�
        JMenu m1    = new JMenu("��ͼ");
        addJMenuItem (m1, "����", (ActionEvent e) -> {
            contentPanel.generateMap(Global.MAP_PATH);
        });
//        addJMenuItem(
//                m1,
//                "Ѱ·", (ActionEvent e) -> es.execute( () -> {
//                            contentPanel.moveTo(0, 0, 4, 4);
//                            for (Cell c : contentPanel.getPath(4, 4)) {
//                                c.setCellType(CellType.PATH);
//                            }
//                        })
//                );
        menuBar.add(m1);
	}
	
	/**
     * ��װͼ�����
     */
    public void assmbleCompoment() {
        frame = new JFrame("A star show");
        // ƴװ
        frame.setLayout(new FlowLayout());
        frame.add(contentPanel);
        frame.setJMenuBar(menuBar);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * ˢ��
     */
    public void refreshFrame(int delay, TimeUnit unit) {
        // Ԥ��ˢ��
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
