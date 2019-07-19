package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定输入的字符数组，逐词翻转数组。单词被定义为不包含空格的字符串.
 *      输入字符数组不包含前导或尾部空格，单词总是用单个空格分隔。
 *
 * 用例：
 *      **用例1**
 *      
 *      ```
 *      输入: s = "the sky is blue"
 *      输出: "blue is sky the"
 *      ```
 *      
 *      **用例2**
 *      
 *      ```
 *      输入: "a b c"
 *      输出: "c b a"
 *      ```
 *
 * 挑战：
 *      Could you do it in-place without allocating extra space?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-words-in-a-string-ii/description
 * @date   2019-07-19 17:27:13
 */
public class L_0927_Reverse_Words_in_a_String_II {

    static class Solution {
    
        public char[] reverseWords(char[] str) {
            char[] arr = new char[str.length]; 
            int cursor = 0;
            int r = str.length-1;
            for (int i = r; i >= -1; i--) {
                char c = i >= 0 ? str[i] : ' ';
                if (c == ' ') {
                    if (r == i) {
                        r --;
                        continue;
                    }
                    if (cursor != 0) {
                        arr[cursor++] = ' '; // cursor = 0  说明还没有检测到 world
                    }
                    for (int j = i+1; j <= r; j++) {
                        arr[cursor++] = str[j];
                    }
                    r = i-1;
                }
            }
            return arr;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
