package com.ray.reorder;

/** 
 * ���ú����߼�����
 * @author Ray
 *
 */
public class Board {
	
	public static final int[][] DIR = new int[][]{ 
		{ -1,  0},
		{  1,  0},
		{  0, -1},
		{  0,  1}
	};	
	
	public int size;		// size ��ͼ�ߴ磬 x��y �հ׵�����꣬������ʱ�ö�ά�����
	private int x,y; 
	public int[] 	nums;		// ��һά�����ʾ�Ķ�ά�ĵ�ͼ

	public Board(int size) {
		this.size = size;
		nums = new int[size * size];
	}
	
	public boolean move(int[] d){
		// �ƶ������� ���Ը��ݴ���Ĳ������������ƶ��ո�
		int i = x + d[0]; 
		int j = y + d[1];
		if(i >= size || i < 0 || j >= size || j < 0) return false;
		exch(nums, x*size+y, i*size+j);
		x = i;y = j;
		return true;
	}
	
	public int getNum(int i, int j){ return nums[i*size+j]; }
	
	public void reset() {
		for (int i = 0; i<size*size; i++) nums[i]=i+1;
		x=y=size-1;
	}
	
	public int get_dist(){
		int[] dist = new int[size*size];
		int distSum = 0;
		for(int i = 0; i < size; i ++) {
			for(int j = 0; j < size; j ++) {
				int cu = nums[i*size + j];
//				if(cu == size * size) continue;
				dist[i*size+j] = Math.abs(i - (cu-1)/size) + Math.abs(j - (cu-1) % size);
				distSum += dist[i*size+j];
			}
		}
		return distSum;
	}
	
	private static void exch(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}