package com.ray.LintCode.temp;

import java.util.HashSet;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a matrix, find a element that appear in all the rows in the matrix.You can assume that there is only one such element.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input :
 *      [
 *        [2,5,3],
 *        [3,2,1],
 *        [1,3,5]
 *      ]
 *      Output : 3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-elements-in-matrix/description
 * @date   2019-07-11 18:35:56
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
