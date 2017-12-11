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

import com.ray.utils.In;

public class Run {
	
	private JFrame 				frame;
	private AStarContentPanel	panel;
	private AStarControlPanel	controlPanel;
	private JMenuBar 			menuBar;
	private Map m;
	private Seacher s;
	
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
		    m = new Map(In.getProjectScanner(Global.MAP_PATH));
			panel.registerMap(m.cells());
		});
        addJMenuItem(
                m1,
                "��ʼ", (ActionEvent e) -> es.execute(
                        () -> {
                            s = new Seacher(m, 0, 0, m.rowNum() - 1, m.colNum() - 1);
                            for (Cell c : s.getPath(m)) {
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
