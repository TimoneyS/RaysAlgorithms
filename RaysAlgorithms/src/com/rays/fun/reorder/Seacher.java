package com.rays.fun.reorder;

import com.ray.common.utils.collections.MinPQ;
import com.ray.common.utils.collections.RaysMinPQ;

/**
 * ����Ѱ���ܹ��ָ����˳���·��
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
