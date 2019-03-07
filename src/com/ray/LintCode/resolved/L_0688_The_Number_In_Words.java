package com.ray.LintCode.resolved;

import java.util.ArrayList;

import com.ray.io.Out;

/**
 * 给定一个非负整数，用单词中打印数字
 *
 * 示例
 *      输入：10245
 *      输出：ten thousand two hundred forty five"
 *
 * @author rays1
 *
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
        
        int number = 2000000000;
        
        Out.p(new Solution().convertWords(number));
        
    }

}
