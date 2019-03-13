package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 *
 * 给一包含大写字母和整数(从 0 到 9)的字符串, 试写一函数返回有序的字母以及数字和
 *
 * @author rays1
 *
 */
public class L_0720_Rearrange_a_String_With_Integers {

    static class Solution {
    
        public String rearrange(String str) {
            byte[] bytes = str.getBytes();
            Arrays.sort(bytes);
            int cursor = 0, rs = 0;
            while (cursor < bytes.length) {
                if (bytes[cursor] > '9') break;
                rs += bytes[cursor] - '0';
                cursor++;
            }
            
            StringBuilder sb = new StringBuilder();
            while (cursor < bytes.length) {
                sb.append((char)bytes[cursor++]);
            }
            if(str.length() > 0) sb.append(rs);
            
            return sb.toString();
        }
    
    }
    
    public static void main(String[] args) {
        
        String str = "1AB2";
        Out.p(new Solution().rearrange(str));
        
    }

}
