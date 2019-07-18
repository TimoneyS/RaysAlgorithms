package com.ray.LintCode.temp;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      Implement `strStr` function in O(n + m) time.
 *      
 *      `strStr` return the first index of the target string in a source string. The length of the target string is *m* and the length of the source string is *n*.
 *      If target does not exist in source, just return -1.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：source = "abcdef"， target = "bcd"
 *      Output：1
 *      Explanation：
 *      The position of the first occurrence of a string is 1.
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：source = "abcde"， target = "e"
 *      Output：4
 *      Explanation：
 *      The position of the first occurrence of a string is 4.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/strstr-ii/description
 * @date   2019-07-11 18:34:22
 */
public class L_0594_strStr_II {

    /**
     * 使用 KMP算法会导致空间超出预期
     * 因此需要使用 RabinKarp
     * 然后注意各种极端情况如
     *      模式和带查找的文本为 null "" 等
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        private int    M;           // 模式长度
        private long   Q=  997;     // 大素数
        private int    R = 256;     // 字母表大小
        private long   RM = 1;      // R ^ (M-1) % Q
        
        private long hash(String key, int M) {
            long h = 0;
            for (int j = 0; j < M && j < key.length(); j ++) {
                h = (R*h+key.charAt(j)) % Q;
            }
            return h;
        }
        
        public int strStr2(String txt, String pat) {
            if (txt == null || pat == null) return -1;
            
            this.M = pat.length();
            for (int i = 0; i < M-1; i++) {
                RM = (R*RM) % Q;
            }
            long patHash = hash(pat, M);
            
            long txtHash = hash(txt, M);
            if (patHash == txtHash) return 0;
            
            for (int i = M; i < txt.length(); i++) {
                txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
                txtHash = (txtHash*R + txt.charAt(i)) % Q;
                if(txtHash == patHash) return i - M + 1;
            }
            return -1;
            
        }
    
    }
    
    public static void main(String[] args) {
        
        String source = "";
        String target = "a";
        
        Timer.CLICK();
        Out.p(new Solution().strStr2(source, target));
        Timer.STOP();
        
    }

}
