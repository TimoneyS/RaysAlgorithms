package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implement Stack using Queues
 *
 * Implement the following operations of a stack using queues.
 * 	push(x) -- Push element x onto stack.
 * 	pop() -- Removes the element on top of the stack.
 * 	top() -- Get the top element.
 * 	empty() -- Return whether the stack is empty.
 *
 * Example:
 *      Example 1
 *      MyStack stack = new MyStack();
 *      stack.push(1);
 *      stack.push(2);  
 *      stack.top();   // returns 2
 *      stack.pop();   // returns 2
 *      stack.empty(); // returns false
 *      Notes:
 *      	You must use only standard operations of a queue --
 *      	which means only push to back, peek/pop from front, size, and is empty operations are valid.
 *      	Depending on your language, queue may not be supported natively.
 *      	You may simulate a queue by using a list or deque (double-ended queue),
 *      	as long as you use only standard operations of a queue.
 *      	You may assume that all operations are valid
 *      	(for example, no pop or top operations will be called on an empty stack).
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @since   2020-03-01 20:58:27
 */
public class L0225_Implement_Stack_using_Queues {
    static class MyStack {
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> temp = new ArrayDeque<>();
        public MyStack() {
        }

        public void push(int x) {
            while (!queue.isEmpty()) {
                temp.offer(queue.poll());
            }
            queue.offer(x);
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    
    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Out.p(stack.pop());
        Out.p(stack.pop());
        Out.p(stack.pop());
        Out.p(stack.pop());

    }
}
