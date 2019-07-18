package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个包含 n 个整数的数组 S，寻找三个数字 a b c 使得其和最接近一个给定的值 target 
 *      返回这三个数字的和
 *
 * 用例：
 *      Example 1:
 *      Input:[2,7,11,15],3
 *      Output:20
 *      Explanation:
 *      2+7+11=20
 *      
 *      Example 2:
 *      Input:[-1,2,1,-4],1
 *      Output:2
 *      Explanation:
 *      -1+2+1=2
 *
 * 挑战：
 *      O(n^2) time, O(1) extra space
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/3sum-closest/description
 * @date   2019-07-11 18:17:19
 */
public class L_0059_3Sum_Closest {

    /**
     * 暴力算法 O(n^3),列举所有三位数字
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int threeSumClosest(int[] numbers, int target) {
            
            int rs = numbers[0] + numbers[1] + numbers[2];
            
            for (int i = 0; i < numbers.length-2; i++) {
                for (int j = i+1; j < numbers.length-1; j++) {
                    for (int k = j+1; k < numbers.length; k++) {
                        int t = numbers[i]+numbers[j] + numbers[k];
                        if (Math.abs(rs-target) > Math.abs(numbers[i]+numbers[j] + numbers[k]-target)) {
                            rs = t;
                        }
                    }
                }
            }
            
            return rs;
        }
        
    }
    
    /**
     * 首先对数组排序，对于数字 S[i]，要在其右侧寻找数字 S[j], S[k] 使得 S[i] + S[j] + S[k] 最接近 target
     * 可以转化为：
     *      寻找 S[j] S[k] 使其和最接近 target - S[i]
     *      
     * 可以在 i 右侧从两侧开始 设定 j = i + 1， k = n - 1     
     *      如果 S[j] + S[k] > target - S[i]，说明值较大，可以尝试在 k 更小的地方寻找，则 k -- 
     *      如果 S[j] + S[k] < target - S[i]，说明值较小，可以尝试在 j 更大的地方寻找，则 j ++
     * 
     * @author rays1
     *
     */
    static class Solution1 {
        
        public int threeSumClosest(int[] numbers, int target) {
            if (numbers == null || numbers.length < 3) {
                return -1;
            }
            
            Arrays.sort (numbers);
            int rs = numbers[0] + numbers[1] + numbers[2];
            for (int i = 0; i < numbers.length; i++) {
                int l = i + 1, r = numbers.length - 1;
                while (l < r) {
                    int t = numbers[i] + numbers[l] + numbers[r];
                    if (Math.abs(target - t) < Math.abs(target - rs)) {
                        rs = t;
                    }
                    if (t < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {-1, 2, 1, -4};
        int target = 1;
        
        Out.p(new Solution().threeSumClosest(numbers, target));
        Out.p(new Solution1().threeSumClosest(numbers, target));
    }

}
