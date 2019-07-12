package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. Since there is no element next to the last element, replace it with -1. For example, if the array is `[16, 17, 4, 3, 5, 2]`, then it should be modified to `[17, 5, 5, 5, 2, -1]`.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: nums = [16, 17, 4, 3, 5, 2]
 *      Output: [17, 5, 5, 5, 2, -1]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: nums = [16, 9, 12, 7, 6, 2]
 *      Output: [12, 12, 7, 6, 2, -1]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/replace-with-greatest-from-right/description
 * @date   2019-07-11 18:35:55
 */
public class L_0735_Replace_With_Greatest_From_Right {

    static class Solution {
    
        public void arrayReplaceWithGreatestFromRight(int[] nums) {
            int max = nums[nums.length-1], t = 0;
            
            nums[nums.length-1] = -1;
            for (int i = nums.length-2; i >= 0; i --) {
                t = nums[i];
                nums[i] = max;
                max = Math.max(max, t);
            }
        }
    
    }
    
    class Solution1 {
        public void arrayReplaceWithGreatestFromRight (int[] nums) {
            int size = nums.length;
            int greatestFromRight = nums[size - 1];
            nums[size - 1] = -1;
            for (int i = size - 2; i >= 0; i--) {
                int temp = nums[i];
                nums[i] = greatestFromRight;
                if (greatestFromRight < temp) {
                    greatestFromRight = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
