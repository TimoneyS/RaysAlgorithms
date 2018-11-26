package com.ray.LintCode;

import java.util.Stack;

/**
 * As the title described, you should only use two stacks to implement a queue's
 * actions.
 * 
 * The queue should support push(element), pop() and top() where pop is pop the
 * first(a.k.a front) element in the queue.
 * 
 * Both pop and top methods should return the value of first element.
 * 
 * <p>
 * <li> push(1)
 * <li> pop()     // return 1
 * <li> push(2)
 * <li> push(3)
 * <li> top()     // return 2
 * <li> pop()     // return 2
 * <p>
 * Challenge : implement it by two stacks,
 *  do not use any other data structure and push,
 *  pop and top should be O(1) by AVERAGE.
 * @author rays1
 *
 */
public class L_0040_Implement_Queue_by_Two_Stacks {
    
    static class MyQueue {
        
        Stack<Integer> s1;
        Stack<Integer> s2;
        
        public MyQueue() {
            // do intialization if necessary
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            // write your code here
            while (!s1.empty()) s2.push(s1.pop());
            s1.push(element);
            while (!s2.empty()) s1.push(s2.pop());
        }

        /*
         * @return: An integer
         */
        public int pop() {
            return s1.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            return s1.peek();
        }
    }
    
}
