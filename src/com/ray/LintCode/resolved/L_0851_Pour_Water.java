package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * Given an elevation map, heights[i] representing the height of the terrain at that index.
 * The width at each index is 1. After V units of water fall at index K, how much water is at each index?
 *
 * Water first drops at index K, and then it flows according to the following rules:
 *
 *      1. First, the droplet can not move to higher level.
 *      2. If the droplet would eventually fall by moving left, then move left.
 *      3. Otherwise, if the droplet would eventually fall by moving right, then move right.
 *      4. Otherwise, rise at it's current position.
 *      5. Here, "eventually fall" means that the droplet will eventually be at a lower level if it moves in that direction.
 *           Also, "level" means the height of the terrain plus any water in that column.
 *
 * Youcan assume there's infinitely high terrain on the two sides out of bounds of the array.
 * Also, there could not be partial water being spread out evenly on more than 1 grid block - each unit of water has to be in exactly one block.
 *
 * @author rays1
 *
 */
public class L_0851_Pour_Water {

    /**
     * 按照提议的暴力搜索
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        // V 滴水落到 k 的位置，水优先向左移动
        public int[] pourWater(int[] heights, int V, int K) {
            int n = heights.length;
            
            for (int i = 0; i < V; i++) {
                int index = K;
                for (int j = K; j > 0; j--) {
                    if (heights[j] > heights[j-1])
                        index = j-1;
                    else if (heights[j] < heights[j-1])
                        break;
                }
                
                if (index == K) {
                    for (int j = K; j < n-1; j ++) {
                        if (heights[j] > heights[j+1])
                            index = j+1;
                        else if (heights[j] < heights[j+1])
                            break;
                    }
                }
                heights[index]++;
            }
            
            return heights;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] heights = {1,2,1,1};
        int V = 5;
        int K = 2;
        
        Out.p(new Solution().pourWater(heights, V, K));
        
    }

}
