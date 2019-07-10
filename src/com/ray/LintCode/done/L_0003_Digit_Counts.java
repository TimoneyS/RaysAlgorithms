package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      统计 0 ~ n 之间，数字k出现的次数。k在 0~9 之间
 *
 * 用例：
 *      
 *      **用例 1:**
 *      输入：k = 1, n = 12
 *      输出：5
 *      解释：
 *          在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 可以找到 (1, 10, 11, 12)，因此 1 一共出现 5 次
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/digit-counts/description

 * @date   2019-07-10 10:23:51
 */
public class L_0003_Digit_Counts {

    /**
     * 暴力思路， 统计每个数字中的出现次数
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int digitCounts(int k, int n) {
            int sum = 0;
            for (int i = 0; i <= n;  i ++)
                sum += count(i, k);
            return sum;
        }
        
        public int count(int n, int k) {
            if (k == 0 && k == n) return 1;
            int sum = 0;
            while (n != 0) {
                if (n%10 == k) sum ++;
                n /= 10;
            }
            return sum;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
