package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个列表的互不相同的单词，寻找所有不同的索引（i，j）对, 使得两个单词的串联即 words[i] + words[j] 是回文串.
 * 
 * 如：
 *       ["abcd", "dcba", "lls", "s", "sssll"]
 *          0       1       2    3      4
 *      输出        
 *          0, 1    abcd + dcba
 *          1, 0    dcba + abcd
 *          2, 4    lls  + sssll
 * @author rays1
 *
 */
public class L_0775_Palindrome_Pairs {

    /**
     * 首先只考虑单词由数字组成的情况，word1 + word2 是回文有两种情况
     * 
     * 1. 以两个单词的结合处开始回文，且回文字符串为偶数。
     *      reverse(word1) - word2 = 0
     * 
     * 2. word1 中本身包含回文，另一个 word2，补足剩下的回文（也可能是word2和word1的情况调换，但是一定是有回文的字符串更长）
     *      123454 + 321
     *      
     *      reverse(word1) - word2
     *      454321 - 321 = 454
     *      
     *  对任意两个字符串判断
     *          长度相等 -> reverse(word1) == word2
     *          长度不等 -> reverse(word1) - word2 == 回文
     *  复杂度 O(n^2)
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> rs = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = i+1; j < words.length; j++) {
                    if (words[i].length() == words[j].length()) {
                        if(!reverEqual(words[i], words[j])) continue;
                        rs.add(list(i, j));
                        rs.add(list(j, i));
                    } else {
                        
                        if (isAppendPal(words[i], words[j])) {
                            rs.add(list(i, j));
                        }
                        if (isAppendPal(words[j], words[i])) {
                            rs.add(list(j, i));
                        }
                    }
                }
            }
            return rs;
        }
        
        private boolean isAppendPal(String s1, String s2) {
            
            int i = 0, j = s2.length()-1;
            while (true) {
                if (i == s1.length() || j < 0) break;
                if (s1.charAt(i) != s2.charAt(j)) return false;
                i++;j--;
            }
            if (i == s1.length()) {
                return isPal(s2, 0, j);
            } else if (j < 0) {
                return isPal(s1, i, s1.length()-1);
            }
            return false;
        }
        
        private boolean isPal(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }

        private List<Integer> list(Integer...arr) {
            return Arrays.asList(arr);
        }

        private boolean reverEqual(String s1, String s2) {
            int n = s1.length()-1;
            for (int i = 0; i <= n; i++) {
                if (s1.charAt(i) != s2.charAt(n-i)) return false;
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        String[] words = {"bat","tab","cat"};
        
        Out.p(new Solution().palindromePairs(words));
        
    }

}
