package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个字符串包含 0-9 的数字和一个目标值
 * 返回所有可能的位置，在这些位置加上二元操作符（+、-或*）之后，数字运算的结果是目标值。
 * 
 * 例如：
 *      "123",        6     -> ["1+2+3", "1*2*3"] 
 *      "232",        8     -> ["2*3+2", "2+3*2"]
 *      "105",        5     -> ["1*0+5","10-5"]
 *      "00",         0     -> ["0+0", "0-0", "0*0"]
 *      "3456237490", 9191  -> []
 * 
 * @author rays1
 *
 */
public class L_0653_Expression_Add_Operators {

    static class Solution {
    
        public List<String> addOperators(String num, int target) {
            List<String> rs = new ArrayList<>();
            
            helper(num, 0, target, 0, 0, "", rs);
            return rs;
        }
        
        
        void helper(String num, int start, int target, long prev, long base, String exp, List<String> rs) {
            if (num.length() == start && base == target) {
                rs.add(exp);
                return;
            }
            
            long curr = 0;
            for (int i = start; i < num.length(); i++) {
                curr = curr * 10 + num.charAt(i) - '0'; // 当前数字
                if (exp.length() > 0) {
                    // 之前的表达式 + 当前数字
                    helper(num, i+1, target,        curr,               base + curr, exp + "+" + curr, rs);
                    // 之前的表达式 - 当前数字
                    helper(num, i+1, target,       -curr,               base - curr, exp + "-" + curr, rs);
                    // 之前的表达式 * 当前数字
                    helper(num, i+1, target, prev * curr, base - prev + prev * curr, exp + "*" + curr, rs);
                } else {
                    // 之前的表达式直接和当前数字连接
                    helper(num, i+1, target,        curr,                      curr,        curr + "", rs);
                }
                
                if (curr == 0) break;
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        String num = "11101";
        int target = 9;
        
        Out.p(new Solution().addOperators(num, target));
        
    }

}
