package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      A message containing letters from `A-Z` is being encoded to numbers using the following mapping:
 *      ```
 *      'A' -> 1
 *      'B' -> 2
 *      ...
 *      'Z' -> 26
 *      ```
 *      Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "12"
 *      Output: 2
 *      Explanation: It could be decoded as AB (1 2) or L (12).
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "10"
 *      Output: 1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/decode-ways/description
 * @date   2019-07-11 18:33:44
 */
public class L_0512_Decode_Ways {

    /**
     * 假设 dp[i] 从 i 开始，s 的解析方式数量
     * 
     * 则
     *      dp[i] = dp[i+1] * n1 + dp[i+2] * n2
     *      
     *      n1 表示当前字符是否可以解码
     *      n2 表示当前字符同相邻字符合并是否可以解码，是为1，否为0
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int numDecodings(String s) {
            if (s.length() == 0)  return 0;
            
            int[] dp = new int[s.length()+2];
            dp[s.length()] = 1;
            
            for (int i = s.length()-1; i >= 0; i --) {
                char c1 = s.charAt(i);
                char c2 = i == s.length() - 1 ? 0 : s.charAt(i+1);
                int n1 = 0, n2 = 0;
                if (c1 != '0') {
                    n1 = 1;
                    if (c1 == '1' || c1 == '2' && c2 < '7') {
                        n2 = 1;
                        dp[i] += dp[i+2];
                    }
                }
                dp[i] = n1 * dp[i+1] + n2 * dp[i+2]; // 为了和 L_0676_Decode_Ways_II 练习，写成这种形式，实际上直接赋值即可
            }
            
            return dp[0];
        }
        
    }
    
    public static void main(String[] args) {
        String s = "120";
        Out.p(new Solution().numDecodings(s));
        
    }

}
