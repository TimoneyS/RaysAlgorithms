package com.rays.fun.reorder;

/** 
 * ��ʾ���                                                                                                           <br/>
 * **** ���ʵ�ʿɱ�ʾΪһ����ά����,��ߴ�Ϊ3�����  ********* <br/>
 * |---|-----------|                              <br/>
 * |x\y| 0 | 1 | 2 |                              <br/> 
 * |---|-----------|                              <br/>
 * | 0 | 0 | 1 | 2 |                              <br/>
 * |---|---|---|---|                              <br/>
 * | 1 | 3 | 4 | 5 |                              <br/>
 * |---|---|---|---|                              <br/>
 * | 2 | 6 | 7 | 8 |                              <br/>
 * |---|---|---|---|                              <br/>
 * **** ����ת��ʵ����һά���鼴��*********************** <br/>
 * |---|-----------------------------------|      <br/>
 * | x | - - 0 - - | - - 1 - - | - - 2 - - |      <br/> 
 * |---|-----------------------------------|      <br/>
 * | y | 0 | 1 | 2 | 0 | 1 | 2 | 0 | 1 | 2 |      <br/>
 * |---|-----------------------------------|      <br/>
 * | N | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |      <br/>
 * |---|-----------------------------------|      <br/>
 * **** �����ϵ����  ******************************** <br/>
 * x = N / 3                                      <br/>
 * y = N % 3                                      <br/>
 * N = x * 3 + y                                  <br/>
 * @author Ray
 *
 */
public class Board {
	
    private int                 size;              // ƴͼ�ĳߴ�
    private int[]               N;                 // ��һά�����ʾ�Ķ�ά��ͼ��
    private int                 cursor;            // ��ǰԪ�ص�һά����
    
    private Board() {}
    
	public Board(int size) {
		this.size = size;
		N = new int[size * size];
		reset();
	}
	
	/**
	 * ����
	 */
	public void reset() {
		for (int i = 0; i < N.length; i++) N[i]=i;
		cursor = N.length - 1;
	}
	
	/**
	 * ���и��Ӻ�����ȷλ�õ������پ���֮��
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
