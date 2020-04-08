package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * 包含min函数的栈 LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @since   2020-04-08 22:03:22
 */
public class L100302_包含min函数的栈_LCOF {
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

        public int top() {
            return inner[cursor-1];
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
    }
}
