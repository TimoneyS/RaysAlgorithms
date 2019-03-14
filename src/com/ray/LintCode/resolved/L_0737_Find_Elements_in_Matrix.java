package com.ray.LintCode.resolved;

import java.util.HashSet;

import com.ray.io.Out;

/**
 * 给一矩阵, 找到矩阵中每一行都出现的元素. 你可以假设矩阵中只有一个满足条件的元素.
 *
 * @author rays1
 *
 */
public class L_0737_Find_Elements_in_Matrix {

    static class Solution {
    
        public int FindElements(int[][] Matrix) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int n : Matrix[0]) set1.add(n);
            for (int i = 1; i < Matrix.length; i ++) {
                for (int n : Matrix[i]) {
                    if (set1.contains(n)) set2.add(n);
                }
                HashSet<Integer> t = set1;
                set1 = set2;
                set2 = t;
                set2.clear();
            }
            for (int n : set1) {
                return n;
            }
            return -1;
        }        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
