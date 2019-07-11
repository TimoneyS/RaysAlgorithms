package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      As the title described, you should only use two stacks to implement a queue's actions.
 *      
 *      The queue should support `push(element)`, `pop()` and `top()` where pop is pop the first(a.k.a front) element in the queue.
 *      
 *      Both pop and top methods should return the value of first element.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *          push(1)
 *          pop()    
 *          push(2)
 *          push(3)
 *          top()    
 *          pop()     
 *      Output:
 *          1
 *          2
 *          2
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *          push(1)
 *          push(2)
 *          push(2)
 *          push(3)
 *          push(4)
 *          push(5)
 *          push(6)
 *          push(7)
 *          push(1)
 *      Output:
 *      []
 *      ```
 *
 * 挑战：
 *      implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by *AVERAGE*.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/implement-queue-by-two-stacks/description
 * @date   2019-07-11 17:51:38
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
    
    public static void main(String[] args) {
        
        Out.p(new MyQueue());
        
    }

}
