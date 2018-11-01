package com.rays.fun.reorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Phase implements Comparable<Phase> {
    
    private Phase     prev;
    private Board     board;
    private int       step;
    private int       dist;
    private String    symbol;
    private Dir dir;
    
    public Phase (Board board) {
        this.step = 0;
        this.board = board.clone();
        this.dist = board.dist();
        this.symbol = Arrays.toString(this.board.getN());
    }
    
    public Phase(Phase prev, Dir dir) {
     
        this.prev = prev;
        this.dir = dir;
        
        this.board = prev.board.clone();
        this.board.move(dir);
        this.symbol = Arrays.toString(this.board.getN());
        
        this.step  = prev.step+1;
        this.dist = this.board.dist();
    
    }

    @Override
    public int compareTo(Phase o) {
        return Integer.valueOf(step + dist).compareTo(o.step + o.dist);
    }
    
    public List<Phase> adj() {
        List<Phase> list = new LinkedList<>();
        list.add(new Phase(this, Dir.LEFT));
        list.add(new Phase(this, Dir.RIGHT));
        list.add(new Phase(this, Dir.UP));
        list.add(new Phase(this, Dir.DOWN));
                                 
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
    
    public Dir getDir() {
        return dir;
    }
    
     public Phase prev() {
        return prev;
    }
    
    public void show() {
        System.out.printf("Step = %s, Dist = %s, Prev = %s\n", step, dist, prev);
        board.show();
        System.out.println("====================================");
    }
    
}
