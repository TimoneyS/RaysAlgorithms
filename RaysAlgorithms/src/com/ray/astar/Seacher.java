package com.ray.astar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import static com.ray.astar.CellType.*;

import com.ray.utils.StdOut;

/**
 * A * �㷨�Ĺ�����ʾ
 * @author Ray
 * 
 */
public class Seacher {
	
	private int 		width, height;
	
	private Cell[][]  	map;
	private List<Cell> 	open;
	private boolean 	isAuto = true;		// �Զ�/�ֶ��������ֶ������Ҫ���������һ����ִ����һ��������
	
	private int endX, endY;
	
	
	public void sleep(int milliSec) {
		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void search() {
		search( 0, 0, height-1, width-1);
	}
	
	// �� open�б���ȡ�� ����С����Ԫ��
	public Cell findMin() {
		Cell min = null;
		for (Cell cell : open) {
			cell.initPath(endX, endY);
			if (min == null || min.sum() > cell.sum()) min = cell; 
		}
		if (min!=null) min.stat = CURRENT_MIN;
		return min;
	}
	
	// �㷨����
	public void search(int startX, int startY, int endX, int endY) {
		this.endX 	= endX;
		this.endY 	= endY;
		// ��ʼ����
		open.add(map[startX][startY]);
		if (!isAuto) return;
		while (open.size() != 0) {
//			sleep(20);
			nextStep();
		}
		map[endX][endY].parse();
	}
	
	public void nextStep() {
		Cell cellMin 			= findMin();							// �ҵ���ǰСԪ��
		List<Cell> children 	= findChildren(cellMin.x, cellMin.y);	// ���ɿɴ�Ԫ���б�
		parseChildren(children, cellMin);								// �����ɴ�Ԫ���б�
		cellMin.stat 	= CLOSE;										// �ر���СԪ��
		open.remove(cellMin);
	}
	
	// Ѱ������
	public List<Cell> findChildren(int i, int j) {
		List<Cell> chs = new LinkedList<Cell>();
		if (i > 0) 			chs.add(map[i - 1][j]); // ��
		if (i < height - 1)	chs.add(map[i + 1][j]); // ��
		if (j > 0) 			chs.add(map[i][j - 1]); // ��
		if (j < width - 1) 	chs.add(map[i][j + 1]); // ��
		return chs;
	}

	// �����ɴ��Ԫ���б�
	private void parseChildren(List<Cell> chs, Cell min) {
		for (Cell child : chs) {
			if (child.isTypes(CLOSE, BLOCK)) continue;
			if (child.parent == null) {
				open.add(child);
				child.stat = OPEN;
				child.setParent(min);
			} else if (child.sum() < min.parent.sum()) {
				 min.setParent(child);
			}
		}
	}

	// ��ʼ��
	public void init() {
		String path = String.format("%s%s", System.getProperty("user.dir"), "/src/com/ray/astar/map.txt");;
		try (Scanner sc = new Scanner(new File(path))){
			width 	= sc.nextInt();
			height 	= sc.nextInt();
			map  = new Cell[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) map[i][j] = new Cell(i, j, sc.nextInt());
				StdOut.p(Arrays.toString(map[i]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		open = new LinkedList<Cell>();
	}

	public Cell[][] getMap() {
		return map;
	}
	
}
