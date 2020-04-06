package com.ray.leetcode;

import com.ray.io.Out;

/**
 * String Compression
 * -----------------------------------------------------------------------------
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * Follow up:
 * Could you solve it using only O(1) extra space?
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

            StringBuilder sb = new StringBuilder();

            char prev = chars[0];
            int count = 1;
            int prevCount = -1;
            boolean flag = false;

            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == prev) {
                    count ++;
                } else {
                    sb.append(prev);
                    sb.append(count);
                    if (prevCount != -1 && prevCount != count)
                        flag = true;
                    prev = chars[i];
                    prevCount = count;
                    count = 1;
                }
            }
            if (prevCount != -1 && prevCount != count)
                flag = true;
            sb.append(prev);
            sb.append(count);

            if (!flag) {
                for (int i = sb.length()-1; i >= 0; i -= 2) {
                    sb.deleteCharAt(i);
                }
            }

            while (sb.charAt(sb.length()-1) != '#')
                sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);

            return Math.min(sb.length(), chars.length);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
