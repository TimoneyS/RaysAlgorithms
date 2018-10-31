package com.rays.fun.reorder;

import java.util.Scanner;

import com.ray.io.Out;

/** 
 * 表示面板                                                                                                           <br/>
 * **** 面板实际可表示为一个二维数组,如宽度为 3 高度为 3 的面板  * <br/>
 * |---|-----------|                              <br/>
 * |y\x| 0 | 1 | 2 |                              <br/> 
 * |---|-----------|                              <br/>
 * | 0 | 0 | 1 | 2 |                              <br/>
 * |---|---|---|---|                              <br/>
 * | 1 | 3 | 4 | 5 |                              <br/>
 * |---|---|---|---|                              <br/>
 * | 2 | 6 | 7 | 8 |                              <br/>
 * |---|---|---|---|                              <br/>
 * @author Ray
 *
 */
public class Board {
	
    public static final int UP    = 0;
    public static final int DOWN  = 1;
    public static final int LEFT  = 2;
    public static final int RIGHT = 3;
    
  
    private int             width;
    private int             height;
    private int[][]         N;           // 二维的图板
    private int             cursorX;     // 当前元素的一维坐标
    private int             cursorY;     // 当前元素的一维坐标
    
    private String          tag;
    private int             weight;
    
	public Board(int w, int h) {
	    width = w;
	    height = h;
		N = new int[height][width];
		reset();
	}
	
	/**
	 * 重置面板
	 */
	public Board reset() {
	    cursorY = height-1;
	    cursorX = width-1;
	    
	    int n = 0;
	    for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                N[i][j] = n++;
	    setWeight();
	    setTag();
	    return this;
	}
	
	public void move(int dir) {
	    switch(dir) {
	        case UP    : moveUp();break;
	        case DOWN  : moveDown();break;
	        case LEFT  : moveLeft();break;
	        case RIGHT : moveRight();break;
	    }
	}
	
	public Board moveUp()    {
	    if (cursorX > 0) {
	        swap(cursorX, cursorY, --cursorX, cursorY);
	    }
	    return this;
    }
	public Board moveDown()  {
	    if (cursorX < height-1) {
	        swap(cursorX, cursorY, ++cursorX, cursorY);
	    }
	    return this;
    }
	public Board moveLeft()  {
	    if (cursorY > 0) {
	        swap(cursorX, cursorY, cursorX, --cursorY);
	    }
	    return this;
    }
	public Board moveRight() {
	    if (cursorY < width - 1) {
	        swap(cursorX, cursorY, cursorX, ++cursorY);
	    }
	    return this;
    }
	
	private void setWeight() {
        weight = 0;
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                weight += getWeight(i, j);
	}
	
	private int getWeight(int i, int j) {
	    return Math.abs(i - N[i][j]/ width) + Math.abs(j-N[i][j] % width);
	}
	
	private void setTag() {
	    StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(N[i][j]);
                sb.append(" ");
            }
        }
        tag = sb.toString();
	}
	
	public Board[] adj() {
        Board boardUp    = clone().moveUp();
        Board boardDown  = clone().moveDown();
        Board boardLeft  = clone().moveLeft();
        Board boardRight = clone().moveRight();
        return new Board[]{ boardUp, boardDown, boardLeft, boardRight};
	}
	
	/**
	 * 从特征恢复
	 * @param s
	 */
	public void restoreFromTag(String s) {
	    Scanner sc = new Scanner(s);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                N[i][j] = sc.nextInt();
                if (N[i][j] == 0) {
                    cursorX = i;
                    cursorY = j;
                }
            }
        }
        sc.close();
	}
	
	public String getTag() {
        return tag;
    }
	
	public int getWeight() {
        return weight;
    }
	
	private void swap(int x1, int y1, int x2, int y2){
	    
		int temp = N[x1][y1];
		N[x1][y1] = N[x2][y2];
		N[x2][y2] = temp;
		
		setWeight();
		setTag();
	}
	
	public void show() {
	    Out.p(N, "%d ");
	}
	
	@Override
	protected Board clone() {
	    Board b = new Board(width, height);
	    for (int i = 0; i < height; i++)
	        for (int j = 0; j < width; j++)
	            b.N[i][j] = N[i][j];
	    b.cursorX = cursorX;
	    b.cursorY = cursorY;
	    b.tag = tag;
	    b.weight = weight;
	    return b;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof Board) {
    	    Board b = (Board)obj;
            for (int i = 0; i < height; i++)
                for (int j = 0; j < width; j++)
                    if (b.N[i][j] != N[i][j])
                        return false;
            return true;
	    }
	    return false;
	}
	
    public static void main(String[] args) {
        Board board = new Board(3, 3);
        board.moveRight();
        Out.p(board.N, "%s ");
    }
    
}
