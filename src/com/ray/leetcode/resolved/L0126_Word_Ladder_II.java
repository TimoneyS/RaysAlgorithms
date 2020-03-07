package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Word Ladder II
 * -----------------------------------------------------------------------------
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 	Only one letter can be changed at a time
 * 	Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * 	Return an empty list if there is no such transformation sequence.
 * 	All words have the same length.
 * 	All words contain only lowercase alphabetic characters.
 * 	You may assume no duplicates in the word list.
 * 	You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example:
 *      Example 1
 *      Input:
 *      beginWord = hit,
 *      endWord = cog,
 *      wordList = [hot,dot,dog,lot,log,cog]
 *      Output:
 *      [
 *        [hit,hot,dot,dog,cog],
 *        [hit,hot,lot,log,cog]
 *      ]
 *      Example 2
 *      Input:
 *      beginWord = hit
 *      endWord = cog
 *      wordList = [hot,dot,dog,lot,log]
 *      Output: []
 *      Explanation: The endWord cog is not in wordList, therefore no possible transformation.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/word-ladder-ii/
 * @since   2020-03-04 22:42:42
 */
public class L0126_Word_Ladder_II {
    /**
     * 和 Word_Ladder 一致，BFS
     */
    static class Solution {
        public List<List<String>> findLadders(String start, String end, List<String> dict1) {
            List<List<String>> rs = new ArrayList<>();
            Set<String> dict = new HashSet<>(dict1);
            if (!dict.contains(end)) return rs;
            Queue<List<String>> queue = new ArrayDeque<>();
            queue.add(new ArrayList<>());
            queue.iterator().next().add(start);

            int dist = 1, size = 1;
            int shortest = 0;
            while (!queue.isEmpty()) {
                List<String> path = queue.poll();
                String word = path.get(path.size() - 1);
                if (shortest != 0 && path.size() > shortest) {
                    continue;
                }
                if (word.equals(end)) {
                    rs.add(path);
                    shortest = dist;
                    continue;
                }
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String l = i == 0 ? "" : word.substring(0, i);
                        String r = i == start.length() - 1 ? "" : word.substring(i+1);
                        if (c != word.charAt(i)) {
                            String newWord = l + c + r;
                            if (dict.contains(newWord)) {
                                List<String> newPath = new ArrayList<>(path);
                                newPath.add(newWord);
                                queue.offer(newPath);
                            }
                        }
                    }
                }
                size--;
                if (size == 0) {
                    for (List<String> l : queue) {
                        dict.remove(l.get(l.size()-1));
                    }
                    size = queue.size();
                    dist ++;
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String[] dictArr = {"hot","dot","dog","lot","log","cog"};
        List<String> dict = new ArrayList<>(Arrays.asList(dictArr));
        List<List<String>> list = new Solution().findLadders(start, end, dict);
        list.sort(Comparator.comparing(Object::toString));
        Out.p(list);
    }
}
