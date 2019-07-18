package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the median of the element inside the window at each moving. (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      [1,2,7,8,5]
 *      3
 *      Output:
 *      [2,7,7]
 *      
 *      Explanation:
 *      At first the window is at the start of the array like this `[ | 1,2,7 | ,8,5]` , return the median `2`;
 *      then the window move one step forward.`[1, | 2,7,8 | ,5]`, return the median `7`;
 *      then the window move one step forward again.`[1,2, | 7,8,5 | ]`, return the median `7`;
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      [1,2,3,4,5,6,7]
 *      4
 *      Output:
 *      [2,3,4,5]
 *      
 *      Explanation:
 *      At first the window is at the start of the array like this `[ | 1,2,3,4, | 5,6,7]` , return the median `2`;
 *      then the window move one step forward.`[1,| 2,3,4,5 | 6,7]`, return the median `3`;
 *      then the window move one step forward again.`[1,2, | 3,4,5,6 | 7 ]`, return the median `4`;
 *      then the window move one step forward again.`[1,2,3,| 4,5,6,7 ]`, return the median `5`;
 *      ```
 *
 * 挑战：
 *      O(nlog(n)) time
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sliding-window-median/description
 * @date   2019-07-11 18:32:07
 */
public class L_0360_Sliding_Window_Median {

    /**
     * 遍历过程中，维护两个优先级队列，小的队列数字大的优先级高，大的队列数字小的优先级高
     * 保持两个优先级队列的数量平衡即可
     * @author rays1
     *
     */
    static class Solution {
        
        public List<Integer> medianSlidingWindow(int[] nums, int k) {
            List<Integer> rs = new ArrayList<Integer>();
            if (nums == null || nums.length < k || k == 0) return rs;
            
            // 左侧队列保存小的数字，数字越大权重越大
            // 右侧队列保存大的数字，数字越小权重越大
            PriorityQueue<Integer> lPQ = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            PriorityQueue<Integer> rPQ = new PriorityQueue<>();
            
            // 初始情况，先将第一个窗口的所有数组添加到队列中去
            for (int i = 0; i < k; i ++) {
                rPQ.add(nums[i]);
                if (rPQ.size() > k/2) { // 右侧队列满了，将最小的数字溢出到左侧队列去
                    lPQ.add(rPQ.poll());
                }
            }

            rs.add(lPQ.peek());
            
            for (int i = k; i < nums.length; i++) {
                
                // 左侧或右侧删除旧元素 左侧优先
                if (!lPQ.remove(nums[i-k])) rPQ.remove(nums[i-k]);
                
                // 新的元素可能需要加入左侧或右侧
                if (lPQ.size()!=0 && nums[i] <= lPQ.peek()) lPQ.add(nums[i]);
                else                       rPQ.add(nums[i]);
                
                // 两侧队列的元素个数固定的，因此只要判断一侧的元素多于预期还是少于预期
                int num = rPQ.size() - k/2;
                if (num > 0) {
                    // 多于预期则移动多出的部分到另一侧
                    move(rPQ, lPQ, num);
                } else {
                    // 少于则从另一侧移动少的部分过来
                    move(lPQ, rPQ, -num);
                }
                rs.add(lPQ.peek());
            }
            
            return rs;
        }
        
        public void move(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2, int num) {
            for (int i = 0; i < num; i ++)
                pq2.add(pq1.poll());
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,2,7,7,2};
        int k = 1;
        Out.p(new Solution().medianSlidingWindow(nums, k));
        
    }

}
