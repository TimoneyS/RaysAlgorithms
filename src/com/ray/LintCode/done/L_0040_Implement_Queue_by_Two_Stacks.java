package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.util.Assert;

/**
 * 描述：
 *      用两个栈实现队列操作。
 *      队列支持 ： push, pop, top
 *
 * 用例：
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
     *      
     * @author rays1
     *
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

        public int top() {
            return s1.peek();
        }
    }
    
    public static void main(String[] args) {
        
        MyQueue queue = new MyQueue();
        
        queue.push(1);
        Assert.assertEquals(queue.pop(), 1);
        
        queue.push(2);
        queue.push(3);
        
        Assert.assertEquals(queue.top(), 2);
        Assert.assertEquals(queue.pop(), 2);
        
    }

}
