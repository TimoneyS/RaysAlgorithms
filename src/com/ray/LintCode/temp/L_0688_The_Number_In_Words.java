package com.ray.LintCode.temp;

import java.util.ArrayList;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a non-negative integer `n`, print the number in words.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 10245
 *      Output: "ten thousand two hundred forty five"
 *      ```
 *      **Example2**
 *      ```
 *      Input: 125
 *      Output: "one hundred twenty five"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/the-number-in-words/description
 * @date   2019-07-11 18:35:29
 */
public class L_0688_The_Number_In_Words {


    static class Solution {
        
        static String[] n2e1 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        static String[] n2e2 = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        static String[] n2e3 = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        static String[] unit1 = {"", "thousand", "million", "billion"};
    
        public String convertWords(int number) {
            if (number == 0) return "zero";
            
            ArrayList<String> l = new ArrayList<>();
            
            int index = 0;
            while (number > 0) {
                int n = number % 1000;
                number = number / 1000;
                if (n != 0) {
                    l.add(unit1[index]);
                    trans3(n, l);
                }
                index++;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(l.get(l.size()-1));
            for (int i = l.size()-2; i >= 0;i --) {
                if (!l.get(i).equals("")) {
                    sb.append(" ");
                    sb.append(l.get(i));
                }
            }
            
            return sb.toString();
        }

        private void trans3(int n, ArrayList<String> l) {
            
            int n2 = n % 100;
            
            if (n2 < 20 && n2 >= 10) {
                l.add(n2e3[n2-10]);
            } else {
                int n3 = n2 % 10;
                    n2 = n2 / 10;
                    if (n3 != 0) l.add(n2e1[n3]);
                    if (n2 != 0) l.add(n2e2[n2]);
            }
            n = n / 100;
            if (n != 0) {
                l.add("hundred");
                l.add(n2e1[n]);
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
