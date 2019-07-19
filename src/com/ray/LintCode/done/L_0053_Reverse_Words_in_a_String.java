package com.ray.LintCode.done;

import java.util.Random;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      给定一个字符串，以单词为单位翻转字符串。
 *      用例给出的字符串首位的空格和单词之间的多个空格，需要过滤。
 *      
 * 用例：
 *      用例 1:
 *      	输入:  "the sky is blue"
 *      	输出:  "blue is sky the"
 *      	
 *      用例 2:
 *      	输入:  "hello world"
 *      	输出:  "world hello"
 *      
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-words-in-a-string/description
 * @date   2019-07-11 18:04:49
 */
public class L_0053_Reverse_Words_in_a_String {
    
    static class Solution {
        
        public String reverseWords(String s) {
            char[] arr = new char[s.length()]; 
            int cursor = 0;
            int r = s.length()-1;
            for (int i = s.length()-1; i >= -1; i--) {
                char c = i >= 0 ? s.charAt(i) : ' ';
                if (c == ' ') {
                    if (r == i) {
                        r --;
                        continue;
                    }
                    if (cursor != 0) {
                        arr[cursor++] = ' '; // cursor = 0  说明还没有检测到 world
                    }
                    for (int j = i+1; j <= r; j++) {
                        arr[cursor++] = s.charAt(j);
                    }
                    r = i-1;
                }
            }
            return new String(arr, 0, cursor);
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

        Out.p(new Solution().reverseWords("  Life  doesn't  always    give     us  the       joys we want."));
        
        int n = 200000000;
        String s = createString(n);
        Timer.CLICK();
        new Solution().reverseWords(s);
        Timer.STOP();
    }

}
