package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Word Ladder
 * -----------------------------------------------------------------------------
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *      每次转换只能改变一个字母。
 *      转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *      如果不存在这样的转换序列，返回 0。
 *      所有单词具有相同的长度。
 *      所有单词只由小写字母组成。
 *      字典中不存在重复的单词。
 *      你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * Example:
 * Example 1
 *      Input:
 *      beginWord = hit,
 *      endWord = cog,
 *      wordList = [hot,dot,dog,lot,log,cog]
 *      Output: 5
 *      Explanation: As one shortest transformation is hit -> hot -> dot -> dog -> cog,
 *      return its length 5.
 * Example 2
 *      Input:
 *      beginWord = hit
 *      endWord = cog
 *      wordList = [hot,dot,dog,lot,log]
 *      Output: 0
 *      Explanation: The endWord cog is not in wordList, therefore no possible transformation.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/word-ladder/
 * @since   2020-03-04 22:39:31
 */
public class L0127_Word_Ladder {
    /**
     * BFS 每次拿到一个单词，将这个单词的每一位用26个字母替换后得到的新单词，这个单词如果在字典中存在
     * 则加入新的搜索队列
     */
    static class Solution {
        public int ladderLength(String start, String end, List<String> dict1) {
            Set<String> dict = new HashSet<>(dict1);
            if (!dict.contains(end)) return 0;
            Queue<String> queue = new ArrayDeque<>();
            queue.add(start);
            int dist = 1, size = 1;
            int rs = 0;
            while (!queue.isEmpty()) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    rs = dist;
                    break;
                }
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int i = 0; i < curr.length(); i++) {
                        String l = i == 0 ? "" : curr.substring(0, i);
                        String r = i == start.length() - 1 ? "" : curr.substring(i + 1, start.length());
                        if (c != curr.charAt(i)) {
                            String newWord = l + c + r;
                            if (dict.contains(newWord)) {
                                queue.offer(newWord);
                                dict.remove(newWord);
                            }
                        }
                    }
                }
                size--;
                if (size == 0) {
                    size = queue.size();
                    dist ++;
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        String start = "hot";
        String end = "dog";
        List<String> dict = Arrays.asList("hot", "dog");
        Out.p(new Solution().ladderLength(start, end, dict));
    }
}
