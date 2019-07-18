package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [1,2,7,7,8]
 *      3
 *      输出:
 *      [7,7,8]
 *      
 *      Explanation：
 *      At first the window is at the start of the array like this `[|1, 2, 7| ,7, 8]` , return the maximum `7`;
 *      then the window move one step forward.`[1, |2, 7 ,7|, 8]`, return the maximum `7`;
 *      then the window move one step forward again.`[1, 2, |7, 7, 8|]`, return the maximum `8`;
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      [1,2,3,1,2,3]
 *      5
 *      Output:
 *      [3,3]
 *      
 *      Explanation:
 *      At first, the state of the window is as follows: ` [,2,3,1,2,1 | , 3] `, a maximum of ` 3 `;
 *      And then the window to the right one. ` [1, | 2,3,1,2,3 |] `, a maximum of ` 3 `;
 *      ```
 *
 * 挑战：
 *      o(n) time and O(k) memory
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sliding-window-maximum/description
 * @date   2019-07-11 18:32:08
 */
public class L_0362_Sliding_Window_Maximum {
    
    /**
     * 队列中只保存大于当前元素的元素
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public void inQueue(Deque<Integer> deque, int num) {
            while (!deque.isEmpty() && deque.peekLast() < num) deque.pollLast();
            deque.add(num);
        }
        
        public void outQueue(Deque<Integer> deque, int num) {
            if (deque.peekFirst() == num) deque.pollFirst();
        }
        
        public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
            ArrayList<Integer> rs = new ArrayList<Integer>();
            if (nums == null || nums.length < k || k == 0) {
                return rs;
            }
            
            Deque<Integer> deque = new ArrayDeque<Integer>();
            for (int i = 0; i < k - 1; i++) {
                inQueue(deque, nums[i]);
            }
            
            for(int i = k - 1; i < nums.length; i++) {
                inQueue(deque, nums[i]);
                
                Out.p(deque);
                rs.add(deque.peekFirst());
                outQueue(deque, nums[i - k + 1]);
            }
            return rs;

        }
    }
    
    public static void main(String[] args) {
        
//        int[] nums = ArrayUtil.intArr(100000);
//        ArrayUtil.shuffle(nums);
        
        int[] nums = {1,2,3,4,5};
        int k = 3;
        Timer.CLICK();
        List<Integer> rs = new Solution().maxSlidingWindow(nums, k);
        Timer.STOP();
        Out.p(rs);
    }

}
