package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Find K-th largest element in an array.
 * 
 * @author rays1
 *
 */
public class L_0005_Kth_Largest_Element {
    
    static class Solution {
        /**
         * @param n: An integer
         * @param nums: An array
         * @return: the Kth largest element
         */
        public int kthLargestElement(int n, int[] nums) {
            return quickSelect(nums, nums.length-n, 0, nums.length-1);
        }
        
        public int quickSelect(int[] nums, int n, int s, int t) {
            
            int l = s + 1;
            int r = t;
            while (true) {
                while (r > s && nums[s] < nums[r]) r --;
                while (l < t && nums[l] < nums[s]) l ++;
                if (r > l) swap(nums, r, l);
                else break;
            }
            swap(nums, r, s);
            
            if (r == n)
                return nums[r];
            else if (r > n)
                return quickSelect(nums, n, s, r-1);
            else 
                return quickSelect(nums, n, r+1, t);
        }
        
        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        
    }
    
    public static void main(String[] args) {
        
//        Scanner sc = In.getClassPathScanner(L_0005_Kth_Largest_Element.class, "L_0005_Kth_Largest_Element.in");
//        
//        List<Integer> list = new ArrayList<Integer>();
//        sc.useDelimiter("[\\[,\\]\r\n]");
//        
//        int n = sc.nextInt();
//        Out.p(sc.next());
//        while (sc.hasNextInt()) {
//            list.add(sc.nextInt());
//        }
//        
//        int[] nums = new int[list.size()];
//        int i = 0;
//        for (int num : list) {
//            nums[i++] = num;
//        }

        
        int[] nums = {4,5,1,3,7,6,9};
        int n = 2;
        
        Out.p(new Solution().kthLargestElement(n, nums));
        
    }
    
}
