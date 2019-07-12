package com.ray.LintCode.done;

import java.util.LinkedList;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an expression `s` contains numbers, letters and brackets. Number represents the number of repetitions inside the brackets(can be a string or another expression)．Please expand expression to be a string.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: S = abc3[a]
 *      Output: "abcaaa"
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: S = 3[2[ad]3[pf]]xyz
 *      Output: "adadpfpfpfadadpfpfpfadadpfpfpfxyz"
 *      ```
 *
 * 挑战：
 *      Can you do it without recursion?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/decode-string/description
 * @date   2019-07-11 18:34:19
 */
public class L_0575_Decode_String {

    static class Solution {
        /**
         * @param s
         *            an expression includes numbers, letters and brackets
         * @return a string
         */
        public String expressionExpand(String s) {
            // 用于记录每个表达式的起点
            LinkedList<Integer[]> stack = new LinkedList<Integer[]>();

            Integer coefficient = 0;
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c))
                    coefficient = coefficient * 10 + Character.getNumericValue(c);

                if (c == '[') {
                    stack.push(new Integer[] { i, coefficient });
                    coefficient = 0;
                }
                if (c == ']') {
                    Integer[] arr = stack.pop();
                    int start = arr[0];
                    int count = arr[1];

                    StringBuilder sb = new StringBuilder();
                    String sub = s.substring(start + 1, i);

                    for (int j = 0; j < count; j++)
                        sb.append(sub);

                    s = s.substring(0, start - String.valueOf(count).length()) + sb.toString()
                            + s.substring(i + 1, length);
                    int d = sb.length() - (i - start + 1 + String.valueOf(count).length());
                    length += d;
                    i += d;
                }

            }

            return s;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
