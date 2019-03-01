package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 给出一组 n 个不同的非空字符串，您需要按以下规则为每个单词生成 最小 的缩写。
 *      1. 从第一个字符开始，然后加上中间缩写掉的字符的长度，后跟最后一个字符。
 *      2. 如果有冲突，就是多个单词共享相同的缩写，使用较长的前缀，而不是仅使用第一个字符，直到使单词的缩写的映射变为唯一。 
 *              换句话说，最终得到的缩写不能映射到多个原始单词。
 *      3. 如果缩写不会使单词更短，则不进行缩写，保持原样。
 *
 * @author rays1
 * @url https://www.lintcode.com/problem/word-abbreviation/description
 */
public class L_0639_Word_Abbreviation {

    /**
     * 先将所有字符串全部缩写
     *      若有重复的则将其缩写长度缩小1
     *      不断的重复以上操作直到没有重复的缩写
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public String[] wordsAbbreviation(String[] dict) {
            int len = dict.length;
            String[] ans = new String[len];
            int[] prefix = new int[len];
            Map<String, Integer> count = new HashMap<>();

            for (int i = 0; i < len; i++) {
                prefix[i] = 1;
                ans[i] = getAbbr(dict[i], 1);
                count.put(ans[i], count.getOrDefault(ans[i], 0) + 1);
            }

            while (true) {
                boolean unique = true;
                for (int i = 0; i < len; i++) {
                    if (count.get(ans[i]) > 1) {
                        prefix[i]++;
                        ans[i] = getAbbr(dict[i], prefix[i]);
                        count.put(ans[i], count.getOrDefault(ans[i], 0) + 1);
                        unique = false;
                    }
                }
                if (unique) {
                    break;
                }
            }
            return ans;
        }

        String getAbbr(String s, int p) {
            if (p >= s.length() - 2) {
                return s;
            }
            String ans;
            ans = s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
            return ans;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
