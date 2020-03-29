package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Most Common Word
 * -----------------------------------------------------------------------------
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      paragraph = Bob hit a ball, the hit BALL flew far after it was hit.
 *      banned = [hit]
 *      Output: ball
 *      Explanation: 
 *      hit occurs 3 times, but it is a banned word.
 *      ball occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
 *      Note that words in the paragraph are not case sensitive,
 *      that punctuation is ignored (even if adjacent to words, such as ball,), 
 *      and that hit isn't the answer even though it occurs more because it is banned.
 *      Note: 
 *      	1 <= paragraph.length <= 1000.
 *      	0 <= banned.length <= 100.
 *      	1 <= banned[i].length <= 10.
 *      	The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 *      	paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 *      	There are no hyphens or hyphenated words.
 *      	Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/most-common-word/
 * @since   2020-03-29 09:58:19
 */
public class L0837_Most_Common_Word {
    static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {

            Set<String> bannedSet = new HashSet<>();
            for (String b : banned) bannedSet.add(b.toLowerCase());

            Map<String,Integer> map = new HashMap<>();
            String max = null;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= paragraph.length(); i++) {
                char c = i == paragraph.length() ? ' ' : paragraph.charAt(i);
                if (Character.isLetter(c)) {
                    sb.append(c > 'Z' ? c : (char)(c - 'A' + 'a'));
                } else {
                    if (sb.length() > 0) {
                        String w = sb.toString();
                        if (!bannedSet.contains(w)) {
                            map.put(w, map.getOrDefault(w, 0) + 1);
                            if (max == null || map.get(w) > map.get(max)) max = w;
                        }
                        sb = new StringBuilder();
                    }
                }
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
