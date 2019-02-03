package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import com.ray.LintCode.util.NestedInteger;
import com.ray.io.Out;

/**
 * 
 * 给定一个嵌套列表，返回每个整数乘以其深度的后的总和
 * 
 * 如：
 *      输入：[[4,2],3]，
 *          4*2 + 2*2 + 3*1
 *      输出：15
 * @author rays1
 *
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
