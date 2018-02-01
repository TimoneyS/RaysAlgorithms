package com.rays.fun.reorder;

import com.ray.common.utils.collections.MinPQ;
import com.ray.common.utils.collections.RaysMinPQ;

/**
 * 用于寻找能够恢复面板顺序的路径
 * @author rays1
 *
 */
public class Seacher {
    
    MinPQ<Path> open;
    
    public Seacher() {
        open = new RaysMinPQ<>();
    }
    
    public void search(Board board) {
        board = board.clone();
        
        Path p = new Path(board.getN(), 0, board.dist());
        
        
        
        
    }
    
}
