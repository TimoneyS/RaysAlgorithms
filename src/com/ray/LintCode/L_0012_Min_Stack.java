package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Implement a stack with min() function, which will return the smallest number in the stack.
 * It should support push, pop and min operation all in O(1) cost.
 * <p>
 * Example
 * <p>
 * push(1)              <br>
 * pop()   // return 1  <br>
 * push(2)              <br>
 * push(3)              <br>
 * min()   // return 2  <br>
 * push(1)              <br>
 * min()   // return 1  <br>
 * 
 * @author rays1
 *
 */
public class L_0012_Min_Stack {
    
    /**
     * 用一个数组保存栈元素，cursor表示栈指针
     * 同时增加
     *  minIndex 最小元素指针
     *  righOf   数组，保存大于该元素的下一个元素索引
     *  leftOf   数组，保存小于该元素的下一个元素索引
     * @author rays1
     *
     */
    static class MinStack {
        
        private int[] inner;
        private int[] righOf;
        private int[] leftOf;
        private int cursor;
        private int minIndex;
        
        public MinStack() {
            // do intialization if necessary
            inner = new int[16];
            righOf = new int[16];
            leftOf = new int[16];
            minIndex = -1;
            for (int i = 0; i < righOf.length; i++) {
                righOf[i] = -1;
                leftOf[i] = -1;
            }
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int number) {
            // write your code here
            
            if (cursor >= inner.length)
                expandInnerArray();
            inner[cursor++] = number;
            
            int index = cursor - 1;
            
            if (minIndex == -1) {
                minIndex = 0;
            } else {
               
                int l = -1,r = -1;
                
                if (number > inner[minIndex]) {
                    // 在最小值右侧插入
                    l = minIndex;
                    for (int i = minIndex; i < cursor && i >= 0; i = righOf[i]) {
                        if (number < inner[i]) break;
                        l = i;
                    }
                    r = righOf[l];
                } else {
                    // 在最小值左侧插入
                    r = minIndex;
                    l = leftOf[r];
                    minIndex = index;
                }
                
                if (l != -1) righOf[l] = index;
                if (r != -1) leftOf[r] = index;
                righOf[index] = r;
                leftOf[index] = l;
                
            }
            
        }

        private void expandInnerArray() {
            
            // expand
            int[] temp = new int[inner.length * 2];
            int[] ltemp = new int[inner.length * 2];
            int[] rtemp = new int[inner.length * 2];
            
            // init
            for (int i = cursor; i < temp.length; i++) {
                ltemp[i] = -1;
                rtemp[i] = -1;
            }
            
            // copy
            for (int i = 0; i < cursor; i ++) {
                temp[i] = inner[i];
                ltemp[i] = leftOf[i];
                rtemp[i] = righOf[i];
            }
            inner = temp;
            leftOf = ltemp;
            righOf = rtemp;

        }

        /*
         * @return: An integer
         */
        public int pop() {
            
            int index = -- cursor;
            int r = righOf[index];
            int l = leftOf[index];
            
            if (index == minIndex) minIndex = r;
            
            if (l != -1) righOf[l] = r;
            if (r != -1) leftOf[r] = l;
            
            righOf[index] = -1;
            leftOf[index] = -1;
            
            return inner[index];
        }

        /*
         * @return: An integer
         */
        public int min() {
            return inner[minIndex];
        }
        
        public void show() {
            Out.sep();
            Out.pt("cursor : ");
            Out.p(cursor);
            Out.pt("inner : ");
            Out.p(inner);
            Out.pt("righOf : ");
            Out.p(righOf);
            Out.pt("leftOf : ");
            Out.p(leftOf);
            Out.pt("minIndex : ");
            Out.p(minIndex);
            Out.sep();
        }
        
    }
    
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(-100);
        stack.push(-101);
        stack.push(-99);
        Out.p(stack.min());
        stack.push(100);
        Out.p(stack.min());
        stack.push(50);
        Out.p(stack.min());
        Out.p(stack.pop());
        Out.p(stack.pop());
        Out.p(stack.pop());
        Out.p(stack.pop());
        Out.p(stack.pop());
        stack.push(0);
        Out.p(stack.min());
//        -101
//        -101
//        -101
//        50
//        100
//        -99
//        -101
//        -100
//        0
        
    }
    
}
