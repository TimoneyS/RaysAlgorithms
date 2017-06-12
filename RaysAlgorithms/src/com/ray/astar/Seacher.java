package com.ray.astar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.ray.utils.StdOut;

/**
 * A * �㷨�Ĺ�����ʾ
 * @author Ray
 * 
 */
public class Seacher {
	
	private int size;
	private Cell[][]  map;
	
	public void search() {
		search(0,0);
	}

	// �㷨����
	public void search(int startX, int startY) {
		List<Cell> open = new LinkedList<Cell>();
		Cell cellMin, cellTmp;
		// ��ʼ����
		open.add(map[startX][startY]);

		while (open.size() != 0) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// ���� open �б�
			Iterator<Cell> ite = open.iterator();
			cellMin = null;
			while (ite.hasNext()) {
				cellTmp = ite.next();
				cellTmp.initPath(size);
				if (cellMin == null || cellMin.sum() > cellTmp.sum())
					cellMin = cellTmp;
			}
			List<Cell> chs = findChildren(cellMin);
			for (Cell tmp : chs) {
				if (tmp.stat != CellType.CLOSE && tmp.stat != CellType.BLOCK) {
					if (tmp.parent == null) {
						tmp.past = cellMin.past + tmp.cost;
						open.add(tmp);
						tmp.stat = CellType.OPEN;
						tmp.parent = cellMin;
					} else {
						if (tmp.sum() < cellMin.parent.sum()) {
							cellMin.parent = tmp;
							cellMin.past = tmp.past + cellMin.cost;
						}
					}
				}
			}
			cellMin.stat = CellType.CLOSE;
			open.remove(cellMin);
		}
		
		map[size-1][size-1].parse();
	}
	
	// ��ʼ����ͼ
	public void initMap() {
		String path = String.format("%s%s", System.getProperty("user.dir"), "/src/com/ray/astar/map.txt");;
		try (Scanner sc = new Scanner(new File(path))){
			size = sc.nextInt();
			map  = new Cell[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) map[i][j] = new Cell(i, j, sc.nextInt());
				StdOut.p(Arrays.toString(map[i]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Ѱ������
	public List<Cell> findChildren(Cell cu) {
		List<Cell> chs = new LinkedList<Cell>();
		int i = cu.i;
		int j = cu.j;
		if (i > 0) 			chs.add(map[i - 1][j]); // ��
		if (i < size - 1)	chs.add(map[i + 1][j]); // ��
		if (j > 0) 			chs.add(map[i][j - 1]); // ��
		if (j < size - 1) 	chs.add(map[i][j + 1]); // ��
		return chs;
	}
	
	public Cell[][] getMap() {
		return map;
	}
	
}
