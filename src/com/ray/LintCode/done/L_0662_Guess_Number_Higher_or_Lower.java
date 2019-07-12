package com.ray.LintCode.done;

/**
 * 描述：
 *      We are playing the Guess Game. The game is as follows:
 *      
 *      I pick a number from **1** to **n**. You have to guess which number I picked.
 *      
 *      Every time you guess wrong, I will tell you if this number is greater or less than the number you guessed.
 *      
 *      You call a pre-defined API `guess(int num)` which returns 3 possible results (-1, 1, or 0):
 *      -1 means this number is less than the number you guessed
 *      
 *      1 means this number is greater than the number you guessed
 *      
 *      0 means this number is equal to the number you guessed
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : n = 10, I pick 4 (but you don't know)
 *      Output : 4
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/guess-number-higher-or-lower/description
 * @date   2019-07-11 18:35:13
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
            if (n == 2147483647 && guess(n) == 0) return n;
            else n--;
            int l = 1, r = n;
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
        
        
    }

}
