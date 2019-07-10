package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个原始字符串和目标字符串，返回目标字符串第一次在原始字符串中出现的位置。
 *      如果不存在，则返回-1
 *
 * 用例：
 *      **Example 1:**
 *      Input:source = "abcdabcdefg" ，target = "bcd"
 *      Output: 1	
 *      Explanation: If the source contains the target content,
 *       return the location where the target first appeared in the source.
 *
 * 挑战：
 *      时间复杂度 O(n) 
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/implement-strstr/description
 * @date   2019-07-10 21:57:41
 */
public class L_0013_Implement_strStr {

    static class Solution {
    
        public int strStr(String source, String target) {
            int j,M = target.length();
            int i,N = source.length();
            
            for (i = 0, j = 0; i < N && j < M; i ++) {
                
                if (source.charAt(i) == target.charAt(j)) {
                    j ++;
                } else {
                    // 回退本次查找
                    i -= j;
                    j = 0;
                }
            }
            if (j == M) return i - M;
            else        return -1;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
