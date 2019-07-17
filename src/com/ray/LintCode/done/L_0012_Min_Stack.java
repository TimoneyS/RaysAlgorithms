package com.ray.LintCode.done;

import com.ray.util.Assert;

/**
 * 描述：
 *      实现一个栈，具有以下功能：
 *          push(val) 将值压入栈
 *          pop()     移除栈顶元素
 *          min()     返回当前栈中最小元素
 *          
 *      以上所有操作的复杂度为 O(1)
 *        
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/min-stack/description
 * @date   2019-07-10 21:46:49
 */
public class L_0012_Min_Stack {

    /**
     * 用一个数组保存栈元素：
     *      cursor      表示栈指针
     *      head        最小元素指针
     *      next        数组，保存恰好大于该元素的下一个元素索引
     *      prev        数组，保存恰好小于该元素的下一个元素索引
     * 
     * 数组顺序表示元素的插入顺序
     * 链表记录值大小关系的顺序
     * 
     * 方法实现
     * min
     *      inner[head]
     * 
     * pop
     *      删除栈顶元素，将栈指针回退即可
     *      next prev 链表中删除栈指针对应的索引 
     *      
     * push
     *      栈指针前进     
     *      在链表中检索合适的位置插入指针。
     * 
     * @author rays1
     *
     */
    static class MinStack {
    
        private int[] inner;
        private int[] next;
        private int[] prev;
        private int cursor;
        private int head;
        
        public MinStack() {
            inner = new int[16];
            next = new int[16];
            prev = new int[16];
            head = -1;
            for (int i = 0; i < next.length; i++) {
                next[i] = -1;
                prev[i] = -1;
            }
        }

        public void push(int number) {
            if (cursor == inner.length) {
                expandInnerArray();
            }
            inner[cursor++] = number;
            
            int index = cursor - 1;
            
            if (head == -1) {
                head = 0;
            } else {
               
                int l = -1,r = -1;
                
                if (number > inner[head]) {
                    // 在最小值右侧插入
                    l = head;
                    for (int i = head; i < cursor && i >= 0; i = next[i]) {
                        if (number < inner[i]) break;
                        l = i;
                    }
                    r = next[l];
                } else {
                    // 在最小值左侧插入
                    r = head;
                    l = prev[r];
                    head = index;
                }
                
                if (l != -1) next[l] = index;
                if (r != -1) prev[r] = index;
                next[index] = r;
                prev[index] = l;
                
            }
            
        }
        
       public int pop() {
            
            int index = --cursor;
            int r = next[index];
            int l = prev[index];

            if (index == head)
                head = r;

            if (l != -1)
                next[l] = r;
            if (r != -1)
                prev[r] = l;

            next[index] = -1;
            prev[index] = -1;

            return inner[index];
        }

        /*
         * @return: An integer
         */
        public int min() {
            return inner[head];
        }

        private void expandInnerArray() {
            // expand
            int[] temp1 = new int[cursor * 2];
            int[] temp2 = new int[cursor * 2];
            int[] temp3 = new int[cursor * 2];
            
            // init
            for (int i = cursor; i < temp1.length; i++) {
                temp2[i] = -1;
                temp3[i] = -1;
            }
            
            // copy
            for (int i = 0; i < cursor; i++) {
                temp1[i] = inner[i];
                temp2[i] = prev[i];
                temp3[i] = next[i];
            }
            
            inner = temp1;
            prev = temp2;
            next = temp3;
        }
    
    }
    
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(-100);
        stack.push(-101);
        stack.push(-99);
        Assert.assertEquals(stack.min(), -101);
        stack.push(100);
        Assert.assertEquals(stack.min(), -101);
        stack.push(50);
        Assert.assertEquals(stack.min(), -101);
        
        Assert.assertEquals(stack.pop(), 50);
        Assert.assertEquals(stack.pop(), 100);
        Assert.assertEquals(stack.pop(), -99);
        Assert.assertEquals(stack.pop(), -101);
        Assert.assertEquals(stack.pop(), -100);
        
        stack.push(0);
        Assert.assertEquals(stack.min(), 0);
        
    }

}
