package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 队列的最大值 LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @since   2020-03-07 10:15:02
 */
public class L100337_队列的最大值 {
    /**
     * 用队列维持插入顺序，用TreeMap维持大小顺序。
     * 当插入一个值时，将其在TreeMap中的计数加一
     * 当去除一个值时，将其在TreeMap中的计数减一
     */
    static class MaxQueue {
        TreeMap<Integer, Integer> order = new TreeMap<>();
        Queue<Integer> queue = new ArrayDeque<>();

        public MaxQueue() {
        }
        public int max_value() {
            if (queue.size() == 0) {
                return -1;
            }
            return order.lastKey();
        }
        public void push_back(int value) {
            queue.offer(value);
            order.put(value, order.getOrDefault(value, 0) + 1);
        }

        public int pop_front() {

            if (queue.size() == 0) {
                return -1;
            }

            int v = queue.poll();
            if (order.get(v) == 1) {
                order.remove(v);
            } else {
                order.put(v, order.get(v) - 1);
            }
            return v;
        }
    }
    public static void main(String[] args) {
        MaxQueue q = new MaxQueue();

        q.push_back(4);
        q.push_back(4);
        q.push_back(4);

        q.pop_front();
        q.pop_front();

        Out.p(q.max_value());

    }
}
