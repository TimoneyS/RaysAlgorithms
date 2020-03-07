package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列 LCOF
 * -----------------------------------------------------------------------------
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @since   2020-03-07 12:38:30
 */
public class L100324_和为s的连续正数序列 {
    static class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < target; i++) {
                int l = i + 1;
                int r = target - 1;
                while (l <= r) {
                    int m = (l+r) / 2;
                    int c = sum(m) - sum(i);
                    if (c == target) {
                        int[] arr = new int[m-i];
                        for (int j = i; j < m; j ++) {
                            arr[j-i] = j+1;
                        }
                        list.add(arr);
                        break;
                    } else if (c < target) {
                        l = m+1;
                    } else {
                        r = m-1;
                    }
                }
            }
            return list.toArray(new int[0][0]);
        }

        int sum(int n) {
            return (n % 2 == 0) ? (n / 2) * (n + 1) : (n + 1) / 2 * n;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
