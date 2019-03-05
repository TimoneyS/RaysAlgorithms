package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个非负的整数 num，返回 0 到 num 之间的每个数字  i 的二进制表达式中的 1 的个数，并以数组形式返回。
 *
 * 示例
 *      输入 5
 *      输出 [0,1,1,2,1,2]
 *      
 * 挑战
 *      1. 线性的时间复杂读 O(n)
 *      2. 空间复杂读 O(n)
 *      3. 不始用内建方法
 *
 * @author rays1
 *
 */
public class L_0664_Counting_Bits {

    /**
     * 这种题目属于技巧性的题目，如果对于数字表达本身没有深刻的理解，很难想到完美的解决方案
     * 这里的巧妙之处在于
     *      任何一个数字均可以表示称 2*n 或者 2*n + 1 的模式
     *      
     *      若 
     *          num = 2 * n 
     *      则 
     *          count(num) = count(n)
     *      
     *      若
     *          num = 2 * n + 1
     *      则
     *          count(num) = count(n) + 1
     *          
     *      因此
     *          count(num) = count(num/2) + num % 2
     *          
     * 还有一种解答的方案是，这个答案过于巧妙，基本上无法独立想到。
     *          count(num) = count(num & (num-1)) + 1
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] countBits(int num) {
            int[] rs = new int[num+1];
            for (int i = 1; i <= num; i++) {
                rs[i] = rs[i/2] + i%2;
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int num = 10;
        Out.p(new Solution().countBits(num));
        
    }

}
