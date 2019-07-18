package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组 A
 *      定义
 *          B[i] = A[0] * A[2] * ... A[i-1] * A[i+1] * ... * A[n-1]
 *      不使用除法计算 B[i]
 *
 * 用例：
 *      **用例 1**
 *      输入: A = [1, 2, 3]
 *      输出: [6, 3, 2]
 *      解释: 
 *          B[0] = A[1] * A[2] = 6
 *          B[1] = A[0] * A[2] = 3
 *          B[2] = A[0] * A[1] = 2
 *      
 *      **用例 2**
 *      输入: A = [2, 4, 6]
 *      Output: [24, 12, 8]
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/product-of-array-exclude-itself/description
 * @date   2019-07-11 18:01:12
 */
public class L_0050_Product_of_Array_Exclude_Itself {

    /**
     * 从左侧计算从 0 到 i   的乘积 SL[i]
     * 从右侧计算从 i 到 n-1 的乘积 SR[i]
     * 
     * B[i] = SL[i-1] * SR[i+1]
     * 
     * @author rays1
     *
     */
    static class Solution {
        public List<Long> productExcludeItself(List<Integer> nums) {
            if (nums.size() == 1) return Arrays.asList(new Long[] {1l});
            
            int N = nums.size();
            Long[] SL = new Long[N];
            Long[] SR = new Long[N];
            
            SL[0]    = Long.valueOf(nums.get(0));
            SR[N-1] = Long.valueOf(nums.get(N-1));
            for (int i = 1; i < N; i++) {
                SL[i] = SL[i-1] * nums.get(i);
                SR[N-1-i] = SR[N-i] * nums.get(N-1-i);
            }
            
            Long[] B = new Long[N];
            
            B[0] = SR[1];
            B[N-1] = SL[N-2];
            for (int i = 1; i < N-1; i++) {
                B[i] = SL[i-1] * SR[i+1];
            }
            
            return Arrays.asList(B);
        }
    }
    
    public static void main(String[] args) {
        
        Integer[] arr = {1, 2, 3};
        List<Integer> nums = Arrays.asList(arr);
        
        List<Long> B = new Solution().productExcludeItself(nums);
        
        Out.p(B);
        
    }

}
