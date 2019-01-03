package com.ray.LintCode.resolved;

import java.util.HashSet;

import com.ray.io.Out;

/**
 * Given a (decimal - e.g. 3.72) number that is passed in as a string,
 * return the binary representation that is passed in as a string.
 * If the fractional part of the number can not be represented accurately in binary with at most 32 characters, return ERROR.
 *
 * 传入字符串格式的十进制的数字，返回二进制表述
 * 如果数字的小数部分不能用32位二进制准确表示，返回 error
 *
 * @author rays1
 *
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
