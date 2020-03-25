package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import com.ray.io.Out;
import com.ray.leetcode.util.NestedInteger;

/**
 * 描述：
 *      Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: the list [[1,1],2,[1,1]], 
 *      Output: 10. 
 *      Explanation:
 *      four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10
 *      ```
 *      Example 2:
 *      ```
 *      Input: the list [1,[4,[6]]], 
 *      Output: 27. 
 *      Explanation:
 *      one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4 * 2 + 6 * 3 = 27
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/nested-list-weight-sum/description
 * @date   2019-07-11 18:33:57
 */
public class L_0551_Nested_List_Weight_Sum {

    static class Solution {
        
        public int depthSum(List<NestedInteger> nestedList) {
            Queue<NestedInteger> queueHot = new ArrayDeque<>();
            Queue<NestedInteger> queueCol = new ArrayDeque<>();
            queueHot.addAll(nestedList);
            
            int deepth = 1, sum = 0;
            while (!queueHot.isEmpty()) {
                NestedInteger ni = queueHot.poll();
                if (ni.isInteger()) {
                    sum += ni.getInteger()*deepth;
                } else {
                    queueCol.addAll(ni.getList());
                }
                
                if (queueHot.isEmpty()) {
                    Queue<NestedInteger> t = queueHot;
                    queueHot = queueCol;
                    queueCol = t;
                    deepth ++;
                }
            }
            
            
            return sum;
        }
 
    }
    
    /**
     * 递归解法
     * @author rays1
     *
     */
    static class SolutionR {
    
        public int depthSum(List<NestedInteger> nestedList) {
            int sum = 0;
            for (NestedInteger ni : nestedList)
                sum += sum(ni, 1);
            return sum;
        }
        
        public int sum(NestedInteger ni, int deepth) {
            if (ni.isInteger()) return ni.getInteger() * deepth;
            int sum = 0;
            for (NestedInteger tni : ni.getList())
                sum = sum(tni, deepth + 1);
            return sum;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
