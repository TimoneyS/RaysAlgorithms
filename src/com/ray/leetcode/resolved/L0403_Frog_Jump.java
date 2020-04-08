package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Frog Jump
 * -----------------------------------------------------------------------------
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * Note:
 * The number of stones is &ge; 2 and is 
 * Each stone's position will be a non-negative integer 31.
 * The first stone's position is always 0.
 *
 * Example:
 *      Example 1
 *      [0,1,3,5,6,8,12,17]
 *      There are a total of 8 stones.
 *      The first stone at the 0th unit, second stone at the 1st unit,
 *      third stone at the 3rd unit, and so on...
 *      The last stone at the 17th unit.
 *      Return true. The frog can jump to the last stone by jumping 
 *      1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
 *      2 units to the 4th stone, then 3 units to the 6th stone, 
 *      4 units to the 7th stone, and 5 units to the 8th stone.
 *      Example 2
 *      [0,1,2,3,4,8,9,11]
 *      Return false. There is no way to jump to the last stone as 
 *      the gap between the 5th and 6th stone is too large.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/frog-jump/
 * @since   2020-04-07 22:32:01
 */
public class L0403_Frog_Jump {
    /**
     * 使用一个集合记录青蛙在每个石头 i 上，可以选择的所有跳跃距离
     * 在石头 i 上按照所有可能的距离向前跳跃，若经过距离 s 能够跳跃的石头 j， 则将s-1, s, s+1 加入石头 j 可选的跳跃距离列表。
     *
     * 最终如果能够到达最后一块石头，那么最后一块石头的可选挑选距离列表必然是非空的。
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
        Out.p(new Solution());
    }
}
