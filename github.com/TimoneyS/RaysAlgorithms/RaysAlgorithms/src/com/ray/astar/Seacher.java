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
	
	private int 		xNum, yNum;
	
	private Cell[][]  	map;
	private List<Cell> 	open;
	
	@SuppressWarnings("unused")
	private int startX, startY, endX, endY;
	
	public void sleep(int milliSec) {
		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void search() {
		search( 0, 0, yNum-1, xNum-1);
	}
	
	// �� open�б���ȡ�� ����С����Ԫ��
	private Cell findMin() {
		Cell min = null;
		for (Cell cell : open) {
			cell.initPath(endX, endY);
			if (min == null || min.sum() > cell.sum()) min = cell; 
		}
		if (min!=null) min.stat = CURRENT_MIN;
		return min;
	}
	
	// �㷨����
	private void search(int startX, int startY, int endX, int endY) {
		setStart(startX, startY);
		setEnd(endX, endY);
		// ��ʼ����
		open.add(map[startX][startY]);
		if (!Global.IS_AUTO) return;
		while (open.size() != 0) {
//			sleep(20);
			nextStep();
		}
		
		Cell c;
		LinkedList<Cell> stack = getPath();
	
		while( (c=stack.poll()) != null) {
			c.stat = CellType.CHOOSE;
			sleep(100);
		}
		
	}
	
	public LinkedList<Cell> getPath() {
		LinkedList<Cell> stack = new LinkedList<Cell>();
		
		Cell c = map[endX][endY];
		while(c != null) {
			stack.push(c);
			c = c.parent;
		}
		
		return stack;
	}
	
	public void nextStep() {
		Cell cellMin 			= findMin();							// �ҵ���ǰСԪ��
		List<Cell> children 	= findChildren(cellMin.x, cellMin.y);	// ���ɿɴ�Ԫ���б�
		parseChildren(children, cellMin);								// �����ɴ�Ԫ���б�
		cellMin.stat 	= CLOSE;										// �ر���СԪ��
		open.remove(cellMin);
	}
	
	// Ѱ������
	private List<Cell> findChildren(int i, int j) {
		List<Cell> chs = new LinkedList<Cell>();
		if (i > 0) 			chs.add(map[i - 1][j]); // ��
		if (i < yNum - 1)	chs.add(map[i + 1][j]); // ��
		if (j > 0) 			chs.add(map[i][j - 1]); // ��
		if (j < xNum - 1) 	chs.add(map[i][j + 1]); // ��
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
		
		try (Scanner sc = new Scanner(new File(Global.MAP_PATH))) {
			xNum 	= sc.nextInt();
			yNum 	= sc.nextInt();
			map  = new Cell[yNum][xNum];
			for (int i = 0; i < yNum; i++) {
				for (int j = 0; j < xNum; j++) map[i][j] = Cell.create(i, j, sc.nextInt());
				StdOut.p(Arrays.toString(map[i]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		open = new LinkedList<Cell>();
	}

	public void setStart(int x, int y) {
		startX = x;
		startY = y;
	}

	public void setEnd(int x, int y) {
		endX = x;
		endY = y;
	}

	public Cell[][] getMap() {
		return map;
	}
	
}
