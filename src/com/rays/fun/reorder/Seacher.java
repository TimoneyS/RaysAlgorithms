package com.rays.fun.reorder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;
import com.ray.util.Timer;
import com.ray.util.collections.MinPQ;
import com.ray.util.collections.RaysMinPQ;
import com.ray.util.collections.RaysStack;

public class Seacher {

    static class Entry implements Comparable<Entry> {
        
        int index;
        int dist;
        int weight;
        
        public Entry(int index, int dist, int weight) {
            this.index = index;
            this.dist = dist;
            this.weight = weight;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(dist+weight, o.dist+o.weight);
        }
        
    }

    boolean[]    closed;
    boolean[]    opened;
    int[]        pathTo;
    int[]        dir;
    Board[]      boards;
    
    int                  indexSeq   = 0;
    MinPQ<Entry>         PQ       = new RaysMinPQ<>();
    Map<String, Integer> indexMap = new HashMap<>();
    
    
    Board terminal;
    
    public Seacher(Board board) {

        terminal = new Board(board.getWidth(), board.getHeight());
        closed = new boolean[16];
        opened = new boolean[16];
        pathTo = new int[16];
        dir    = new int[16];
        boards = new Board[16];
        
        int index = getIndex(board);
        
        PQ.insert(new Entry(index, 0, board.getWeight()));
        
        pathTo[index] = -1;
        opened[index] = true;
        dir[index]    = -1;
        boards[index] = board;
        
        findPath();
        
    }

    public void findPath() {
        
        while (!PQ.isEmpty()) {
        
            Entry minEntry = PQ.delMin();
            
            int index = minEntry.index;
            int dist = minEntry.dist;
            closed[index] = true;
            
            Board[] adj = boards[index].adj();
                
            for (int i = 0; i < adj.length; i++) {
                
                Board board = adj[i];
                int adjIndex = getIndex(board);
                
                if (adjIndex >= boards.length) {
                    Board[] oldArr = boards;
                    boards = new Board[boards.length*2];
                    for (int j = 0; j < oldArr.length; j++) {
                        boards[j] = oldArr[j];
                    }
                    dir = ArrayUtil.resize(dir);
                    pathTo = ArrayUtil.resize(pathTo);
                    opened = ArrayUtil.resize(opened);
                    closed = ArrayUtil.resize(closed);                    
                }
                
                if (closed[adjIndex] || opened[adjIndex]) continue;
                
                PQ.insert(new Entry(adjIndex, dist+1, board.getWeight()));
                
                pathTo[adjIndex] = index;
                opened[index] = true;
                dir[adjIndex]    = i;
                boards[adjIndex] = board;
                
                if (board.equals(terminal)) return;
            }
        }
    }

    public int getIndex(Board board) {
        String tag = board.getTag();
        
        Integer index = indexMap.get(tag);
        if (index == null) {
            index = indexSeq++;
            indexMap.put(tag, index);
        }
        return index;

    }
    
    public static void main(String[] args) {
        Board b = new Board(4, 4);
        
        Random r = new Random(42);
        int times = 122;
        
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
        
        RaysStack<Integer> stack = new RaysStack<>();
        while (index != 0) {
            int dir = s.dir[index];
            stack.push(dir);
            index = s.pathTo[index];
        }
        
        int i = 0;
        while  (!stack.isEmpty()) {
            i ++;
            b.move(stack.pop());
        }
        
        
        b.show();
        Out.p ("step = " + i);
        
    }

}
