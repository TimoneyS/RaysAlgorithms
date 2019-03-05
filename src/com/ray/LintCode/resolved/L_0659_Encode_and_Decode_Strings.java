package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 设计算法来编码和解码列表中的字符串。已经编码的字符串之后会通过网络发送同时也会被解码回到原始的字符串列表。
 *
 * @author rays1
 *
 */
public class L_0659_Encode_and_Decode_Strings {

    static class Solution {
    
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                for (int i = 0; i < s.length(); i ++) {
                    char c = s.charAt(i);
                    sb.append(c);
                    if (c == ':') sb.append(c);
                }
                sb.append(":;");
            }
            return sb.toString();
        }

        public List<String> decode(String str) {
            List<String> rs = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ':') c = str.charAt(++i);
                if (c == ';') {
                    rs.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
