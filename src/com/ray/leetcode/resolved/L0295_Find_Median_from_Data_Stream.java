package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Find Median from Data Stream
 * -----------------------------------------------------------------------------
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * For example,
 * [2,3,4], the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * 	void addNum(int num) - Add a integer number from the data stream to the data structure.
 * 	double findMedian() - Return the median of all elements so far.
 *
 * Example:
 *      Example 1
 *      addNum(1)
 *      addNum(2)
 *      findMedian() -> 1.5
 *      addNum(3) 
 *      findMedian() -> 2
 *      Follow up:
 *      	If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 *      	If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-median-from-data-stream/
 * @since   2020-03-11 00:12:39
 */
public class L0295_Find_Median_from_Data_Stream {
    /**
     * 用两个优先级队列
     */
    static class MedianFinder {

        Queue<Integer> ql;
        Queue<Integer> qr;

        /** initialize your data structure here. */
        public MedianFinder() {
            ql = new PriorityQueue<>((i, j) -> Integer.compare(j, i));
            qr = new PriorityQueue<>(Integer::compareTo);
        }

        public void addNum(int num) {
            if (ql.size() == qr.size()) {
                if (ql.size() != 0) {
                    if (num < ql.peek()) {
                        ql.offer(num);
                        num = ql.poll();
                    }
                }
                qr.offer(num);
            } else {
                if (num > qr.peek()) {
                    qr.offer(num);
                    num = qr.poll();
                }
                ql.offer(num);
            }
        }

        public double findMedian() {
            if (ql.size() == qr.size()) {
                return (ql.peek() + qr.peek()) * 1.0 / 2;
            }
            return qr.peek();
        }
    }
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    
    public static void main(String[] args) {
    }
}
