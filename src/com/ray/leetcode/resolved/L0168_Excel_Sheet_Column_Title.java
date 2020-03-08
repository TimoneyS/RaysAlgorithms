package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Excel Sheet Column Title
 * -----------------------------------------------------------------------------
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 *     ...
 *
 * Example:
 *      Example 1
 *      Input: 1
 *      Output: A
 *      Example 2
 *      Input: 28
 *      Output: AB
 *      Example 3
 *      Input: 701
 *      Output: ZY
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/excel-sheet-column-title/
 * @since   2020-03-08 10:50:15
 */
public class L0168_Excel_Sheet_Column_Title {
    /**
     * 每个位置上能够出现的数字是 1 - 26，这次这就像是去了 0 这个数字的模运算。
     */
    static class Solution {
        public String convertToTitle(int n) {
            n--;
            StringBuilder sb = new StringBuilder();
            if (n >= 0) {
                int i = n % 26;
                n /= 26;
                sb.insert(0, (char)('A' + i));
            }
            while (n != 0) {
                int i = n % 26;
                n /= 26;
                if (i == 0) {
                    i = 26;
                    n -- ;
                }
                sb.insert(0, (char)('A' + i - 1));
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().convertToTitle(1));
        Out.p(new Solution().convertToTitle(26));
        Out.p(new Solution().convertToTitle(27));
        Out.p(new Solution().convertToTitle(28));
        Out.p(new Solution().convertToTitle(701));
        Out.p(new Solution().convertToTitle(702));
        Out.p(new Solution().convertToTitle(703));
    }
}
