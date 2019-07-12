package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of n distinct non-empty strings, you need to generate **minimal** possible abbreviations for every word following rules below.
 *      
 *      1. Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 *      2. If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
 *      3. If the abbreviation doesn't make the word shorter, then keep it as original.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      ["like","god","internal","me","internet","interval","intension","face","intrusion"]
 *      Output:
 *      ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      ["where","there","is","beautiful","way"]
 *      Output:
 *      ["w3e","t3e","is","b7l","way"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-abbreviation/description
 * @date   2019-07-11 18:34:39
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
