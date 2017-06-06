package com.ray.reorder_v1;

import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board {
	Map<Integer, Node> map;
	private int size;
	private int[] nums;
	private int x,y;

	public Board(int size) {
		this.size = size;
		nums = new int[size * size];
	}
	
	
	static final int[][] DIR = new int[][]{ { -1, 0},{ 1, 0},{ 0, -1},{ 0, 1} };	
	public void action(int code){
		switch(code){
		case Config.UP       : move(DIR[0]);break;
		case Config.DOWN     : move(DIR[1]);break;
		case Config.LEFT     : move(DIR[2]);break;
		case Config.RIGHT    : move(DIR[3]);break;
		case Config.RESET    :        reorder();break;
		case KeyEvent.VK_F10 :         search();break;
		} 
	}
	
	private boolean move(int[] d){
		int i = x + d[0]; 
		int j = y + d[1];
		if(i >= size || i < 0 || j >= size || j < 0) return false;
		exch(nums, x*size+y, i*size+j);
		x = i;y = j;
		return true;
	}
	
	private boolean moveReverse(int[] d){
		return move(new int[]{-d[0], -d[1]});
	}
	
	public int getNum(int i, int j){ return nums[i*size+j]; }
	
	public void reset() {
		for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) nums[i*size+j] = i * size + j + 1;
		nums[ size*size-1] = 0;
		x = size-1; y = size-1;
	}
	
	public void reorder(){
		new Thread(new Runnable(){
			public void run() {
				Integer id = genId();
				load(id);
				Node n = map.get(id);
				while(n.getParent() != null){
					moveReverse(DIR[n.getD()]);
					n = n.getParent();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
	
	public void search(){
System.out.println("start search...");
long t1 = new Date().getTime();
		reset();
		// ÀàËÆ A*Ëã·¨
		map = new HashMap<Integer, Node>();
		List<Node> open =  new LinkedList<Node>();
		Node root = genNode(-1);
		
		open.add(root);
		
		while(open.size() != 0){
			Node min = null;
			for(Node n : open) if( n.childCount == 0 && ( min == null || n.getDeep() < min.getDeep() ) ) min = n;
			List<Node> newNodes = childNodes(min);
			for(Node n :  newNodes) {
				if(!map.containsKey(n.getId())){
					n.setParent(min);
					map.put(n.getId(), n);
					open.add(n);
				}
			}
			open.remove(min);
		}
System.out.printf("Search done %s results, Cost %s ms\n", map.size(),new Date().getTime()-t1);
	}
	
	public List<Node> childNodes(Node n){

		load(n.getId());
		List<Node> l = new LinkedList<Node>();
		int i = 0;
		for(int[] d : DIR) {
			if(move(d)){
				l.add(genNode(i));
				moveReverse(d);
			}
			i ++;
		}
		return l;
	}
	
	
	private void load(Integer id) {
		for(int i = nums.length - 1; i >= 0; i --){
			nums[i] = id % 10;
			if(nums[i] == 0){x = i / size; y = i % size;};				
			id /= 10;
		}
	}

	private static void exch(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private Integer genId(){ Integer id = 0;for(int i : nums) id = id *10 + i;  return id; }
	private Node genNode(int d) { return new Node(genId(), d); }
	
}
