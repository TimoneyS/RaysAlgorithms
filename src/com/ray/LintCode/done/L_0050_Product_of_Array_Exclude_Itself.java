package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integers array A.
 *      
 *      Define `B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]`, calculate B **WITHOUT** divide operation.Out put B
 *
 * 用例：
 *      **Example 1**
 *      ```
 *      Input: A = [1, 2, 3]
 *      Output: [6, 3, 2]
 *      Explanation：B[0] = A[1] * A[2] = 6; B[1] = A[0] * A[2] = 3; B[2] = A[0] * A[1] = 2
 *      ```
 *      **Example 2**
 *      ```
 *      Input: A = [2, 4, 6]
 *      Output: [24, 12, 8]
 *      ```
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

    static class Solution {
        /*
         * @param nums: Given an integers array A
         * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
         */
        public List<Long> productExcludeItself(List<Integer> nums) {
            if (nums.size() == 1) return Arrays.asList(new Long[] {1l});
            
            
            int N = nums.size();
            Long[] left = new Long[N];
            Long[] right = new Long[N];
            
            left[0] = Long.valueOf(nums.get(0));
            for (int i = 1; i < N; i++) {
                left[i] = left[i-1] * nums.get(i);
            }
            
            right[N-1] = Long.valueOf(nums.get(N-1));
            for (int i = N-2; i >= 0; i--) {
                right[i] = right[i+1] * nums.get(i);
            }
            
            Long[] B = new Long[N];
            
            B[0] = right[1];
            B[N-1] = left[N-2];
            for (int i = 1; i < N-1; i++) {
                B[i] = left[i-1] * right[i+1];
            }
            
            return Arrays.asList(B);
        }
    }
    
    public static void main(String[] args) {
        
        Integer[] arr = {0};
        List<Integer> nums = Arrays.asList(arr);
        
        List<Long> B = new Solution().productExcludeItself(nums);
        
        Out.p(B);
        
    }

}
