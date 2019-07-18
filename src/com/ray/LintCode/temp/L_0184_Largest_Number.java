package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:[1, 20, 23, 4, 8]
 *      Output:"8423201"
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:[4, 6, 65]
 *      Output:"6654"
 *      ```
 *
 * 挑战：
 *      Do it in O(nlogn) time complexity.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/largest-number/description
 * @date   2019-07-11 18:31:42
 */
public class L_0184_Largest_Number {

    /**
     * 将数组按照特殊方式排序，如 8 和 23 比较时,因为位数不同。因此将 8 变成 88 再排序
     * 排序后拍最大的数字将再新数字的最前
     * @author rays1
     *
     */
    static class Solution {
        
        class Pair {
            long k;
            int v;
            public Pair(long k, int v) {
                super();
                this.k = k;
                this.v = v;
            }
        }
        
        public String largestNumber(int[] nums) {
            int max = 0;
            for (int i : nums) max = Math.max(max, (int) Math.log10(i));
            List<Pair> list = new ArrayList<>(nums.length);
            for (int i : nums) {
                long k = i;
                if (k != 0) {
                    int l = (int) Math.log10(i);
                    for (int j = l; j < max; j++) {
                        k = k * 10 + i;
                    }
                }
                list.add(new Pair(k, i));
            }

            
            list.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return Long.compare(o2.k, o1.k);
                }
            });

            
            StringBuilder sb = new StringBuilder();
            for (Pair pair : list) {
                if (sb.length() == 0 && pair.v != 0 || sb.length() != 0)
                    sb.append(pair.v);
            }
            if (sb.length() == 0)
                sb.append("0");
            
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        
        int[] nums = {0};
        
        Out.p(new Solution().largestNumber(nums));
        
    }

}
