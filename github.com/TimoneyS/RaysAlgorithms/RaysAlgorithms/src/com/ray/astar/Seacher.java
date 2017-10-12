package com.ray.astar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import static com.ray.astar.CellType.*;

import com.ray.utils.StdOut;

/**
 * A * 算法的过程演示
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
	
	// 从 open列表中取出 “最小”的元素
	private Cell findMin() {
		Cell min = null;
		for (Cell cell : open) {
			cell.initPath(endX, endY);
			if (min == null || min.sum() > cell.sum()) min = cell; 
		}
		if (min!=null) min.stat = CURRENT_MIN;
		return min;
	}
	
	// 算法过程
	private void search(int startX, int startY, int endX, int endY) {
		setStart(startX, startY);
		setEnd(endX, endY);
		// 初始步骤
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
		Cell cellMin 			= findMin();							// 找到当前小元素
		List<Cell> children 	= findChildren(cellMin.x, cellMin.y);	// 生成可达元素列表
		parseChildren(children, cellMin);								// 解析可达元素列表
		cellMin.stat 	= CLOSE;										// 关闭最小元素
		open.remove(cellMin);
	}
	
	// 寻找子孙
	private List<Cell> findChildren(int i, int j) {
		List<Cell> chs = new LinkedList<Cell>();
		if (i > 0) 			chs.add(map[i - 1][j]); // 上
		if (i < yNum - 1)	chs.add(map[i + 1][j]); // 下
		if (j > 0) 			chs.add(map[i][j - 1]); // 左
		if (j < xNum - 1) 	chs.add(map[i][j + 1]); // 右
		return chs;
	}

	// 解析可达的元素列表
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

	// 初始化
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
