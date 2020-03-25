package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Count of Smaller Numbers After Self
 * -----------------------------------------------------------------------------
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *      Example 1
 *      Input: [5,2,6,1]
 *      Output: [2,1,1,0] 
 *      Explanation:
 *      To the right of 5 there are 2 smaller elements (2 and 1).
 *      To the right of 2 there is only 1 smaller element (1).
 *      To the right of 6 there is 1 smaller element (1).
 *      To the right of 1 there is 0 smaller element.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * @since   2020-03-11 19:32:52
 */
public class L0315_Count_of_Smaller_Numbers_After_Self {
    /**
     * 使用树状数组的解法
     * 先将数字离散化，每个数字就表示一个索引
     * 遍历数组，每次遇到一个数字，就表明该位置的值加一，然后更新数组
     * 每次统计到数字前一位的数组和即可。
     */
    static class Solution {
        public List<Integer> countSmaller(int[] A) {
            List<Integer> rs = new ArrayList<>(A.length);
            if (A.length == 0) return rs;
            for (int i = 0; i < A.length; i++) rs.add(0);
            int max = compress(A);
            int[] inner = new int[max + 1];
            for (int i = A.length-1; i >= 0; i--) {
                rs.set(i, sum(inner, A[i]-1));
                update(inner, A[i]);
            }
            return rs;
        }

        private void update(int[] inner, int i) {
            i ++;
            while (i < inner.length) {
                inner[i] += 1;
                i += i & -i;
            }
        }

        private Integer sum(int[] inner, int i) {
            int sum = 0;
            i++;
            while (i != 0) {
                sum += inner[i];
                i -= i & -i;
            }
            return sum;
        }

        private int compress(int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int n : nums) map.put(n, 0);
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) entry.setValue(i++);
            for (int j = 0; j < nums.length; j++) nums[j] = map.get(nums[j]);
            return map.lastKey() - map.firstKey();
        }
    }
    
    public static void main(String[] args) {
        int[] A = {9,7,7,7,5};
        Out.p(new Solution().countSmaller(A));
    }
}
