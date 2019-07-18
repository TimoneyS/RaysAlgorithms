package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a room with `n` lights which are turned on initially and `4` buttons on the wall. After performing exactly `m` unknown operations towards buttons, you need to return how many different kinds of status of the `n` lights could be.
 *      
 *      Suppose `n` lights are labeled as number `[1, 2, 3 ..., n]`, function of these `4` buttons are given below:
 *      
 *      1. You can flip all the lights.
 *      2. You can flip lights with even numbers.
 *      3. You can flip lights with odd numbers.
 *      4. You can flip lights with `(3k + 1)` numbers, k = 0, 1, 2, ...
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      1
 *      1
 *      Output: 2
 *      Explanation:
 *      Status can be: [on], [off]
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      2
 *      1
 *      Output: 3
 *      Explanation:
 *      Status can be: [on, off], [off, on], [off, off]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/bulb-switcher-ii/description
 * @date   2019-07-11 18:35:42
 */
public class L_0704_Bulb_Switcher_II {


    /**
     * 如果让标号从 0 开始，4中开关则是 全部、奇数、偶数、3的倍数。
     * 
     * 观察一下可以发现，如果有 12盏灯，那么 1-6盏灯和 7-12盏灯的明灭一定是一一对应的。
     * 那么无论经过哪些操作对于 1-6盏灯得到的每种状态，对应 7-12 盏灯中的每盏灯的状态都是确定的，那么可以得出：
     *          dp[7 ~ 12] = dp[6]
     * 因此题目只需要考虑 1 ~ 6 的情况即可
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int flipLights(int n, int m) {
            if (n == 0 || m == 0) return 1;
            if (n == 1) return 2;
            if (n == 2) return m == 1 ? 3 : 4;
            if (m == 1) return 4;
            return m == 2 ? 7 : 8;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
