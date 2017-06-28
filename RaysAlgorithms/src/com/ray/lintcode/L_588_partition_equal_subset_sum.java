package com.ray.lintcode;

import static com.ray.utils.TestUnit.*;

import com.ray.utils.StdOut;

/**
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that
 * the sum of elements in both subsets is equal.<br/>
 * ---------------------------------------------------<br/>
 * 问题可以转化为从一个数组里找到和是数组总和一半的子数组。
 * @author rays1
 *
 */
public class L_588_partition_equal_subset_sum {
	
	static Solution Solution = new Solution();
	
	static class Solution {
	    /**
	     * @param nums a non-empty array only positive integers
	     * @return return true if can partition or false
	     */
	    public boolean canPartition(int[] nums) {
	    	StdOut.p(nums.length);
	    	int sum = 0;
	    	int[] trace =  new int[nums.length];
	    	for (int i : nums) sum += i;
	    	if (sum%2!=0) return false;
	    	
	    	while (true) {
	    		tracePlus(trace);
	    		int rs = sum(nums, trace);
	    		
	    		if (rs == sum/2) return true;
	    		else if (rs >= sum) break;
	    	}
	    	
			return false;
	    }
	    
	    public int sum(int[] nums, int[] trace) {
	    	int sum = 0;
	    	for (int i = 0; i < nums.length; i++) {
	    		if (trace[i] == 1) sum += nums[i]; 
	    	}
	    	return sum;
	    }
	    
	    public void tracePlus(int[] trace) {
	    	for (int i = 0; i < trace.length; i++) {
	    		if (trace[i] == 0) { trace[i] = 1; break;}
	    		else if (trace[i] == 1) { trace[i] = 0;}
	    	}
	    }
	    
	}
	
	public static void test(int[] nums, boolean result) {
		if(result) 	assertTrue( Solution.canPartition(nums));
		else 		assertFalse(Solution.canPartition(nums));
	}
	
	public static void main(String[] args) {
		test(new int[]{1, 5, 11, 5},  true); // two subsets: [1, 5, 5], [11]
		test(new int[]{1, 2,  3, 9}, false);
		
		test(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100}, false);
	}
}
