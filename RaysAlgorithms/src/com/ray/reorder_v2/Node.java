package com.ray.reorder_v2;

public class Node {
	int[] numbers;
	int x,y;
	int dist;
	int steps;
	int size;
	Integer id;
	
	public Node(int id, Board board, int stepArg){
		this.id = id;
		numbers = new int[board.nums.length];
//		x     = board.x;
//		y     = board.y;
		steps = stepArg;
		size  = board.size;
		
		for(int i = 0; i < board.nums.length; i ++){
			int cu = board.nums[i];
			numbers[i] = cu;
			steps += Math.abs(i/size - (cu-1)/size) + Math.abs(i%size - (cu-1)%size);
		}
	}
}
