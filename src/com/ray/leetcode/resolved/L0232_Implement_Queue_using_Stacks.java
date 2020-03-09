package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * -----------------------------------------------------------------------------
 * Implement the following operations of a queue using stacks.
 * 	push(x) -- Push element x to the back of queue.
 * 	pop() -- Removes the element from in front of queue.
 * 	peek() -- Get the front element.
 * 	empty() -- Return whether the queue is empty.
 *
 * Example:
 *      Example 1
 *      MyQueue queue = new MyQueue();
 *      queue.push(1);
 *      queue.push(2);  
 *      queue.peek();  // returns 1
 *      queue.pop();   // returns 1
 *      queue.empty(); // returns false
 *      Notes:
 *      	You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 *      	Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 *      	You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @since   2020-03-09 21:36:07
 */
public class L0232_Implement_Queue_using_Stacks {
    /**
     * 队列的特点是先进先出，栈则是后进先出。
     * 如果用索引表示元素的出序，那么队列和栈的出序是完全相反的
     *
     * 队列
     *      a b c  ->  a(1) b(2) c(3)
     * 栈
     *      a b c  ->  a(3) b(2) c(1)
     *
     * 如果用另一个栈保存原始栈中的所有元素，那么：
     *      c b a  ->  c(3) b(2) a(1)
     *
     * 因此用两个栈模拟队列，具体如下：
     *      1. 用 s1 保存所有元素
     *      2. 弹出和查看顶部都用 s1 的 对应方法
     *      3. 添加元素时，先将 s1 中的所有元素“倒入”到 s2 中，将新元素压入 s1 然后将元素从 s2 倒回
     */
    static class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int element) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            s1.push(element);
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
        }

        public int pop() {
            return s1.pop();
        }

        public int peek() {
            return s1.peek();
        }

        public boolean empty() {
            return s1.empty();
        }
    }
    
    public static void main(String[] args) {
    }
}
