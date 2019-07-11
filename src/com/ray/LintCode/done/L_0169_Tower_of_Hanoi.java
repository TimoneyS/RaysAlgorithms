package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *      Tower of Hanoi problem, is a well-known problem. On the A, B, C three pillars, there are n disks of different sizes (radii 1-n), they are stacked in a start on A, your goal is to a minimum number of legal steps to move all the plates move from A to C tower tower.
 *      Each step in the rules of the game are as follows:
 *       1. Each step is only allowed to move a plate (from the top of one&nbsp;pillars&nbsp;to the top of another&nbsp;pillars)
 *       2. The process of moving, you must ensure that a large dish is not at the top of the small plates (small can be placed on top of a large, below the maximum plate size can not have any other dish)
 *      
 *      **Diagram:**
 *      ![hanoi](http://ww4.sinaimg.cn/large/0060lm7Tly1fphwld4at7j30dm05q74d.jpg "hanoi")
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:n = 2
 *      Output: ["from A to B","from A to C","from B to C"]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:n = 3
 *      Output:["from A to C","from A to B","from C to B","from A to C","from B to A","from B to C","from A to C"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/tower-of-hanoi/description
 * @date   2019-07-11 18:31:30
 */
public class L_0169_Tower_of_Hanoi {

    static class Solution {
        
        String[] NAME = {"A", "C", "B"};
        
        /**
         * @param n: the number of disks
         * @return: the order of moves
         */
        public List<String> towerOfHanoi(int n) {
            List<String> rs = new ArrayList<>();
            hanoi(rs, n, 0, 1, 2);
            return rs;
        }
        
        public void hanoi(List<String> rs, int n, int a, int b, int c) {
            
            if (n == 1) {
                rs.add("from "+ NAME[a] +" to " + NAME[b]);
                return;
            }
            
            hanoi(rs, n-1, a, c, b);
            hanoi(rs, 1,   a, b, c);
            hanoi(rs, n-1, c, b, a);
        }
        
    }
    
    public static void main(String[] args) {
        
        int n = 15;
        
        Solution sol = new Solution();
        sol.towerOfHanoi(n);
        
    }

}
