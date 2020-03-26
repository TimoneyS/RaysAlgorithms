package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Design Circular Deque
 * -----------------------------------------------------------------------------
 * Design your implementation of the circular double-ended queue (deque).
 * Your implementation should support following operations:
 * 	MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * 	insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 * 	insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 * 	deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * 	deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 * 	getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 * 	getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 * 	isEmpty(): Checks whether Deque is empty or not. 
 * 	isFull(): Checks whether Deque is full or not.
 *
 * Example:
 *      Example 1
 *      MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 *      circularDeque.insertLast(1);			// return true
 *      circularDeque.insertLast(2);			// return true
 *      circularDeque.insertFront(3);			// return true
 *      circularDeque.insertFront(4);			// return false, the queue is full
 *      circularDeque.getRear();  			// return 2
 *      circularDeque.isFull();				// return true
 *      circularDeque.deleteLast();			// return true
 *      circularDeque.insertFront(4);			// return true
 *      circularDeque.getFront();			// return 4
 *      Note:
 *      	All values will be in the range of [0, 1000].
 *      	The number of operations will be in the range of [1, 1000].
 *      	Please do not use the built-in Deque library.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/design-circular-deque/
 * @since   2020-03-27 00:14:02
 */
public class L0859_Design_Circular_Deque {
    /**
     * 循环数组的解法
     */
    class MyCircularDeque {
        private int[] inner;
        private int head, tail, size, limit;

        // 构造函数,双端队列的大小为k。
        public MyCircularDeque(int k) {
            inner = new int[k];
            head = tail = -1;
            size = 0;
            limit = k;
        }

        // 将一个元素添加到双端队列头部。 如果操作成功返回 true。
        public boolean insertFront(int value) {
            if (isFull()) return false;
            // 越界，循环
            if (head + 1 >= limit) head = -1;
            inner[++head] = value;
            size ++;
            // 第一次添加
            if (tail < 0) tail = head;
            return true;
        }

        // 将一个元素添加到双端队列尾部。如果操作成功返回 true。
        public boolean insertLast(int value) {
            if (isFull()) return false;
            if (tail - 1 < 0) tail = limit;
            inner[--tail] = value;
            size ++;
            // 第一次添加
            if (head < 0) head = tail;
            return true;
        }

        // 从双端队列头部删除一个元素。 如果操作成功返回 true。
        public boolean deleteFront() {
            if (isEmpty()) return false;
            if (head - 1 < 0) head = limit;
            head --;
            size --;
            return true;
        }

        // 从双端队列尾部删除一个元素。如果操作成功返回 true。
        public boolean deleteLast() {
            if (size == 0) return false;
            if (tail + 1 >= limit) tail = -1;
            tail ++;
            size --;
            return true;
        }

        // 从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
        public int getFront() {
            if (isEmpty()) return -1;
            return inner[head];
        }

        // 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
        public int getRear() {
            if (isEmpty()) return -1;
            return inner[tail];
        }

        // 检查双端队列是否为空。
        public boolean isEmpty() {
            return size == 0;
        }

        // 检查双端队列是否满了。
        public boolean isFull() {
            return size == limit;
        }

    }
    
    public static void main(String[] args) {
    }
}
