package com.rays.fun.reorder;

import java.util.HashMap;
import java.util.Map;

import com.ray.common.collections.MinPQ;
import com.ray.common.collections.RaysMinPQ;
import com.ray.util.Timer;

/**
 * ����Ѱ���ܹ��ָ����˳���·��
 * @author rays1
 *
 */
public class Seacher {
    
    private MinPQ<Phase>             open;       // open �б�
    private Map<String, Boolean>    closed;  // close �б�
    private Phase path;
    
    public Seacher(Board board) {
        
        open = new RaysMinPQ<>();
        closed = new HashMap<>();
        
        Phase start = new Phase(board, 0, null, null);
        open.insert(start);
        
        while (!open.isEmpty()) {
            Phase min = open.delMin();
            closed.put(min.symbol(), true);
            
            if (min.isOrder()) {
                path = min;
                break;
            }
            
            for (Phase p : min.adj()) {
                if (closed.get(p.symbol()) == null) {
                    open.insert(p);
                }
            }
            
        }
        
    }
    
    public Phase getPath() {
        return path;
    }
    
    public static void main(String[] args) {
        Dir[] dirs = new Dir[] {
                Dir.UP,
                Dir.UP,
                Dir.LEFT,
                Dir.LEFT,
        };
        
        Board board = new Board(5);
        
        board.shuffe();
        
        Timer t = Timer.create();
        
        t.click();
        Seacher s = new Seacher(board);
        t.stop();
    }
    
}
