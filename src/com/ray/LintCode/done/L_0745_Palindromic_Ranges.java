package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      A positive integer is a palindrome if its decimal representation (without leading zeros) is a palindromic string (a string that reads the same forwards and backwards). For example, the numbers `5`, `77`, `363`, `4884`, `11111`, `12121` and `349943` are palindromes.
 *      
 *      A range of integers is interesting if it contains an even number of palindromes. The range `[L, R]`, with `L <= R`, is defined as the sequence of integers from `L` to `R` (inclusive): (L, L+1, L+2, …, R-1, R). `L` and `R` are the range’s first and last numbers.
 *      
 *      The range `[L1, R1]` is a subrange of `[L, R]` if `L` <= `L1` <= `R1` <= `R`. Your job is to determine how many interesting subranges of `[L, R]` there are.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : L = 1, R = 2
 *      Output : 1
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : L = 1, R = 7
 *      Output : 12
 *      ```
 *      **Example 3:**
 *      ```
 *      Input : L = 87, R = 88
 *      Output : 1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/palindromic-ranges/description
 * @date   2019-07-11 18:36:01
 */
public class L_0745_Palindromic_Ranges {

    /**
     * dp[i] 到 i 为止，每个数字前的回文数的数量
     * dp[i] - dp[j] = i,j 之间的回文数的数量，如果是偶数则 计数 +1
     * @author rays1
     *
     */
    static class Solution {
    
        public int PalindromicRanges(int L, int R) {
            if(R < L) return 0;
            if(R == L) return 1;
            
            // 用数组保存所有的 L R 之间的回文数
            int [] dp = new int[R - L + 2];
            for(int i = L; i <= R; ++i) {
                dp[i - L + 1] = dp[i - L]; 
                if(isPal(i)) {
                    dp[i - L + 1]++;
                }
            }
            // 检查所有情况
            int count = 0;
            int len = R - L + 2;
            for(int i = 1; i < len; ++i) {
                for(int j = i - 1; j >= 0; j--) {
                    if((dp[i] - dp[j]) % 2 == 0) {
                        ++count;
                    }
                }
            }
            return count;
        }
        
        // 判断是否回文
        boolean isPal(int v) {
            int rev = 0;
            int temp = v;
            while(temp != 0) {
                rev = rev * 10;
                rev += temp % 10;
                temp /= 10;
            }
            return v == rev;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
