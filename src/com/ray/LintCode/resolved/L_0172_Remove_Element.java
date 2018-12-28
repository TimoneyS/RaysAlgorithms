package com.ray.LintCode.resolved;

/**
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * The order of elements can be changed, and the elements after the new length don't matter.
 * 
 *  Given an array [0,4,4,0,0,2,4,4], value=4
 *  return 4 and front four elements of the array is [0,0,0,2]
 * 
 * @author rays1
 *
 */
public class L_0172_Remove_Element {

    static class Solution {
        public int removeElement(int[] A, int elem) {
            int n = A.length;
            
            int i = 0;
            for (int num : A) {
                if (num != elem) {
                    A[i++] = num;
                } else {
                    n --;
                }
            }
            return n;
        }
    }

}
