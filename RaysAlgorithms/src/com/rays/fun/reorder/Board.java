package com.rays.fun.reorder;

/** 
 * 表示面板                                                                                                           <br/>
 * **** 面板实际可表示为一个二维数组,如尺寸为3的面板  ********* <br/>
 * |---|-----------|                              <br/>
 * |x\y| 0 | 1 | 2 |                              <br/> 
 * |---|-----------|                              <br/>
 * | 0 | 0 | 1 | 2 |                              <br/>
 * |---|---|---|---|                              <br/>
 * | 1 | 3 | 4 | 5 |                              <br/>
 * |---|---|---|---|                              <br/>
 * | 2 | 6 | 7 | 8 |                              <br/>
 * |---|---|---|---|                              <br/>
 * **** 经过转换实际用一维数组即可*********************** <br/>
 * |---|-----------------------------------|      <br/>
 * | x | - - 0 - - | - - 1 - - | - - 2 - - |      <br/> 
 * |---|-----------------------------------|      <br/>
 * | y | 0 | 1 | 2 | 0 | 1 | 2 | 0 | 1 | 2 |      <br/>
 * |---|-----------------------------------|      <br/>
 * | N | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |      <br/>
 * |---|-----------------------------------|      <br/>
 * **** 具体关系如下  ******************************** <br/>
 * x = N / 3                                      <br/>
 * y = N % 3                                      <br/>
 * N = x * 3 + y                                  <br/>
 * @author Ray
 *
 */
public class Board {
	
    private int                 size;              // 拼图的尺寸
    private int[]               N;                 // 用一维数组表示的二维的图板
    private int                 cursor;            // 当前元素的一维坐标
    
    private Board() {}
    
	public Board(int size) {
		this.size = size;
		N = new int[size * size];
		reset();
	}
	
	/**
	 * 重置
	 */
	public void reset() {
		for (int i = 0; i < N.length; i++) N[i]=i;
		cursor = N.length - 1;
	}
	
	/**
	 * 所有格子和其正确位置的曼哈顿距离之和
	 * @return
	 */
	public int dist(){
		int distSum = 0;
		for(int i = 0; i < N.length; i ++) {
			int num = N[i];
			int dist = Math.abs(i / size - num / size) + Math.abs(i % size - num % size);
			distSum += dist;
		}
		return distSum;
	}
	
	public void show() {
	    for (int i = 0; i< size; i++) {
	        for (int j = 0; j < size; j++) {
	            System.out.print(N[i*size+j] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public void move(Dir dir) {
	    switch(dir) {
	        case UP    : moveUp();break;
	        case DOWN  : moveDown();break;
	        case LEFT  : moveLeft();break;
	        case RIGHT : moveRight();break;
	    }
	}
	
	private void moveUp()    { if ( cursor >= size)           swap(cursor, cursor -= size); }
	private void moveDown()  { if ( cursor < N.length - size) swap(cursor, cursor += size); }
	private void moveLeft()  { if ( cursor % 3 != 0)          swap(cursor, -- cursor); }
	private void moveRight() { if ( cursor % 3 != size-1)     swap(cursor, ++ cursor); }
	
    public int getNum(int i, int j) { return N[i * size + j]; }
    public int[] getN() { return N; }
    
	private void swap(int i, int j){
		int temp = N[i];
		N[i] = N[j];
		N[j] = temp;
	}
	
	public static void main(String[] args) {
        Board board = new Board(3);
        board.moveUp();
        board.show();
    }
	
	@Override
	protected Board clone() {
	    Board b = new Board();
	    b.N = new int[N.length];
	    for (int i = 0; i < N.length; i++) b.N[i] = N[i];
	    b.size = size;
	    b.cursor = cursor;
	    return b;
	}
	
}

enum Dir {
    UP, DOWN, LEFT, RIGHT
}
