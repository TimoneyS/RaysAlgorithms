package com.ray.LintCode.resolved;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 *
 * 实现 O(m+n) 时间复杂度的 strStr 方法
 *
 * strStr 返回目标字符串在原始字符串中的第一次出现的索引。
 * 目标字符串长度为 m，原始字符串长度为 n。
 * 如果不存在，返回 -1
 *
 * @author rays1
 *
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
