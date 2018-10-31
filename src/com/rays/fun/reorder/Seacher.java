package com.rays.fun.reorder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.ray.io.Out;
import com.ray.util.Timer;
import com.ray.util.collections.RaysIndexMinPQ;
import com.ray.util.collections.RaysStack;

public class Seacher {

    Map<String, Integer> tagToIndex = new HashMap<>();
    
    Map<Integer, Board>     boardList  = new HashMap<>();
    Map<Integer, Integer>   distTo     = new HashMap<>();
    Map<Integer, Integer>   operate    = new HashMap<>();
    Map<Integer, Integer>   pathTo     = new HashMap<>();
    
    RaysIndexMinPQ<Integer> pq = new RaysIndexMinPQ<>(1000000);
            
    int                  indexSeq   = 0;
    Board terminal;
    
    
    public Seacher(Board board) {

        terminal = board.clone().reset();
        
        int index = getIndex(board);
        
        pathTo.put(index, -1);
        distTo.put(index, 0);
        boardList.put(index, board);
        pq.insert(index, 0 + board.getWeight());
        

        findPath();
        
    }

    public void findPath() {
        
        while (!pq.isEmpty()) {
        
            int index = pq.delMin();
            
            Board[] boards = boardList.get(index).adj();
                
            for (int i = 0; i < boards.length; i++) {
                Board board = boards[i];
                
                int dist = distTo.get(index);
                int adjIndex = getIndex(board);
                
                if (adjIndex == index)
                    continue;
                
                Integer oldPath = pathTo.get(adjIndex);
                
                if (oldPath == null) {
                    pathTo.put(adjIndex, index);
                    operate.put(adjIndex, i);
                    distTo.put(adjIndex, dist + 1);
                    pq.insert(adjIndex, dist + 1 + board.getWeight());
                }
                if (board.equals(terminal)) return;
            }
        }
    }

    public int getIndex(Board board) {
        String tag = board.getTag();
        
        Integer index = tagToIndex.get(tag);
        if (index == null) {
            index = indexSeq++;
            tagToIndex.put(tag, index);
            boardList.put(index, board);
        }
        return index;

    }
    
    public static void main(String[] args) {
        Board b = new Board(3, 3);
        
        Random r = new Random(42);
        int times = 10000;
        
        for (int i = 0; i < times; i++) {
            b.move(r.nextInt(4));
        }
        
        b.show();
        Timer t = Timer.create();
        
        t.click();
        Seacher s = new Seacher(b);
        t.stop();
        
        int index = s.getIndex(s.terminal);
        
        Out.p("tIndex = " +  index);
        
        RaysStack<String> stack = new RaysStack<>();
        while (index != 0) {
            
            int oper = s.operate.get(index);
            
            if (oper == 0) stack.push("ио");
            if (oper == 1) stack.push("об");
            if (oper == 2) stack.push("вС");
            if (oper == 3) stack.push("ср");

            index = s.pathTo.get(index);
            
        }
        
        int i = 0;
        while  (!stack.isEmpty()) {
            i ++;
            stack.pop();
//            Out.p(stack.pop());
        }
        
        Out.p ("step = " + i);
        
    }

}
