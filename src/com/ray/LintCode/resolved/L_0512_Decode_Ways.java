package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 使用如下映射，可以将英文消息编码成数字
 *      'A' -> 1
 *      'B' -> 2
 *          ...
 *      'Z' -> 26
 * 给定一个编码后的数字信息了，推断其可以解码成多少种结果。
 *
 * @author rays1
 *
 */
public class L_0512_Decode_Ways {

    static class Solution {
    
        public int numDecodings(String s) {
            
            if (s.length() == 0) {
                return 0;
            }
            
            int[] mem = new int[s.length() + 2];
            mem[s.length()] = 1;
            
            for (int i = s.length()-1; i >= 0; i --) {
                
                char c1 = s.charAt(i);
                char c2 = i == s.length() - 1 ? 0 : s.charAt(i+1);
                
                if (c1 == '0') {
                    mem[i] = 0;
                } else {
                    mem[i] = mem[i+1];
                    if (c1 == '1' || c1 == '2' && c2 < '7') {
                        mem[i] += mem[i+2];
                    }
                }
            }
            
            return mem[0];
        }
        
    }
    
    public static void main(String[] args) {
        String s = "120";
        Out.p(new Solution().numDecodings(s));
        
    }

}
