package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.ray.io.Out;

/**
 * 一只青蛙准备穿过一条河流。河流可以划分成 x 个单元，每个单元可能包含也可能不包含一块石头。青蛙只能跳到石头上不能跳入河中。
 *
 * 给定一个石头的所在单元的位置的列表，并按照升序排列，推断青蛙是否可以穿过河流。
 * 假设青蛙第一次跳跃距离为一个单元，
 * 如果青蛙上一次跳跃的距离为 k 则下一次的跳跃距离只能为 k-1，k 或者 k+1，注意青蛙只能向前跳跃。
 *
 * 例如：
 *      stones = [0,1,3,5,6,8,12,17]
 *      
 *      青蛙可以按照如下的跳跃方式：
 *         
 *          0 1  3  5 6  8    12     17
 *            1  2  2    3     4      5  
 *         
 *         跳跃 1 到第 2 块石头
 *         跳跃 2 到第 3 块石头
 *         跳跃 2 到第 4 块石头
 *         跳跃 3 到第 6 块石头
 *         跳跃 4 到第 7 块石头
 *         跳跃 5 到第 8 块石头
 *         
 * @author rays1
 *
 */
public class L_0622_Frog_Jump {

    /**
     * 使用一个集合记录青蛙在每个石头 i 上，可以选择的所有跳跃距离
     * 在石头 i 上按照所有可能的距离向前跳跃，若经过距离 s 能够跳跃的石头 j， 则将s-1, s, s+1 加入石头 j 可选的跳跃距离列表。
     * 
     * 最终如果能够到达最后一块石头，那么最后一块石头的可选挑选距离列表必然是非空的。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean canCross(int[] stones) {
            
            Map<Integer, Integer> idxMap = new HashMap<>();
            Map<Integer, HashSet<Integer>> jumpMap = new HashMap<>();
            
            for (int i = 0; i < stones.length; i++) {
                idxMap.put(stones[i], i);
                jumpMap.put(stones[i], new HashSet<>());
            }
            
            jumpMap.get(stones[0]).add(1);
            
            for (int p : stones) {
                for (int j : jumpMap.get(p)) {
                    Integer idx = idxMap.get(p+j);
                    if ( idx == null || j == 0) continue;
                    HashSet<Integer> set = jumpMap.get(stones[idx]); 
                    set.add(j-1);
                    set.add(j);
                    set.add(j+1);
                }
            }
            
            return !jumpMap.get(stones[stones.length-1]).isEmpty();
        }

    }
    
    public static void main(String[] args) {
        
        int[] stones = {0,1,2,3,4,8,9,11};
        
        Out.p(new Solution().canCross(stones));
        
    }

}
