package com.rays.fun.reorder;

/** 
 * ��ʾ���                                                                                                           <br/>
 * **** ���ʵ�ʿɱ�ʾΪһ����ά���� ********************* <br/>
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
	
    private int                 size;              // ��ͼ�ߴ�
    private int[]               N;                 // ��һά�����ʾ�Ķ�ά�ĵ�ͼ
    private int                 index;             // ��ǰԪ�ص�һά����
    
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
	 * ���и��Ӻ�����ȷλ�õ������پ���֮��
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