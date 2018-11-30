package com.ray.LintCode;

import java.util.Random;

import com.ray.util.Timer;

/**
 * Given an input string, reverse the string word by word.
 * 
 * Given s = "the sky is blue", return "blue is sky the".
 * 
 * @author rays1
 *
 */
public class L_0053_Reverse_Words_in_a_String {

    static class Solution1 {
        
        /*
         * @param s: A string
         * 
         * @return: A string
         */
        public String reverseWords(String s) {
            char[] arr = new char[s.length()]; 
            int index = 0;
            int size  = 0;
            for (int i = s.length()-1; i >= -1; i--) {
                char c = i >= 0 ? s.charAt(i) : ' ';
                if (c == ' ') {
                    if (size == 0) continue;
                    if (index != 0) arr[index++] = ' '; // index = 0  说明还没有检测到 world
                    for (int j = 1; j <= size; j++)
                        arr[index++] = s.charAt(i+j);
                    size = 0;
                } else {
                    size ++;
                }
            }
            return new String(arr, 0, index);
        }
        
    }
    
    static class Solution {
        /*
         * @param s: A string
         * @return: A string
         */
        public String reverseWords(String s) {
           
            if (s.length() <= 1) return s;
            char[] arr = s.toCharArray();
            int[] newOrder = new int[arr.length];
            
            int index = findOrder(arr, newOrder);
            
            int  curr, prev;
            char tc1, tc2;
            for (int i = 0; i < newOrder.length; i++) {
                curr = i;
                tc1 = tc2 = arr[i];
                while (newOrder[curr] != -1) {
                    prev = curr;
                    curr = newOrder[curr];
                    newOrder[prev] = -1;
                    
                    tc2 = arr[curr];
                    arr[curr] = tc1;
                    tc1 = tc2;
                }
                
            }
            int i = arr.length-1;
            while (i>=0) {
                if (arr[i--] != ' ') break;
            }
            
            return new String(arr, 0, index);
        }

        private int findOrder(char[] arr, int[] newOrder) {
            int t = -1;
            int index = 0;
            for (int i = arr.length-1; i >=0; i--,index++) {
                if (arr[i] == ' ') {
                    if (t != -1) {
                        newOrder[i] = index;
                        for (int k = t; k > i; k--) {
                            newOrder[k] = index+k-t-1;
                        }
                        t = -1;
                    } else {
                        newOrder[i] = -1;
                        index --; // 重复的空格，将索引减一
                    }
                } else if (t == -1) {
                    t = i;
                }
            }
            if (t != -1) {
                for (int k = t; k >= 0; k--) {
                    if (arr[k] != ' ')
                        newOrder[k] = index+k-t-1;
                }
            }
            return index;
        }
        
    }
    
    static String createString(int n) {
        char[] chars = new char[n];
        Random r = new Random(47);
        for (int i = 0; i < chars.length; i++) {
            int size = r.nextInt(5);
            if (size+i >= chars.length)
                size = chars.length - i - 1; 
            for (int j = 0; j < size; j++) {
                chars[j+i] = (char)(r.nextInt(26) + 97);
            }
            chars[i+size] = ' ';
            i += size;
        }
        
        return new String(chars);
    }
    
    public static void main(String[] args) {

        int n = 10000000;
        
        String s = createString(n);
        Timer.CLICK();
        new Solution1().reverseWords(s);
        Timer.CLICK();
        new Solution().reverseWords(s);
        Timer.STOP();
    }

}
