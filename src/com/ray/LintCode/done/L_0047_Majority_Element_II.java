package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组，寻找出现次数超过数组大小的1/3的元素。
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: [99,2,99,2,99,3,3], 
 *      Output: 99.
 *      ```
 *      Example 2:
 *      ```
 *      Input: [1, 2, 1, 2, 1, 3, 3], 
 *      Output: 1.
 *      ```
 *
 * 挑战：
 *      O(_n_) time and O(_1_) extra space.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/majority-element-ii/description
 * @date   2019-07-11 18:00:31
 */
public class L_0047_Majority_Element_II {

    /**
     * 逻辑和 L_0046_Majority_Element 类似
     * 
     * 因为这里超过数组的三分之一，因此可以设计算法一次拿取三个数字
     * 如果三个数字彼此不同则全部丢弃。
     * 
     * 如果有两个数字相同，则再取一个数字
     * 如果三个数字都相同，则再取两个数字
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int majorityNumber(List<Integer> nums) {
            
            int num1 = 0, num2 = 0;
            int ct1 = 0, ct2 = 0;
            
            for (Integer i : nums) {
                if (ct1 == 0) {
                    num1 = i;
                }
                if (ct2 == 0) {
                    num2 = i;
                }
                if (i == num1) {
                    ct1 ++;
                } else if (i == num2) {
                    ct2 ++;
                } else {
                    ct1 --;
                    ct2 --;
                }
            }

            ct1 = ct2 = 0;
            for (Integer i : nums) {
                if (i == num1) {
                    ct1 ++;
                }
                if (i == num2) {
                    ct2 ++;
                }
            }
            
            return ct1 > ct2 ? num1 : num2;
        }
    }
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {1,2,1,2,1,3,3});
        
        Out.p(new Solution().majorityNumber(nums));
    }

}
