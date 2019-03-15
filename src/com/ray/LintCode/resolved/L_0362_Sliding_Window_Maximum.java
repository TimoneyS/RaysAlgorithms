package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * n个整数的数组，可能右重复数字。尺寸为k的移动窗口。窗口从数组左侧移动到右侧，返回每次移动时窗口的最大数字。
 *
 * @author rays1
 *
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
