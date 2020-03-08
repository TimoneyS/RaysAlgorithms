package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Repeated DNA Sequences
 * -----------------------------------------------------------------------------
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: ACGAATTCCG. When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *      Example 1
 *      Input: s = AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT
 *      Output: [AAAAACCCCC, CCCCCAAAAA]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/repeated-dna-sequences/
 * @since   2020-03-08 20:10:07
 */
public class L0187_Repeated_DNA_Sequences {
    /**
     * ATCG 四个字母，可以用一个4进制的数字代替，那么长度10 的字符串可以用 10 个4进制的字符串表示
     * 因此，可以统计每个10个长度的字符串的Hash值，缓存。
     *
     * 如果hash值已经被缓存，说明DNA有重复
     *
     */
    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> rs = new ArrayList<>();
            int[] id = new int[255];
            id['A'] = 0;
            id['T'] = 1;
            id['C'] = 2;
            id['G'] = 3;

            if (s.length() <= 10) {
                return rs;
            }

            int hash = 0;
            for (int i = 0; i < 10; i++) {
                hash <<= 2;
                hash &= ((1 << 20)-1);
                hash |= id[s.charAt(i)];
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(hash, 1);

            for (int i = 10; i < s.length(); i++) {
                hash <<= 2;
                hash &= ((1 << 20)-1);
                hash |= id[s.charAt(i)];

                if (map.containsKey(hash)) {
                    if (map.get(hash) == 1) {
                        rs.add(s.substring(i-9,i+1));
                    }
                    map.put(hash, 2);
                } else {
                    map.put(hash, 1);
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Out.p(new Solution().findRepeatedDnaSequences(s));
    }
}
