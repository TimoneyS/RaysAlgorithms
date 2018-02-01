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
	
	private static final int[][] DIR = new int[][]{ 
		{ -1,  0},    // 上
		{  1,  0},    // 下
		{  0, -1},    // 左
		{  0,  1}     // 右
	};
	
    public int                  size;              // size 地图尺寸， x，y
    private int[]               N;                 // 用一维数组表示的二维的地图
    private int                 x, y;              // 当前单元格位置
//    private int[]               dist;              // 标记每个单元格距其正确位置的距离
	public Board(int size) {
		this.size = size;
		N = new int[size * size];
//		dist = new int[size*size];
	}
	
	private boolean move(int[] d){
		// 移动操作， 可以根据传入的参数上下左右移动空格
		int new_x = x + d[0]; 
		int new_y = y + d[1];
		if(new_x >= size || new_x < 0 || new_y >= size || new_y < 0) return false;
		exch(N, x*size+y, new_x*size+new_y);
		x = new_x;
		y = new_y;
		return true;
	}
	
	public void reset() {
		for (int i = 0; i < N.length; i++) N[i]=i;
		x = y = size-1;
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
	
	
	public void moveUp() {move(DIR[0]); }
	public void moveDown() {move(DIR[1]); }
	public void moveLeft() {move(DIR[2]); }
	public void moveRight() {move(DIR[3]); }
	
	public int getSize() { return size; }
	public int[] getN() { return N; }
    public int getNum(int i, int j) { return N[i * size + j]; }
	
	/**
	 * 交换数组元素
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void exch(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}