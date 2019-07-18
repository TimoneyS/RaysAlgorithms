package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      A **Digit Divide Numbers** is a number that is divisible by every digit it contains.
 *      
 *      For example, 128 is a **Digit Divide Numbers** because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *      
 *      Also, **Digit Divide Numbers** is not allowed to contain the digit zero.
 *      
 *      Given a lower and upper number bound, output a list of every possible **Digit Divide Numbers**, including the bounds if possible.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: left = 1, right = 22
 *      Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: left = 7, right = 22
 *      Output: [7, 8, 9, 11, 12, 15, 22]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/self-dividing-numbers/description
 * @date   2019-07-11 18:35:58
 */
public class L_0742_Self_Dividing_Numbers {

    /**
     * 暴力算法，需要注意 整数溢出
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> digitDivideNums(int lower, int upper) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = lower; i <= upper && i != Integer.MIN_VALUE; i++)
                if (isDiv(i)) arr.add(i);
            return arr;
        }
        
        private boolean isDiv(int n) {
           if (n == 0) return false;
           int t =  n;
           
           while (true) {
                if (n == 0) return true;
                if (n % 10 == 0 || t % (n%10) != 0) return false;
                n = n / 10;
           }
           
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
