package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a **non negative** integer number num. For every numbers i in the range `0 ≤ i ≤ num` calculate the number of 1's in their binary representation and return them as an array.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 5
 *      Output: [0,1,1,2,1,2]
 *      Explanation:
 *      The binary representation of 0~5 is:
 *      000
 *      001
 *      010
 *      011
 *      100
 *      101
 *      the count of "1" in each number is: 0,1,1,2,1,2
 *      ```
 *      **Example2**
 *      ```
 *      Input: 3
 *      Output: [0,1,1,2]
 *      ```
 *
 * 挑战：
 *      1. It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 *      2. Space complexity should be O(n).
 *      3. Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/counting-bits/description
 * @date   2019-07-11 18:35:15
 */
public class L_0664_Counting_Bits {

    /**
     * 这种题目属于技巧性的题目，如果对于数字表达本身没有深刻的理解，很难想到完美的解决方案
     * 这里的巧妙之处在于
     *      任何一个数字均可以表示称 2*n 或者 2*n + 1 的模式
     *      
     *      若 
     *          num = 2 * n 
     *      则 
     *          count(num) = count(n)
     *      
     *      若
     *          num = 2 * n + 1
     *      则
     *          count(num) = count(n) + 1
     *          
     *      因此
     *          count(num) = count(num/2) + num % 2
     *          
     * 还有一种解答的方案是，这个答案过于巧妙，基本上无法独立想到。
     *          count(num) = count(num & (num-1)) + 1
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] countBits(int num) {
            int[] rs = new int[num+1];
            for (int i = 1; i <= num; i++) {
                rs[i] = rs[i/2] + i%2;
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
