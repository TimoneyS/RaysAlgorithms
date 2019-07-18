package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      There are `N` children standing in a line. Each child is assigned a rating value. Given array `ratings` representing all rating value of these children.
 *      
 *      You are giving candies to these children subjected to the following requirements:
 *      
 *      * Each child must have at least one candy.
 *      
 *      * Children with a higher rating get more candies than their neighbors.
 *      
 *      What is the minimum candies you must give?
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [1, 2]
 *      Output: 3
 *      Explanation: Give the first child 1 candy and give the second child 2 candies.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [1, 1, 1]
 *      Output: 3
 *      Explanation: Give every child 1 candy.
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input: [1, 2, 2]
 *      Output: 4
 *      Explanation: 
 *          Give the first child 1 candy.
 *          Give the second child 2 candies.
 *          Give the third child 1 candy.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/candy/description
 * @date   2019-07-11 18:32:42
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
