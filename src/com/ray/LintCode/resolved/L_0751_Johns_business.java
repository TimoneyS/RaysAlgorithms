package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.Deque;

import com.ray.io.Out;

/**
 * 数轴上有 n 个城市，编号从 0 ~ n-1。
 * 约翰打算在这n个城市做点生意，他对Armani的一批货物感兴趣，每个城市对于这批货物都有一个价格prices[i]。
 * 对于城市x,约翰可从城市编号为[x - k, x + k]购买货物，然后卖到城市x,问约翰在每个城市最多能赚到多少钱？
 *
 * Input: prices = [1, 3, 2, 1, 5] and k = 2
 * Output: [0, 2, 1, 0, 4]
 *
 * 输入 prices = [1, 1, 1, 1, 1] and k = 1
 * 输出 [0, 0, 0, 0, 0]
 * 
 * @author rays1
 *
 */
public class L_0751_Johns_business {

    /**
     * L_0362_Sliding_Window_Maximum 滑动窗口寻找最小元素即可
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] business(int[] A, int k) {
            
            int[] rs = new int[A.length];
            if (A == null || A.length < k || k == 0) {
                return rs;
            }
            
            Deque<Integer> queue = new ArrayDeque<Integer>();
            for (int i = 0; i < k; i++)
                inQueue(queue, A[i]);
            
            for (int i = 0; i < A.length; i++) {
                inQueue(queue, i+k < A.length ? A[i+k] : Integer.MAX_VALUE);
                rs[i] = A[i] - queue.peekFirst();
                if (i - k >= 0)
                    outQueue(queue, A[i-k]);
            }
            
            return rs;
        }
        
        public void inQueue(Deque<Integer> deque, int num) {
            while (!deque.isEmpty() && deque.peekLast() > num) deque.pollLast();
            deque.add(num);
        }
        
        public void outQueue(Deque<Integer> deque, int num) {
            if (deque.peekFirst() == num) deque.pollFirst();
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {1, 3, 2, 1, 5};
        int k   = 2;
        
        Out.p(new Solution().business(A, k));
        
    }

}
