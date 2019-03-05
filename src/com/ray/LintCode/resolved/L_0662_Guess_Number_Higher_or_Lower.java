package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 一个猜数字的游戏，如下：
 *      A 选择一个 1 到 n 之间的数字，B 要猜出 A 选择的具体数字。
 *      每次猜错，A会告诉 B 这个数字大于还是小于猜测值。
 * 使用 guess(int num) 表示猜测方法
 *      -1 stands for low
 *      1 stands for high
 *      0 stands for right
 *
 * @author rays1
 *
 */
public class L_0662_Guess_Number_Higher_or_Lower {

    static class GuessGame {
        int inner = 10;
        int  guess(int num){
            return Integer.compare(inner, num);
        }
    }
    
    static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l = 1, r = n;
            
            if (n == 2147483647 && guess(n) == 0) return n;
            else n--;
            
            while (true) {
                int m = (l+r)/2;
                
                switch(guess(m)) {
                    case  1 : l = m + 1;break;
                    case -1 : r = m - 1;break;
                    default : return m;
                }
                
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
 