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
     * ��һ�����鱣��ջԪ�أ�cursor��ʾջָ��
     * ͬʱ����
     *  minIndex ��СԪ��ָ��
     *  righOf   ���飬������ڸ�Ԫ�ص���һ��Ԫ������
     *  leftOf   ���飬����С�ڸ�Ԫ�ص���һ��Ԫ������
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
            if (cursor >= inner.length) expandInnerArray();
            inner[cursor++] = number;
            
            int numIndex = cursor - 1;
            
            if (minIndex == -1) {
                // �²���
                minIndex = 0;
            } else {
               
                if (number > inner[minIndex]) {
                    // ����Сֵ�Ҳ����
                    int l = -1;
                    for (int i = minIndex; i < cursor && i >= 0; i = righOf[i]) {
                        if (number < inner[i]) break;
                        l = i;
                    }
                    int r = righOf[l];
                    
                    righOf[l] = numIndex;
                    if (r != -1) leftOf[r] = numIndex;
                    
                    righOf[numIndex] = r;
                    leftOf[numIndex] = l;                    
                } else {
                    // ����Сֵ������
                    righOf[numIndex] = minIndex;
                    leftOf[minIndex] = numIndex;
                    minIndex = numIndex;
                }
            }
            
        }

        private void expandInnerArray() {
            int[] temp = new int[inner.length * 2];
            int[] ltemp = new int[inner.length * 2];
            int[] rtemp = new int[inner.length * 2];
            
            // init
            for (int i = cursor; i < temp.length; i++) {
                ltemp[i] = -1;
                rtemp[i] = -1;
            }
            
            // expand
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
            
            int numIndex = -- cursor;
            int r = righOf[numIndex];
            
            if (numIndex == minIndex) {
                // ��������Сֵ
                if (r != -1) {
                    // ��Сֵ�������һ��Ԫ��
                    leftOf[r] = -1;
                }
                minIndex = r;
            } else {
                // �����˷���Сֵ
                int l = leftOf[numIndex];
                righOf[l] = r;
                if (r != -1)
                    leftOf[r] = l;
            }
            
            righOf[numIndex] = -1;
            leftOf[numIndex] = -1;
            
            return inner[numIndex];
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

        stack.push(1);
        stack.pop();
        stack.show();
        stack.push(2);
        stack.show();
        stack.push(3);
        stack.min();
        stack.push(1);
        stack.min();
        
        
        
//        stack.push(-100);
//        stack.push(-101);
//        stack.push(-99);
//        Out.p(stack.min());
//        stack.push(100);
//        Out.p(stack.min());
//        stack.push(50);
//        Out.p(stack.min());
//        Out.p(stack.pop());
//        Out.p(stack.pop());
//        Out.p(stack.pop());
//        Out.p(stack.pop());
//        Out.p(stack.pop());
//        stack.push(0);
//        Out.p(stack.min());
        
    }
    
}
