package com.ray.LintCode.done;

import com.ray.io.Out;
import com.ray.util.Assert;

/**
 * 描述：
 *      Implement queue by circulant array. You need to support the following methods:
 *          1. `CircularQueue(n):`  initialize a circular array with size n to store elements
 *          2. `boolean isFull():`  return `true` if the array is full
 *          3. `boolean isEmpty():`  return `true` if there is no element in the array 
 *          4. `void enqueue(element):`  add an element to the queue
 *          5. `int dequeue():`  pop an element from the queue
 *
 *      用循环数组来实现队列。你需要支持下列方法：
 *          CircularQueue(n): 初始化一个大小为n的循环数组来存储元素
 *          boolean isFull(): 如果数组满了就返回 true
 *          boolean isEmpty(): 如果数组为空则返回 true
 *          void enqueue(element): 往队列中添加一个元素
 *          int dequeue(): 从队列中弹出一个元素
 *
 * 用例：
 *      用例 1:
 *      输入:
 *      CircularQueue(5)
 *      isFull()
 *      isEmpty()
 *      enqueue(1)
 *      enqueue(2)
 *      dequeue()
 *      输出:
 *      ["false","true","1"]
 *      
 *      用例 2:
 *      输入:
 *      CircularQueue(5)
 *      isFull()
 *      isEmpty()
 *      enqueue(1)
 *      enqueue(2)
 *      dequeue()
 *      dequeue()
 *      enqueue(1)
 *      enqueue(2)
 *      enqueue(3)
 *      enqueue(4)
 *      enqueue(5)
 *      isFull()
 *      dequeue()
 *      dequeue()
 *      dequeue()
 *      dequeue()
 *      dequeue()
 *      输出:
 *      ["false","true","1","2","true","1","2","3","4","5"]
 *      
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/implement-queue-by-circular-array/description
 * @date   2019-07-22 14:38:53
 */
public class L_0955_Implement_Queue_by_Circular_Array {

    /**
     * 使用head tail指针保存队列首尾
     * 使用 标记 保存队列是否满
     * 添加时，队列可能满，添加后如果 head == tail 则队列一定满
     * 删除时，队列一定不满
     * 
     * @author rays1
     *
     */
    static class CircularQueue {
        
        private int[] inner;
        private int head;
        private int tail;
        private boolean isFull;
        
        public CircularQueue(int n) {
            inner = new int[n];
            head = 0;
            tail = 0;
            isFull = false;
        }
        
        public boolean isFull() {
            return isFull && head == tail;
        }

        public boolean isEmpty() {
            return !isFull && head == tail;
        }

        public void enqueue(int element) {
            if (isFull) return;
            inner[tail++] = element;
            tail %= inner.length;
            if(head == tail) {
                isFull = true;
            }
        }

        public int dequeue() {
            int rs = -1;
            if (!isEmpty()) {
                rs = inner[head++];
                head %= inner.length;
                isFull = false;
            }
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        CircularQueue q = new CircularQueue(3);
        
        Assert.assertEquals(q.isEmpty(), true);
        Assert.assertEquals(q.isFull(), false);
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.enqueue(4);
        
        Out.p(q.inner);
        
        Assert.assertEquals(q.isEmpty(), false);
        Assert.assertEquals(q.isFull(), true);
        
        
        
        
    }

}
