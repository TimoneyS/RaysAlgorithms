package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 一个整除数指一个整数可以被其每一位的数字整除。
 * 如 128 ，因为 128 % 1 == 0, 128 % 2 == 0 和 128 % 8 == 0，所以 128 是一个整除数。
 * 
 * 并且, 数字整除数不允许包含数字 0.
 * 给出上下限, 输出一个包含所有数字整除数的列表, 包括边界.
 *
 * @author rays1
 *
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
        
        int lower = 2147483647;
        int upper = 2147483647;
        
        Out.p(new Solution().digitDivideNums(lower, upper));
        
    }

}
