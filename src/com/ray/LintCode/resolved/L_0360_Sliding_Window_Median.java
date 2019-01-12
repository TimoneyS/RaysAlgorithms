package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * n个元素的整数数组，一个宽度k的移动的窗口。窗口从数组起点开始，寻找每次窗口的中位数。
 * 如果数组窗口时偶数个，则返回第N/2小的数字。
 * 
 * [1,2,7,8,5]， k = 3 => [2,7,7]
 * 
 * [ | 1,2,7 | ,8,5]  => 2
 * [1, | 2,7,8 | ,5]  => 7
 * [1,2, | 7,8,5 | ]  => 7
 * @author rays1
 *
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
