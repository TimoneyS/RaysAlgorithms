package com.ray.LintCode.resolved;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 幸福数字
 * 
 * 用算法判断数字是否幸福，幸福数字的标准如下：
 *      开始的数字为任意的正数，将该数字转换为其进制位上的每一位的数字的平方和。
 *      重复此操作，直到数字转换为 1，或者这个过程陷入无穷的循环并不能转换为1。
 * 
 * 那些能转换为 1 的数字是幸福数字；
 *
 * @author rays1
 *
 */
public class L_0488_Happy_Number {

    static class Solution {
    
        public boolean isHappy(int n) {
            Set<Integer> cache = new HashSet<>();
            while (n != 1) {
                n = trans(n);
                if (cache.contains(n)) return false;
                cache.add(n);
            }
            return true;
        }

        private int trans(int n) {
            int num = 0;
            while (n > 0) {
                num += Math.pow((n%10), 2);
                n /= 10;
            }
            return num;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 5;
        
        Out.p(new Solution().isHappy(n));
        
    }

}
