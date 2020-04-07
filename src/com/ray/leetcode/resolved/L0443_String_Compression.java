package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * String Compression
 * -----------------------------------------------------------------------------
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * Example:
 *      Example 1
 *      Input:
 *      [a,a,b,b,c,c,c]
 *      Output:
 *      Return 6, and the first 6 characters of the input array should be: [a,2,b,2,c,3]
 *      Explanation:
 *      aa is replaced by a2. bb is replaced by b2. ccc is replaced by c3.
 *      Example 2
 *      Input:
 *      [a]
 *      Output:
 *      Return 1, and the first 1 characters of the input array should be: [a]
 *      Explanation:
 *      Nothing is replaced.
 *      Example 3
 *      Input:
 *      [a,b,b,b,b,b,b,b,b,b,b,b,b]
 *      Output:
 *      Return 4, and the first 4 characters of the input array should be: [a,b,1,2].
 *      Explanation:
 *      Since the character a does not repeat, it is not compressed. bbbbbbbbbbbb is replaced by b12.
 *      Notice each digit has it's own entry in the array.
 *      Note:
 *      	All characters have an ASCII value in [35, 126].
 *      	1 <= len(chars) <= 1000.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/string-compression/
 * @since   2020-04-06 23:26:09
 */
public class L0443_String_Compression {
    static class Solution {
        public int compress(char[] chars) {
            if (chars == null || chars.length == 0) return 0;
            int l = 0;
            int count = 0;
            for (int i = 0; i <= chars.length; i++) {
                if (i < chars.length && chars[i] == chars[l]) {
                    count ++;
                } else {
                    l++;
                    if (count > 1) {
                        String s = String.valueOf(count);
                        for (int j = 0; j < s.length(); j++) {
                            chars[l++] = s.charAt(j);
                        }
                    }
                    if (i < chars.length) chars[l] = chars[i];
                    count = 1;
                }
            }
            return l;
        }
    }
    
    public static void main(String[] args) {
        char[] chars = "aaaaabbbbbbcccc".toCharArray();
        Solution sol = new Solution();
        Out.p(sol.compress(chars));
        Out.p(chars);
    }
}
