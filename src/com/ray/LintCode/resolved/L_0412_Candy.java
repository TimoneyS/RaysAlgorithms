package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * N 个小孩，每个小孩有一个对糖果的喜爱程度的值
 * 现在要给这些小孩子发糖果，发糖果时需要注意以下情况
 *      1. 每个小孩必须有一块糖果
 *      2. 如果有小孩对糖果的喜爱程度比旁边的孩子高，那这个小孩得到的糖果应该比他旁边的小孩多
 *
 * 计算你至少需要准备多少糖果，足够孩子们分享
 *
 * 如：
 *  [1, 2]      分发的糖果为 [1, 2]，      需要准备3块糖果
 *  [1, 1, 1]   分发的糖果为 [1, 1, 1]，需要准备3块糖果
 *  [1, 2, 2]   分发的糖果为 [1, 2, 1]，需要准备4块糖果
 * @author rays1
 *
 */
public class L_0412_Candy {

    /**
     * 遍历解决，首先每个孩子分发一块糖
     *  然后有孩子分配的糖果不符合条件就将其糖果数调整为旁边孩子的糖果数+1
     *  
     *  直到所有孩子分配的糖果符合条件。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int candy(int[] ratings) {
            
            int[] rs = new int[ratings.length];
            
            for (int i = 0; i < rs.length; i++) rs[i] = 1;
            
            int level = 0;
            while (level ++ < 10) {
                boolean flag = true;
                for (int i = 0; i < rs.length; i++) {
                    
                    int rl = Integer.MAX_VALUE, rr = Integer.MAX_VALUE;
                    int cl = 1, cr = 1;
                    if (i > 0)           { rl = ratings[i-1]; cl = rs[i-1];}
                    if (i < rs.length-1) { rr = ratings[i+1]; cr = rs[i+1];}
                    
                    if (ratings[i] > rr && rs[i] <= cr) {
                        rs[i] = cr + 1;
                        flag = false;
                    } else if (ratings[i] > rl && rs[i] <= cl) {
                        rs[i] = cl + 1;
                        flag = false;
                    }
                    
                }
                if (flag) break;
            }
            
            int count = 0;
            for (int i = 0; i < rs.length; i++) count += rs[i];
            return count;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] ratings = {1, 3, 5};
        
        Out.p(new Solution().candy(ratings));
        
    }

}
