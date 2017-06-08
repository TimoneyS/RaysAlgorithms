package com.ray.astar;

import java.io.File;
import java.util.*;

import com.ray.utils.StdOut;

/**
 * A * �㷨�Ĺ�����ʾ
 * @author Ray
 * 
 */
public class AStar {
	
	public int size = 0;

	// �㷨����
	public void search(Cell[][] map) throws Exception {
		List<Cell> open = new LinkedList<Cell>();
		Cell cellMin, cellTmp;
		// ��ʼ����
		open.add(map[0][0]);

		while (open.size() != 0) {
			Thread.sleep(20);
			
			// ���� open �б�
			Iterator<Cell> ite = open.iterator();
			cellMin = null;
			while (ite.hasNext()) {
				cellTmp = ite.next();
				cellTmp.initPath(size);
				if (cellMin == null || cellMin.sum() > cellTmp.sum())
					cellMin = cellTmp;
			}
			List<Cell> chs = findChildren(map, cellMin);
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
	}
	
	// ��ʼ����ͼ
	public Cell[][] initMap() throws Exception {
		
		Scanner sc = new Scanner(
				new File(String.format("%s%s", System.getProperty("user.dir"), "/src/com/ray/astar/map.txt"))
				);
		
		size = sc.nextInt();
		Cell[][] map = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) map[i][j] = new Cell(i, j, sc.nextInt());
			StdOut.p(Arrays.toString(map[i]));
		}
		sc.close();
		return map;
	}

	// Ѱ������
	public List<Cell> findChildren(Cell[][] map, Cell cu) {
		List<Cell> chs = new LinkedList<Cell>();
		int i = cu.i;
		int j = cu.j;
		if (i > 0) 			chs.add(map[i - 1][j]); // ��
		if (i < size - 1)	chs.add(map[i + 1][j]); // ��
		if (j > 0) 			chs.add(map[i][j - 1]); // ��
		if (j < size - 1) 	chs.add(map[i][j + 1]); // ��
		return chs;
	}
	
}
