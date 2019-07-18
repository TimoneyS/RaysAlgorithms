package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      By now, you are given a **secret signature** consisting of character 'D' and 'I'. 'D' represents a decreasing relationship between two numbers, 'I' represents an increasing relationship between two numbers. And our **secret signature** was constructed by a special integer array, which contains uniquely all the different number from 1 to n (n is the length of the secret signature plus 1). For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing special string that can't represent the "DI" **secret signature**.
 *      
 *      On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] could refer to the given **secret signature** in the input.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  str = "DI"
 *      	Output:  [2,1,3]
 *      
 *      Example 2:
 *      	Input: str = "I"
 *      	Output:  [1,2]
 *      	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-permutation/description
 * @date   2019-07-11 18:38:17
 */
public class L_0884_Find_Permutation {


    static class Solution {
    
        public int[] findPermutation(String s) {
            int i = 0, j = 0;
            int[] ans = new int[s.length() + 1];
            while (j < s.length()) {
                if (s.charAt(j) == 'I') {
                    ans[i] = j + 1;
                    while (++i <= j) {
                        ans[i] = ans[i-1] - 1;
                    }
                }
                j++;
            }
            ans[i] = j + 1;
            while (++i <= j) {
                ans[i] = ans[i-1] - 1;
            }
            return ans;
        }
        
    }
    
    public static void main(String[] args) {
        
        String s = "DDID";
        Out.p(new Solution().findPermutation(s));
        
    }

}
