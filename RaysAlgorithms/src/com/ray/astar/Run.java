package com.ray.astar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.ray.common.utils.In;

public class Run {
	
	private JFrame 				frame;
	private AStarContentPanel	panel;
	private AStarControlPanel	controlPanel;
	private JMenuBar 			menuBar;
	private Map map;
	private Seacher seacher;
	
	private ExecutorService 	es;
	
	public Run() {
		// ��ʼ��
		es 		= Executors.newCachedThreadPool();
		frame 	= new JFrame("A star show");
		panel 	= new AStarContentPanel();
		controlPanel = new AStarControlPanel();
		menuBar = new JMenuBar();
		// ����˵�
		JMenu m1 	= new JMenu("�˵�");
		addJMenuItem (m1, "����", (ActionEvent e) -> {
		    map = new Map(In.getProjectScanner(Global.MAP_PATH));
			panel.registerMap(map.cells());
		});
        addJMenuItem(
                m1,
                "��ʼ", (ActionEvent e) -> es.execute(
                        () -> {
                            seacher = new Seacher(map, 1, 1, 9, 9);
                            for (Cell c : seacher.getPath(map)) {
                                c.stat = CellType.CHOOSE;
                            }
                        }
                        )
                );
		menuBar.add(m1);
		JButton b1 = new JButton("��һ��");
		//b1.addActionListener((ActionEvent e) -> seacher.nextStep());
		controlPanel.add(b1);
		// ƴװ
//		frame.setContentPane(panel);
		frame.setLayout(new FlowLayout());
		frame.add(panel);
		frame.add(controlPanel);
		frame.setJMenuBar(menuBar);
		// Ԥ��ˢ��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> frame.repaint(), 100, 50, TimeUnit.MILLISECONDS);
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
