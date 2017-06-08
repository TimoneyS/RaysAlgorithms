package com.ray.reorder_v1;

public class Phase {
	public static int size = Config.SIZE;
	private int[] numbers;
	private int x;
	private int y;
	
	public Phase() {
	}
	
	public Phase(int x, int y, int[] arr){
		this.x       =   x;
		this.y       =   y;
		this.numbers = arr;
	}
	
	public Phase nove(int[] d){
		int i = x + d[0]; 
		int j = y + d[1];
		if(i >= size || i < 0 || j >= size || j < 0) return this;
		exch(x*size+y, i*size+j);
		x = i;y = j;
		
		return null;
	}
	
	private static void exch(int i, int j){
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
	}
	
	
	public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
