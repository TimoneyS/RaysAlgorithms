package com.rays.fun.reorder;

import java.util.HashMap;
import java.util.Map;

import com.ray.util.Timer;
import com.ray.util.collections.MinPQ;
import com.ray.util.collections.RaysMinPQ;
import com.ray.util.collections.RaysStack;
import com.ray.util.collections.Stack;

/**
 * 用于寻找能够恢复面板顺序的路径
 * @author rays1
 *
 */
public class Seacher {
    
    private int                  cursor = 0;
    private Phase[]              phases;
    private boolean[]            isClose;
    private MinPQ<Phase>         open;         // open 列表
    private Map<String, Integer> symbolToIndex;
    private Phase                finalPhase;
    
    public Seacher(Board board) {
        
        symbolToIndex = new HashMap<>();
        open = new RaysMinPQ<>();
        phases = new Phase[16];
        isClose = new boolean[16];
        
        Phase start = new Phase(board);
        
        phases[toIndex(start)] = start;
        
        open.insert(start);
        while (!open.isEmpty()) {
            Phase min = open.delMin();
           
            isClose[toIndex(min)] = true;
            
            if (min.isOrder()) {
                finalPhase = min;
                break;
            }
            
            for (Phase p : min.adj()) {
                if (toIndex(p) >= phases.length)
                    resize();
                if (!isClose[toIndex(p)] && phases[toIndex(p)] == null) {
                    phases[toIndex(p)] = p;
                    open.insert(p);
                }
            }
            
        }
        
    }
    
    private void resize() {
        
        Phase[] tempPhases = new Phase[phases.length*2];
        boolean[] tempIsClose = new boolean[phases.length*2];
        
        for (int i = 0; i < phases.length; i++) {
            tempPhases[i] = phases[i];
            tempIsClose[i] = isClose[i];
        }
        phases = tempPhases;
        isClose = tempIsClose;
    }
    
    private int toIndex(Phase phase) {
        return toIndex(phase.symbol());
    }
    
    private int toIndex(String symbol) {
        Integer index = symbolToIndex.get(symbol);
        if (index == null) {
            index = new Integer(cursor++);
            symbolToIndex.put(symbol, index);
        }
        return index;
        
    }
    
    public Phase getPath() {
        return finalPhase;
    }
    
    public static void main(String[] args) {
        
        Board board = new Board(4);
        board.shuffe();
        board.show();
        
        Timer t = Timer.create();
        
        t.click();
        Seacher s = new Seacher(board);
        t.stop();
        
        System.out.println("Start to reorder.");
        Phase p = s.getPath();
        Stack<Dir> stack = new RaysStack<>();
        while (p.prev() != null) {
            stack.push(p.getDir());
            p = p.prev();
        }
        int count = 1;
        while (!stack.isEmpty()) {
            Dir dir = stack.pop();
            count ++;
            board.move(dir);
        }
        System.out.println("Reorder OK!!! Steps " + count);

        board.show();
        
    }
    
}
