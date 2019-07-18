package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组，寻找数组的主元素。主元素指大小超过一半元素的元素。
 *
 * 用例：
 *      用例 1:
 *          输入: [1, 1, 1, 1, 2, 2, 2]
 *          输出: 1
 *      
 *      用例 2:
 *          输入: [1, 1, 1, 2, 2, 2, 2]
 *          输出: 2
 *
 * 挑战：
 *      O(n) 时间复杂度 和 O(1) 空间复杂度
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/majority-element/description
 * @date   2019-07-11 18:00:16
 */
public class L_0046_Majority_Element {

    /**
     * 如果一个数字出现的次数超过数组大小的一半，那么连续出现的数字中一定有该数字。
     * 否则该数字一定和其他数字交替出现。
     * 
     * 设计算法每次读取两个数字，如果这两个数字彼此不同，就将这两个数字都丢弃。
     * 这样当两两不同的数字都丢弃之后，剩下的数字一定是出现次数超过数组一半的那个数字。
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int majorityNumber(List<Integer> nums) {
            int num = 0;
            int ct = 0;
            for (Integer i : nums) {
                if (ct == 0) {
                    num = i;
                }
                if (i.equals(num)) {
                    ct ++;
                } else {
                    ct --;
                }
            }
            return num;
        }
        
    }
    
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 1, 2, 1, 3, 1, 3, 4, 4, 1, 1};
        List<Integer> nums = Arrays.asList(arr);
        
        Out.p(new Solution().majorityNumber(nums));
    }

}
