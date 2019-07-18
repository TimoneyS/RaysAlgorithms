package com.ray.LintCode.temp;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` students and their test scores, expressed as (student number, test scores), sort by test scores in descending order, if the test scores are the same, sort the student number in ascending order.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: array = [[2,50],[1,50],[3,100]]
 *      Output: [[3,100],[1,50],[2,50]]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: array = [[2,50],[1,50],[3,50]]
 *      Output: [[1,50],[2,50],[3,50]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/multi-keyword-sort/description
 * @date   2019-07-11 18:37:33
 */
public class L_0846_Multi_keyword_Sort {

    static class Solution {
        
        public int[][] multiSort(int[][] array) {
            Arrays.sort(array, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
            return null;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
