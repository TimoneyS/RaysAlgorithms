package com.ray.LintCode.temp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two arrays, write a function to compute their intersection.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: 
 *      nums1 = [1, 2, 2, 1], nums2 = [2, 2]
 *      Output: 
 *      [2, 2]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: 
 *      nums1 = [1, 1, 2], nums2 = [1]
 *      Output: 
 *      [1]
 *      ```
 *
 * 挑战：
 *      - What if the given array is already sorted? How would you optimize your algorithm?
 *      - What if nums1's size is small compared to num2's size? Which algorithm is better?
 *      - What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/intersection-of-two-arrays-ii/description
 * @date   2019-07-11 18:33:55
 */
public class L_0548_Intersection_of_Two_Arrays_II {

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
