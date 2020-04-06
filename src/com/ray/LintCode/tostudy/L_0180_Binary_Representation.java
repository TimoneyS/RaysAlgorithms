package com.ray.LintCode.tostudy;

import java.util.HashSet;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a (decimal - _e.g._ 3.72) number that is passed in as a string, return the binary representation that is passed in as a string. If the fractional part of the number can not be represented accurately in binary with at most 32 characters, return `ERROR`.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: "3.72"
 *      Output: "ERROR"
 *      ```
 *      
 *      Explanation: $(3.72)_{10} = (11.10111000010100011111\cdots)_2$ We can't represent it in 32 characters.
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: "3.5"
 *      OUtput: "11.1"
 *      ```
 *      
 *      Explanation: $(3.5)_{10}=(11.1)_2$
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-representation/description
 * @date   2019-07-11 18:31:39
 */
public class L_0180_Binary_Representation {

    static class Solution {
        
        private String parseInteger(String str) {
            if (str.equals("")) return "0";
            int n = Integer.parseInt(str);
            return Integer.toBinaryString(n);
        }
        
        private String parseFloat(String str) {
            double d = Double.parseDouble("0." + str);
            StringBuilder sb = new StringBuilder();
            HashSet<Double> set = new HashSet<Double>();
            while (d > 0) {
                if (sb.length() > 32 || set.contains(d)) {
                    return "ERROR";
                }
                set.add(d);
                d = d * 2;
                if (d >= 1) {
                    sb.append("1");
                    d = d - 1;
                } else {
                    sb.append("0");
                }
            }
            
            return sb.toString();
        }
        
        public String binaryRepresentation(String n) {
            
            if (n.indexOf('.') == -1) return parseInteger(n);
            
            String[] params = n.split("\\.");
            String flt = parseFloat(params[1]);
            
            if (flt == "ERROR") return flt;
            
            if (flt.equals("0") || flt.equals("")) return parseInteger(params[0]);
            return parseInteger(params[0]) + "." + flt;
        }
    }

    public static void main(String[] args) {
        String n = ".5";
        
        Out.p(new Solution().binaryRepresentation(n));
    }

}
