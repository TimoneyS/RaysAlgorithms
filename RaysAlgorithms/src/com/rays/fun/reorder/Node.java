package com.rays.fun.reorder;

public class Node {
    
	int[] numbers;
	int x,y;
	int dist;
	int steps;
	int size;
	Integer id;
	
	public Node(int id, Board board, int stepArg){
	    int[] N = board.getN();
        size  = board.getSize();
	    
		this.id = id;
		numbers = new int[N.length];
		steps = stepArg;
		
		for(int i = 0; i < N.length; i ++){
			int cu = N[i];
			numbers[i] = cu;
			steps += Math.abs(i/size - (cu-1)/size) + Math.abs(i%size - (cu-1)%size);
		}
		
	}
}
