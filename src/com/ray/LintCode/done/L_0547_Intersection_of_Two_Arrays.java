package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two arrays, write a function to compute their intersection.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2], 
 *      Output: [2].
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: nums1 = [1, 2], nums2 = [2], 
 *      Output: [2].
 *      ```
 *
 * 挑战：
 *      Can you implement it in *three* different algorithms?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/intersection-of-two-arrays/description
 * @date   2019-07-11 18:33:54
 */
public class L_0547_Intersection_of_Two_Arrays {

    static class Solution {
        /**
         * @param nums1 an integer array
         * @param nums2 an integer array
         * @return an integer array
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int index1 = 0, index2 = 0;
            
            Set<Integer> rs = new HashSet<Integer>();
            
            while ( index1 < nums1.length && index2 < nums2.length) {
                if(nums1[index1] == nums2[index2]) {
                   rs.add(nums1[index1]);
                    index1++;
                    index2++;
                } else if (nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
                
            }
            int[] result = new int[rs.size()];
            Iterator<Integer> i = rs.iterator();
            int index = 0;
            while(i.hasNext()) {
                result[index++] = i.next();
            }
            return result;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
