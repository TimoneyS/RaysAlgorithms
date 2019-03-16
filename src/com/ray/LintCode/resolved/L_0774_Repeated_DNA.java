package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 * 所有的DNA由一系列缩写的核苷酸 A, C, G 和 T组成.
 * 比如; "ACGAATTCCG". 在研究 DNA 时, 有时候鉴别出 DNA 中的重复序列是很有用的.
 * 写一个函数来找到所有在 DNA 中出现超过一次且长度为 10个字母 的序列(子串).
 *
 * @author rays1
 *
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
        
        String s = "GAGAGAGAGAGA";
        
        Out.p(new Solution().findRepeatedDna(s));
        
    }

}
