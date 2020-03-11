package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    class Solution1 {
        public List<Integer> countSmaller(int[] A) {
            for (int i = 0; i < A.length/2; i++) {
                int t = A[i];
                A[i] = A[A.length-1-i];
                A[A.length-1-i] = t;
            }
            List<Integer> rs = new ArrayList<>();
            for (int i = 0; i < A.length; i++) {
                int r = rank(A, 0, i-1, A[i]);
                rs.add(r);
                if (r == i) continue;
                int tmp = A[i];
                for (int j = i; j > r; j--) {
                    A[j] = A[j-1];
                }
                A[r] = tmp;
            }
            return rs;
        }

        public int rank(int[] A, int l, int r, int num) {
            while (l<r) {
                int m = (l+r)/2;
                // target 其实表示 位于 target-1 和 target 之间的数字
                if (A[m] < num) l = m + 1;
                else            r = m - 1;
            }
            return (l>r) ? l : (A[r] >= num) ? r : r+1;
        }
    }

    static class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> rs = new ArrayList<>();
            for (int i = nums.length-1; i >= 0; i --) {
                if (i == nums.length-1) {
                    rs.add(0);
                    continue;
                }
                int r = rank(nums, i+1, nums.length - 1, nums[i]);
                rs.add(0, nums.length - r - 1);
                if (i == r) continue;
                int t = nums[i];
                for (int j = i; j < r && j < nums.length-1; j++) {
                    nums[j] = nums[j+1];
                }
                if (r < nums.length) nums[r] = t;
                Out.p(nums);
            }
            return rs;
        }

        int rank(int[] A, int l, int r, int target) {
            while (l <= r) {
                int m = (l + r) / 2 + (l+r)%2;
                if (target >= A[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }
    }
    
    public static void main(String[] args) {
        int[] A = {9,7,7,7,5};

        Out.p(new Solution().rank(A, 0, A.length-1, 4));
        Out.p(new Solution().rank(A, 0, A.length-1, 5));
        Out.p(new Solution().rank(A, 0, A.length-1, 6));
        Out.p(new Solution().rank(A, 0, A.length-1, 7));
        Out.p(new Solution().rank(A, 0, A.length-1, 8));

    }
}
