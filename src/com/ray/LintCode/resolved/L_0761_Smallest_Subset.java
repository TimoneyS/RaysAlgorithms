package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 给一 非负 整数数组. 取数组中的一部分元素, 使得它们的和大于数组中其余元素的和, 求出满足条件的元素数量最小值.
 *
 * @author rays1
 *
 */
public class L_0761_Smallest_Subset {

    static class Solution {
    
        public int minElements(int[] arr) {
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            int c = arr.length-1, t = 0;
            while (c >= 0 && t * 2 <= sum) {
                t += arr[c--];
            }
            
            return arr.length-c-1;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] arr = {2, 1, 2};
        Out.p(new Solution().minElements(arr));
        
    }

}
