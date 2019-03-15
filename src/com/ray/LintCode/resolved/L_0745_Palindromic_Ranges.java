package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 如果一个正整数的十进制表示(没有前导零)是一个回文字符串，那么它就是回文数。
 * 如果一个整数范围包含偶数个回文，那么它就是一个有趣的范围(包含边界)。
 * 
 * 确定一个范围 [L, R] 包含多少有趣的子集。
 *
 * @author rays1
 *
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
