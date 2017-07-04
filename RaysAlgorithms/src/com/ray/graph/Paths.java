package com.ray.graph;

public abstract class Paths {
	
	public Paths(Graph G, int s) {
	}
	
	abstract boolean hashPathTo(int v);
	
	abstract Iterable<Integer> pathTo(int v);
	
}
