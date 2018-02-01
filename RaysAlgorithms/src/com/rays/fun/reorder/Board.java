package com.rays.fun.reorder;

/** 
 * 表示面板                                                                                                           <br/>
 * **** 面板实际可表示为一个二维数组 ********************* <br/>
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
	
    private int                 size;              // 地图尺寸
    private int[]               N;                 // 用一维数组表示的二维的地图
    private int                 index;             // 当前元素的一维坐标
    
	public Board(int size) {
		this.size = size;
		N = new int[size * size];
		reset();
	}
	
	public void reset() {
		for (int i = 0; i < N.length; i++) N[i]=i;
		index = N.length - 1;
	}
	
	/**
	 * 所有格子和其正确位置的曼哈顿距离之和
	 * @return
	 */
	private int dist(){
		int distSum = 0;
		for(int i = 0; i < N.length; i ++) {
			int num = N[i];
			int dist = Math.abs(i/size - num/size) + Math.abs(i%size - num % size);
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
	
	public void moveUp() { if (index >= size) exch(index, index-=size); }
	public void moveDown() { if (index<N.length - size) exch(index, index+=size); }
	public void moveLeft() { if (index%3 != 0) exch(index, --index); }
    public void moveRight() { if ( index+1 % 3 != 0) exch(index, ++index); }
	
    public int getNum(int i, int j) { return N[i * size + j]; }
	
	private void exch(int i, int j){
		int temp = N[i];
		N[i] = N[j];
		N[j] = temp;
	}
	
	public static void main(String[] args) {
        Board board = new Board(3);
        board.moveUp();
        board.show();
    }
	
}