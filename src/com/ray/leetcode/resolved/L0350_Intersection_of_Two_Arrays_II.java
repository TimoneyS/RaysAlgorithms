package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Intersection of Two Arrays II
 * -----------------------------------------------------------------------------
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 *      Example 1
 *      Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *      Output: [2,2]
 *      Example 2
 *      Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *      Output: [4,9]
 *      Note:
 *      	Each element in the result should appear as many times as it shows in both arrays.
 *      	The result can be in any order.
 *      Follow up:
 *      	What if the given array is already sorted? How would you optimize your algorithm?
 *      	What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *      	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @since   2020-03-12 22:52:55
 */
public class L0350_Intersection_of_Two_Arrays_II {
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int index1 = 0, index2 = 0;

            List<Integer> rs = new LinkedList<Integer>();

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
