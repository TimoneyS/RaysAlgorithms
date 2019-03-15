package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个半径 r，返回圆的周长 nums[0] 和面积 nums[1]
 * 结果保留两位小数
 *
 * @author rays1
 * @url
 * 
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
        
        int r = 3;
        Out.p(new Solution().calculate(r));
        
    }

}
