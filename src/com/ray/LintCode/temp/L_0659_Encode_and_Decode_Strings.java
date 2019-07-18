package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 *      
 *      Please implement `encode` and `decode`
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: ["lint","code","love","you"]
 *      Output: ["lint","code","love","you"]
 *      Explanation:
 *      One possible encode method is: "lint:;code:;love:;you"
 *      ```
 *      **Example2**
 *      ```
 *      Input: ["we", "say", ":", "yes"]
 *      Output: ["we", "say", ":", "yes"]
 *      Explanation:
 *      One possible encode method is: "we:;say:;:::;yes"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/encode-and-decode-strings/description
 * @date   2019-07-11 18:35:11
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
