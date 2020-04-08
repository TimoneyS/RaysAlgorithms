package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Increasing Decreasing String
 * -----------------------------------------------------------------------------
 * Given a string s. You should re-order the string using the following algorithm:
 * 	Pick the smallest character from s and append it to the result.
 * 	Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * 	Repeat step 2 until you cannot pick more characters.
 * 	Pick the largest character from s and append it to the result.
 * 	Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * 	Repeat step 5 until you cannot pick more characters.
 * 	Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 * Return the result string after sorting s with this algorithm.
 *
 * Example:
 *      Example 1
 *      Input: s = aaaabbbbcccc
 *      Output: abccbaabccba
 *      Explanation: After steps 1, 2 and 3 of the first iteration, result = abc
 *      After steps 4, 5 and 6 of the first iteration, result = abccba
 *      First iteration is done. Now s = aabbcc and we go back to step 1
 *      After steps 1, 2 and 3 of the second iteration, result = abccbaabc
 *      After steps 4, 5 and 6 of the second iteration, result = abccbaabccba
 *      Example 2
 *      Input: s = rat
 *      Output: art
 *      Explanation: The word rat becomes art after re-ordering it with the mentioned algorithm.
 *      Example 3
 *      Input: s = leetcode
 *      Output: cdelotee
 *      Example 4
 *      Input: s = ggggggg
 *      Output: ggggggg
 *      Example 5
 *      Input: s = spo
 *      Output: ops
 *      Constraints:
 *      	1 <= s.length <= 500
 *      	s contains only lower-case English letters.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/increasing-decreasing-string/
 * @since   2020-04-08 22:04:26
 */
public class L1472_Increasing_Decreasing_String {
    static class Solution {
        public String sortString(String s) {
            int[] count = new int[26];
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                if (count[s.charAt(i)-'a'] == 0) {
                    total ++;
                }
                count[s.charAt(i)-'a'] ++;
            }
            StringBuilder sb = new StringBuilder();

            boolean direct = true;
            while (total != 0) {
                for (int i = 0; i < count.length; i++) {
                    int index = direct ? i : count.length - 1 - i;
                    if (count[index] <= 0) continue;
                    if (total == 1) i --;
                    sb.append((char)(index + 'a'));
                    count[index] --;

                    if (count[index] == 0) {
                        total --;
                    }
                }
                direct = !direct;
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
