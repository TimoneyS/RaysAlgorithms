package com.rays.fun.reorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Phase implements Comparable<Phase> {
    
    private Board     board;
    private List<Dir> path;
    private int       step;
    private int       dist;
    private String    symbol;
    
    public Phase(Board board, int step, List<Dir> path, Dir dir) {
        
        this.path  = new LinkedList<>();
        this.board = board.clone();
        this.step  = step;
        this.symbol = Arrays.toString(board.getN());
        
        if (path != null)
            this.path.addAll(path);
        
        if (dir != null) {
            this.path.add(dir);
            this.board.move(dir);
        }
        
        this.dist = this.board.dist();
    }

    @Override
    public int compareTo(Phase o) {
        return Integer.valueOf(step + dist).compareTo(o.step + o.dist);
    }
    
    public List<Phase> adj() {
        List<Phase> list = new LinkedList<>();
        list.add(new Phase(board, step+1, path, Dir.LEFT));
        list.add(new Phase(board, step+1, path, Dir.RIGHT));
        list.add(new Phase(board, step+1, path, Dir.UP));
        list.add(new Phase(board, step+1, path, Dir.DOWN));

        return list;       
    }
    
    public String symbol() {
        return symbol;
    }

    public boolean isOrder() {
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
