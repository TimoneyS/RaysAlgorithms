package com.rays.fun.reorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Path implements Comparable<Path> {
    
    private Board     board;
    private List<Dir> path;
    private int       step;
    private int       dist;
    
    public Path(Board board, int step, List<Dir> path, Dir dir) {
        this.path  = new LinkedList<>();
        this.board = board.clone();
        this.step  = step;
        
        if (path != null) this.path.addAll(path);
        if (dir != null) {
            this.path.add(dir);
            this.board.move(dir);
        }
        this.dist = this.board.dist();
    }

    @Override
    public int compareTo(Path o) {
        return Integer.valueOf(step + dist).compareTo(o.step + o.dist);
    }
    
    public List<Path> adj() {
        List<Path> list = new LinkedList<>();
        list.add(new Path(board, step+1, path, Dir.LEFT));
        list.add(new Path(board, step+1, path, Dir.RIGHT));
        list.add(new Path(board, step+1, path, Dir.UP));
        list.add(new Path(board, step+1, path, Dir.DOWN));

        return list;       
    }
    
    public String symbol() {
        return Arrays.toString(board.getN());
    }

    public boolean isGoal() {
        for (int i = 1; i < board.getN().length; i++)
            if (board.getN()[i] < board.getN()[i-1]) return false;
        return true;
    }
    
    public List<Dir> getPath() {
        return path;
    }
    
    public void show() {
        System.out.printf("Step = %s, Dist = %s, Path = %s\n", step, dist, path);
        board.show();
        System.out.println("====================================");
    }
    
}
