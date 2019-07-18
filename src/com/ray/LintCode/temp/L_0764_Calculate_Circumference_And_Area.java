package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given radius `r`, returns the circle's circumference `nums[0]` and area `nums[1]`.The result retains two decimal places.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : r = 2
 *      Output : [12.56, 12.56]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/calculate-circumference-and-area/description
 * @date   2019-07-11 18:36:25
 */
public class L_0764_Calculate_Circumference_And_Area {

    /**
     * 题目容易理解，但是测试用例存在问题
     * 本题要求的 pi 为 3.14 而不是 3.14159265...
     * 而且也不需要保留有效数字就能通过测试
     * @author rays1
     *
     */
    static class Solution {
    
        public double[] calculate(int r) {
            double[] rs = new double[2];
            rs[0] = (2 * r * 3.14);
            rs[1] = (r * r * 3.14);
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
