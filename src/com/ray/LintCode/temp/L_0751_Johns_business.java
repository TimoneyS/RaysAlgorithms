package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.Deque;

import com.ray.io.Out;

/**
 * 描述：
 *      There are n cities on an axis, numbers from `0` ~ `n - 1`. John intends to do business in these n cities, He is interested in Armani's shipment. Each city has a price for these goods `prices [i]`. For city `x`, John can buy the goods from the city numbered from  `x - k` to `x + k`, and sell them to city x. We want to know how much John can earn **at most** in **each** city?
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: prices = [1, 3, 2, 1, 5] and k = 2
 *      Output: [0, 2, 1, 0, 4]
 *      Explanation:
 *      i = 0, John can go to the city 0 ~ 2. He can not make money because the prices in city 1 and city 2 are both higher than the price in city 0, that is, ans[0] = 0;
 *      i = 1, John can go to the city 0~3. He can buy from city 0 or city 3 to earn the largest price difference. That is, ans[1] = 2.
 *      i = 2, John can go to the city 0~4. Obviously, he can earn the largest price difference by buying from city 3. That is, ans[2] = 1.
 *      i = 3, John can go to the city 1~4. He can not make money cause city 3 has the lowest price. That is, ans[3] = 0.
 *      i = 4, John can go to the city 2~4. He can earn the largest price difference by buying from city 3. That is, ans[4] = 4.
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: prices = [1, 1, 1, 1, 1] and k = 1
 *      Output: [0, 0, 0, 0, 0]
 *      Explanation:
 *      All cities are the same price, so John can not make money, that is, all ans are 0.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/johns-business/description
 * @date   2019-07-11 18:36:03
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
        
        Out.p(new Solution());
        
    }

}
