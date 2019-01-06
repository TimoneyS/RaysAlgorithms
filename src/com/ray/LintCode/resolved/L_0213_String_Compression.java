package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0213_String_Compression {

    /**
     * 所有字符压缩次数为1，则不显示次数
     * 有字符被压缩，则需要显示一次的次数
     * @author rays1
     *
     */
    static class Solution {
        public String compress(String s) {
            if (s == null || s.length() == 0) return s;
            
            String str = s+"#";
            StringBuilder sb = new StringBuilder();
            
            char prev = str.charAt(0);
            int count = 1;
            int prevCount = -1;
            boolean flag = false;
            
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == prev) {
                    count ++;
                } else {
                    sb.append(prev);
                    sb.append(count);
                    if (prevCount != -1 && prevCount != count)
                        flag = true;
                    prev = str.charAt(i);
                    prevCount = count;
                    count = 1;
                }
            }
            if (prevCount != -1 && prevCount != count)
                flag = true;
            sb.append(prev);
            sb.append(count);
            
            if (!flag) {
                for (int i = sb.length()-1; i >= 0; i -= 2) {
                    sb.deleteCharAt(i);
                } 
            }
            
            while (sb.charAt(sb.length()-1) != '#')
                sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            
            return sb.length() < s.length() ? sb.toString() : s;
        }
    }
    
    public static void main(String[] args) {
        String s = "aabbcc";
        Out.p(new Solution().compress(s));
    }

}
