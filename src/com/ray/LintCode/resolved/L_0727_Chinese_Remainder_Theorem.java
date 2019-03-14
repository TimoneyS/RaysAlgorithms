package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 给定两个数组 num 和 rem。在数组num中, 所有的元素都是互质的( gcd 为 1 ). 我们需要找到满足下列条件的最小正数 x:
 *
 *   x % num[0]    =  rem[0], 
 *   x % num[1]    =  rem[1], 
 *      ...
 *   x % num[k-1]  =  rem[k-1] 
 *
 * @author rays1
 *
 */
public class L_0727_Chinese_Remainder_Theorem {

    /**
     * 中国剩余定理
     * 
     * 解为一个集合。
     * 设数字为 m, 余数数组为 a
     * 
     *      M = ∑ mi
     *      Mi = M % mi
     *      
     *      ti 是这样的一个数字
     *      (ti * Mi) % mi = 1 
     * 
     * 那么结果为
     *      ∑ ai * Mi * ti
     * 
     * 实际上结果是一个集合，可以表示为
     *      rs = x + y * M 的形式，因此最小的值为 x = 任意rs % M 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int remainderTheorem(int[] m, int[] a) {
            long M = 1;
            for (int n : m) M *= n;
            long rs = 0;
            for (int i = 0; i < m.length; i++) {
                long Mi = M / m[i];
                long ti = comp(Mi, m[i]);
                rs += a[i] * Mi * ti;
            }
            
            return (int) (rs % M);
        }

        private long comp(long Mi, long mi) {
            int ti = 1;
            while (true) {
                if (ti * Mi % mi == 1) return ti;
                ti ++;
            }
        }
    
    }
    
    public static void main(String[] args) {
        int[] num = {23,11,29,37,31,19,17};
        int[] rem = {12,7,8,34,13,12,3};
        
        Out.p(new Solution().remainderTheorem(num, rem));
        
    }

}
