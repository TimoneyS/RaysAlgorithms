package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个整数数组, 用当前元素之后数组中的最大元素来替换当前元素(右侧的最大元素). 
 * 如果最后一个元素的右边没有元素, 则用 -1 来替换这个值.
 * 
 * 如果数组为 [16,17,4,3,5,2], 那么它就需要修改为 [17,5,5,5,2,-1].
 *
 * @author rays1
 *
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
        int[] nums = {16, 9, 12, 7, 6, 2};
        new Solution().arrayReplaceWithGreatestFromRight(nums);
        Out.p(nums);
    }

}
