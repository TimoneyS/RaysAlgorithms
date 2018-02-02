package com.rays.fun.reorder;

import java.util.HashMap;
import java.util.Map;

import com.ray.common.collections.MinPQ;
import com.ray.common.collections.RaysMinPQ;

/**
 * 用于寻找能够恢复面板顺序的路径
 * @author rays1
 *
 */
public class Seacher {
    
    private MinPQ<Path>         open;    // open 列表
    private Map<String, Path>   closed;  // close 列表
    
    public Seacher() {
        open = new RaysMinPQ<>();
        closed = new HashMap<>();
    }
    
    public Path search(Board board) {
        
        Path start = new Path(board, 0, null, null);
        open.insert(start);
        
        Path result = null;
        while (!open.isEmpty()) {
            Path path = open.delMin();
            closed.put(path.symbol(), path);
            if (path.isGoal()) { result = path; break;}
            for (Path p : path.adj()) {
                if (closed.get(p.symbol()) == null) {
                    open.insert(p);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Dir[] dirs = new Dir[] {
                Dir.UP,
                Dir.UP,
                Dir.LEFT,
                Dir.LEFT,
        };
        
        Board board = new Board(3);
        for (Dir dir : dirs)
            board.move(dir);
        
        Seacher s = new Seacher();
        s.search(board);
    }
    
}
