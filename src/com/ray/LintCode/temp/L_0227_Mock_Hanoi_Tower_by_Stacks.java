package com.ray.LintCode.temp;

import java.util.Stack;

/**
 * 描述：
 *      In the classic problem of Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
 *      
 *      1. Only one disk can be moved at a time.
 *      2. A disk is slid off the top of one tower onto the next tower.
 *      3. A disk can only be placed on the top of a larger disk.
 *      
 *      Write a program to move the disks from the first tower to the last using stacks.
 *
 * 用例：
 *      **Example1:**
 *      ```plain
 *      Input: 3
 *      Output: 
 *      towers[0]: []
 *      towers[1]: []
 *      towers[2]: [2,1,0]
 *      ```
 *      
 *      **Example2:**
 *      ```plain
 *      Input: 10
 *      Output:
 *      towers[0]: []
 *      towers[1]: []
 *      towers[2]: [9,8,7,6,5,4,3,2,1,0]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/mock-hanoi-tower-by-stacks/description
 * @date   2019-07-11 18:32:02
 */
public class L_0227_Mock_Hanoi_Tower_by_Stacks {


    class Tower {
        private Stack<Integer> disks;
        /*
        * @param i: An integer from 0 to 2
        */
        public Tower(int i) {
            disks = new Stack<>();
            for (int j = i; j > 0; j--) {
                add(j);
            }
        }

        /*
         * @param d: An integer
         * @return: nothing
         */
        public void add(int d) {
            // Add a disk into this tower
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        /*
         * @param t: a tower
         * @return: nothing
         */
        public void moveTopTo(Tower t) {
            t.add(disks.pop());
        }

        /*
         * @param n: An integer
         * @param destination: a tower
         * @param buffer: a tower
         * @return: nothing
         */
        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n==1)
                moveTopTo(destination);
            else {
                moveDisks(n-1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n-1, destination, this);
            }
        }

        /*
         * @return: Disks
         */
        public Stack<Integer> getDisks() {
            return disks;
        }
    }
}
