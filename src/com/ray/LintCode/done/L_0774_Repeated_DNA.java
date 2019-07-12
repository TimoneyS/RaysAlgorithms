package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      All DNA is composed of a series of nucleotides abbreviated as `A`, `C`, `G`, and `T`.
 *      For example: `"ACGAATTCCG"`.  When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *      Write a function to find all `the 10-letter-long` sequences (substrings) that occur more than once in a DNA molecule.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *      Output:
 *      ["AAAAACCCCC","CCCCCAAAAA"]
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      "GAGAGAGAGAGA"
 *      Output:
 *      ["GAGAGAGAGA"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/repeated-dna/description
 * @date   2019-07-11 18:36:33
 */
public class L_0774_Repeated_DNA {

    /**
     * 设两个字符串长度分别是 n
     * 
     * 暴力算法分析
     *      将 n 分解成 10个长度的字符串可以分解为 n - 10个
     *      每个长度10的符串在 n 长度的字符串中搜索，复杂度为 10*n ，一共要搜索 n-10 次
     *      总体复杂度 为  (n-10)*10*n = 10*n*n - 100*n ~ O(n^2)
     * @author rays1
     *
     */
    static class Solution {
    
        public List<String> findRepeatedDna(String s) {
            List<String> rs = new ArrayList<>();
            Set<Integer> used = new HashSet<Integer>();
            for (int i = 0, j = 10+i; j <= s.length(); i++,j++ ) {
                String sub = s.substring(i, j);
                if (used.contains(sub.hashCode())) continue;
                used.add(sub.hashCode());
                if (s.indexOf(sub, i+1) != -1) rs.add(sub);
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
