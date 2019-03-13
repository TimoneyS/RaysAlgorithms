package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 
 * 给一个字符串类型的数字，写一个方法去找到最大值，你可以在任意两个数字间加  + 或 *
 * 
 * @author rays1
 *
 */
public class L_0719_Calculate_Maximum_Value {

    static class Solution {
    
        public int calcMaxValue(String str) {
            int rs = 0;
            for (int i = 0; i < str.length(); i++) {
                int n = str.charAt(i) - '0';
                rs = Math.max(rs * n, rs + n);
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        String str = "818";
        
        Out.p(new Solution().calcMaxValue(str));
        
    }

}
