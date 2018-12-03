package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;
import com.ray.util.Timer;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 *  where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
 * 
 * <p>
 * numbers=[2, 7, 11, 15], target=9
 * return [0, 1]
 * <p>
 * Challenge : O(n) Space, O(nlogn) Time
 *             O(n) Space, O(n) Time
 * @author rays1
 *
 */
public class L_0056_Two_Sum {

    static class Solution {
        
        /**
         * @param numbers: An array of Integer
         * @param target: target = numbers[index1] + numbers[index2]
         * @return: [index1, index2] (index1 < index2)
         */
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> remain = new HashMap<>();
            
            for (int i = 0; i < numbers.length; i++) {
                int num = numbers[i];
                if (remain.containsKey(num))
                    return new int[]{remain.get(num), i};
                remain.put(target-num, i);
            }
            
            return new int[]{-1, -1};
        }
        
    }
    
    public static void main(String[] args) {
        
        int n = 10;
        int[] numbers = ArrayUtil.intArr(n);
        int target = 2  * n - 1 ;
        
//        int[] numbers = {1,2,3,5};
//        int target = 7;
        
        Out.p(numbers);
        
        Timer.CLICK();
        Out.p(new Solution().twoSum(numbers, target));
        Timer.STOP();
    }

}
