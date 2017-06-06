package com.ray.reorder_v1;

public class Node {
	private Node parent;
	private Integer id;
	private   int deep;
	private int d;
	public int childCount;
	
	public Node(Integer id, int d){
		this.id = id;
		this.d = d;
	}
	
	public    void  delChild() { childCount --; }
	public    void  addChild() { childCount ++; }
	public     int   getDeep() { return   deep; }
	public Integer     getId() { return     id; }
	public    Node getParent() { return parent; }
	public   int      getD() { return      d; }
	
	public    void   setDeep(int deep) {this.deep = deep;}
	public void setParent(Node node) {
		if(parent != null ) parent.delChild();
		if(node != null) {
			deep = node.deep + 1;
			parent = node;
			parent.addChild();
		}
	}
	
	public String toString(){
		return String.valueOf(id);
	}
	
}
