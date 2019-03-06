package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 一个消息包含大写字母并且已经被按照如下规则编码
 *  'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
 * 
 * 在此基础上，现在一个编码后的字符串还可以包含*， 它代表了 1 到 9 的数字中的其中一个。
 * 给出包含数字和字符 * 的编码消息, 返回所有解码方式的数量. 因为结果可能很大, 所以结果需要对 10^9 + 7 取模
 *
 * @author rays1
 *
 */
public class L_0676_Decode_Ways_II {

    /**
     * 1. * 号单独解析，有 9 中可能
     * 2. * 号和其他数量相连有两种情况
     *    1.1. * 在前 *1 *2 *6 每种有2种情况，*7~*9 每种有1种情况  
     *    1.2  * 在后 1* 18种， 2* 6种，其他数字都是 0种。
     *    
     * 设 dp[i] 表示从 i 开始，字符串可以解析的方式数量
     *      dp[i] = way(i) * dp[i+1] + way(i, i+1) * dp[i+2]
     *    
     * @author rays1
     *
     */
    static class Solution {
    
        public int numDecodings(String s) {
            long[] dp = new long[s.length()+2];
            dp[s.length()] = 1;
            
            for (int i = s.length()-1; i >= 0; i--) {
                dp[i] = way(s, i) * dp[i+1] + way(s, i, i+1) * dp[i+2];
                dp[i] = dp[i] % 1000000007;
            }
            
            return (int) dp[0] ;
        }
        
        int way(String s, int i) {
            char c = i >= s.length() ? '-' : s.charAt(i);
            if (c == '*') return 9;
            else if (c == '0') return 0;
            else if (c == '-') return 1;
            else return 1;
        }
        
        int way(String s, int i, int j) {
            if (i >= s.length() || j >= s.length() ) return 1;
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            
            if (c1 == '*' && c2 == '*') {
                return 15;
            } else if (c1 == '*' && c2 < '7') {
                return 2;
            } else if (c1 == '*' && c2 > '6') {
                return 1;
            } else if (c2 == '*' && c1 == '1') {
                return 9;
            } else if (c2 == '*' && c1 == '2'){
                return 6;
            } else if (c1 == '1' || c1 == '2' && c2 < '7') {
                return 1;
            }
            return 0;
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "**********1111111111";
        
        Out.p(new Solution().numDecodings(s));
        
    }

}
