package com.rays.fun.reorder;

import java.util.LinkedList;
import java.util.List;

public class Path implements Comparable<Path> {
    
    private int[]     N;
    private List<Dir> path;
    private int       step;
    private int       dist;
    
    public Path(int[] N, int step, int dist) {
        path = new LinkedList<>();
        this.N = N;
        this.step = step;
        this.dist = dist;
    }

    @Override
    public int compareTo(Path o) {
        return Integer.valueOf(step + dist).compareTo(o.step + o.dist);
    }
    
}
