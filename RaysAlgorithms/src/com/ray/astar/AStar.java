package com.ray.astar;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ray.utils.StdOut;

import static com.ray.astar.Cell.cell;
/**
 * A * �㷨�Ĺ�����ʾ
 * @author Ray
 */
public class AStar {
	
	public static int SIZE = 0;

	/**
	 * ��ʼ����ͼ
	 * @return
	 * @throws Exception
	 */
	public static Cell[][] initMap() throws Exception {
		// ��ȡ��ͼwen'jian���ڵ�·��
		String path = System.getProperty("user.dir");
		Scanner sc = new Scanner(new File(path + "/src/com/ray/astar/" + "map.txt"));
		
		SIZE = Integer.valueOf(sc.nextLine());
		Cell[][] map = new Cell[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			String[] tmp = sc.nextLine().split("\\s+");
			StdOut.p(tmp);
			for (int j = 0; j < tmp.length; j++)
				map[i][j] = cell(i, j, Integer.valueOf(tmp[j]));
		}
		sc.close();
		return map;
	}

	// Ѱ������
	public static List<Cell> findChildren(Cell[][] map, Cell cu) {
		List<Cell> chs = new LinkedList<Cell>();
		int i = cu.i;
		int j = cu.j;
		if (i > 0)
			chs.add(map[i - 1][j]); // ��
		if (i < SIZE - 1)
			chs.add(map[i + 1][j]); // ��
		if (j > 0)
			chs.add(map[i][j - 1]); // ��
		if (j < SIZE - 1)
			chs.add(map[i][j + 1]); // ��
		return chs;
	}

	// �㷨����
	public static void astar(Cell[][] map) throws Exception {
		List<Cell> open = new LinkedList<Cell>();
		Cell cellMin, cellTmp;
		// ��ʼ����
		open.add(map[0][0]);

		while (open.size() != 0) {
			Thread.sleep(200);
			
			// ���� open �б�
			Iterator<Cell> ite = open.iterator();
			cellMin = null;
			while (ite.hasNext()) {
				cellTmp = ite.next();
				cellTmp.initPath(SIZE);
				if (cellMin == null || cellMin.sum() > cellTmp.sum())
					cellMin = cellTmp;
			}
			List<Cell> chs = findChildren(map, cellMin);
			for (Cell tmp : chs) {
				if (tmp.state != CellState.CLOSED) {
					if (tmp.parent == null) {
						tmp.past = cellMin.past + tmp.cost;
						open.add(tmp);
						tmp.state = CellState.OPENED;
						tmp.parent = cellMin;
					} else {
						if (tmp.sum() < cellMin.parent.sum()) {
							cellMin.parent = tmp;
							cellMin.past = tmp.past + cellMin.cost;
						}
					}
				}
			}
			cellMin.state = CellState.CLOSED;
			open.remove(cellMin);
		}
	}

	public static void astarShow(Cell[][] map) {
		JFrame frame = new JFrame("A star show");
		JPanel panel = new JPanel();

		int size = map.length;
		panel.setLayout(new GridLayout(size, size));
		panel.setPreferredSize(new Dimension(600, 600));
		for (Cell[] rows : map) {
			for (Cell cell : rows) {
				panel.add(cell);
			}
		} // end for

		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Ԥ��ˢ��
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
			public void run() {
				frame.repaint();
			}
		}, 100, 50, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * �����㷨
	 */
	public void search() {
		try {
			Cell[][] map = initMap();
			astarShow(map);
			astar(map);
			map[4][4].parse();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		
	}

}

@SuppressWarnings("serial")
class Cell extends JComponent {
	public static int UNCHECKED = 0, CLOSED = 1, OPENED = 2, CHOOSED = 3;
	public int i, j;
	public int past, fore;
	public int cost;
	public int stat = UNCHECKED;
	public Cell parent = null;

	public Cell(int i, int j, int type) {
		this.i = i;
		this.j = j;
		cost = 1;
		switch (type) {
		case 1:
			stat = CLOSED;break;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		setBorder(BorderFactory.createEtchedBorder());	
		int w = getSize().width;
		int h = getSize().height;
		
		if (stat == UNCHECKED) {
			g.setColor(Color.GRAY);
		} else if (stat == OPENED) {
			g.setColor(Color.GREEN);
		} else if (stat == CLOSED) {
			g.setColor(Color.DARK_GRAY);
		} else if(stat == CHOOSED){
			g.setColor(Color.PINK);
		}
		g.fillRect(0 , 0, w, h);
		
		g.setColor(Color.BLACK);
		g.drawString(String.format("[ %d, %d ,%2d]",i,j,stat), w/3, h/2);
	
	}

	public void initPath(int size) {
		fore = Math.abs(size - i - 1) + Math.abs(size - j - 1);
		if (past == 0 && parent != null)
			past = cost + parent.past;
	}

	public int sum() {
		return past + fore;
	}

	public void parse() {
		System.out.printf("[%2d,%2d]", i, j);
		if (parent != null) {
			System.out.print(" <- ");
			stat = CHOOSED;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			parent.parse();
		}
	}

}
