package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.Stack;

/**
 * Create Maximum Number
 * -----------------------------------------------------------------------------
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 * Note: You should try to optimize your time and space complexity.
 *
 * Example:
 *      Example 1
 *      Input:
 *      nums1 = [3, 4, 6, 5]
 *      nums2 = [9, 1, 2, 5, 8, 3]
 *      k = 5
 *      Output:
 *      [9, 8, 6, 5, 3]
 *      Example 2
 *      Input:
 *      nums1 = [6, 7]
 *      nums2 = [6, 0, 4]
 *      k = 5
 *      Output:
 *      [6, 7, 6, 0, 4]
 *      Example 3
 *      Input:
 *      nums1 = [3, 9]
 *      nums2 = [8, 9]
 *      k = 3
 *      Output:
 *      [9, 8, 9]
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/create-maximum-number/
 * @since   2020-03-12 22:47:10
 */
public class L0321_Create_Maximum_Number {
    /**
     * 基本思路就是先从 数组一中找到 i 个最大数字，数组而中找到 k - i 个最大数字
     * 然后拼接在一起，就是一个可能的最优解。循环如此查找即可
     *
     */
    static class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length;
            int n = nums2.length;
            int[] ans = new int[k];

            for(int i=Math.max(0,k-n);i<=Math.min(k,m);i++){
                int[] seq1 = maxSubSequence(nums1,i);    //子序列1
                int[] seq2 = maxSubSequence(nums2,k-i);  //子序列2
                int[] temp = merge(seq1,seq2);           //归并
                if(compare(temp,ans)){                   //比较逻辑大小
                    for(int j=0;j<k;j++){
                        ans[j] = temp[j];
                    }
                }
            }
            return ans;
        }

        //求数组中k个顺序不变的最大子序列
        private int[] maxSubSequence(int[] nums, int k){
            int l = nums.length;
            if(l<=k) return nums;

            //代表最多可以丢弃几个数
            int drop = l-k;

            int[] ans = new int[k];
            if(k==0) return ans;
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<l;i++){
                while(!stack.empty() && nums[i]>stack.peek() && drop-->0){
                    stack.pop();
                }
                stack.push(nums[i]);

            }
            //裁剪大小
            while(stack.size()>k) stack.pop();

            for(int i=k-1;i>=0;i--){
                ans[i] = stack.pop();
            }
            return ans;
        }

        //归并数组
        //这里遇到了好多坑，一开始是想着按照归并排序那种方式归并的，结果发现在遇到连续几位数字相同的情况下时会出现问题
        private int[] merge(int[] nums1, int[] nums2){
            int l1 = nums1.length;
            int l2 = nums2.length;
            if(l1==0) return nums2;
            if(l2==0) return nums1;
            int ans[] = new int[l1+l2];
            int i1 = 0;
            int i2 = 0;
            for(int i=0;i<l1+l2;i++){
                if(compare(Arrays.copyOfRange(nums1, i1, l1),Arrays.copyOfRange(nums2, i2, l2))){
                    ans[i] = nums1[i1++];
                }
                else{
                    ans[i] = nums2[i2++];
                }
            }
            return ans;
        }

        //比较数组的逻辑大小，如果数组长短不一样并且前n个数字完全一样，则认为长度大的那个数组大
        //返回值：若nums1>nums2，返回true
        private boolean compare(int[] nums1, int[] nums2){
            int n = Math.min(nums1.length,nums2.length);
            for(int i=0;i<n;i++){
                if(nums1[i]>nums2[i]) return true;
                else if(nums1[i]<nums2[i]) return false;
                else continue;
            }
            return nums1.length>nums2.length;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
