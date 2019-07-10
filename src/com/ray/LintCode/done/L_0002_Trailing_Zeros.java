package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *   编写算法计算任意数字的阶乘结果，其尾部有多少个0
 *
 * 用例：
 *  用例1：
 *   	输入：11
 *   	输出：12
 *   	解释：
 *          11! = 39916800
 * 挑战：
 *      时间复杂度 O(log N) 
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/trailing-zeros/description
 * @date   2019-07-10 00:33:53
 */
public class L_0002_Trailing_Zeros {

    /**
     * 尾部的 0 来源是 5 和偶数相乘，而 10， 100 等这样的情况也可以表示成 5 和偶数相乘。
     * 因此问题可以转化为阶乘的数字可以转化出多少个5相乘。
     */
    static class Solution {
    
        public long trailingZeros(long n) {
            long sum = 0;
            while (n != 0) {
                sum += n / 5;
                n /= 5;
            }
            return sum;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution().trailingZeros(20));
        
    }

}
