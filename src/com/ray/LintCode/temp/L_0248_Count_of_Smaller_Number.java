package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. For each query, give you an integer, return the number of element in the array that are smaller than the given integer.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: array =[1,2,7,8,5] queries =[1,8,5]
 *      Output:[0,4,2]
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: array =[3,4,5,8] queries =[2,4]
 *      Output:[0,1]
 *      ```
 *
 * 挑战：
 *      Could you use three ways to do it.
 *      
 *      1. Just loop
 *      2. Sort and binary search
 *      3. Build Segment Tree and Search.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/count-of-smaller-number/description
 * @date   2019-07-11 18:32:06
 */
public class L_0248_Count_of_Smaller_Number {

    /*
     * 三种方法： 1. 循环 2. 排序，二分搜索 3. 段树
     */
    static class Solution {
        
        public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
            
            ArrayList<Integer> rs = new ArrayList<>();
            Arrays.sort(A);
            
            for (int q : queries) rs.add(rank(A, q));
            
            return rs;
        }
        
        public int rank(int[] A, int num) {
            int l = 0,r = A.length-1;
            while (l<r) {
                int m = (l+r)/2;
                // target 其实表示 位于 target-1 和 target 之间的数字
                if (A[m] < num)
                    l = m+1;
                else
                    r = m-1;
            }
            return (l>r) ? l : (A[r] >= num) ? r : r+1;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {39,49,13,22,25,57,92,92,94,56,54,70,9,52,63,75,55,33,79,13,52,35,11,17,99,65,86,22,31,53,91,51,18,71,70,23,73,50,35,51,38,13,80,81,54,58,40,1,80,70,1,53,63,74,48,18,52,80,6,42};
        int[] queries = {52};
        
        Out.p(new Solution().countOfSmallerNumber(A, queries));
        
    }
}
