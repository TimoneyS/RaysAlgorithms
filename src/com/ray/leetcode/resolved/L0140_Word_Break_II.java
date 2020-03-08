package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Word Break II
 * -----------------------------------------------------------------------------
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * Note:
 * 	The same word in the dictionary may be reused multiple times in the segmentation.
 * 	You may assume the dictionary does not contain duplicate words.
 *
 * Example:
 *      Example 1
 *      Input:
 *      s = catsanddog
 *      wordDict = [cat, cats, and, sand, dog]
 *      Output:
 *      [
 *        cats and dog,
 *        cat sand dog
 *      ]
 *      Example 2
 *      Input:
 *      s = pineapplepenapple
 *      wordDict = [apple, pen, applepen, pine, pineapple]
 *      Output:
 *      [
 *        pine apple pen apple,
 *        pineapple pen apple,
 *        pine applepen apple
 *      ]
 *      Explanation: Note that you are allowed to reuse a dictionary word.
 *      Example 3
 *      Input:
 *      s = catsandog
 *      wordDict = [cats, dog, sand, and, cat]
 *      Output:
 *      []
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/word-break-ii/
 * @since   2020-03-07 20:20:39
 */
public class L0140_Word_Break_II {

    /**
     * 标准动态规划
     *
     * 1. 先利用字典构建单词查找树
     *
     * 2. 从左向右遍历字符串并同时开启查找
     *      如果在位置i查找命中，则说明可能在此处断句
     *      则递归从 i+1 开始查找子字符串的断句方式
     *
     * 字符串的断句方式 = { 断句单词1 + 子字符串1断句方式 } + { 断句单词2 + 子字符串2断句方式 } ...
     * 需要注意一个点就是，到到达字符串末尾时，断句方式就是断句单词
     */
    static class Solution {

        class TrieNode {
            String  value;
            Map<Character, TrieNode> map = new HashMap<>();
            boolean contains(char key) {return map.containsKey(key);}
        }

        void addToTrie(TrieNode root, String s, int start) {
            if (start == s.length()) {
                root.value = s;
            } else {
                char key = s.charAt(start);
                if (!root.contains(key))  root.map.put(key, new TrieNode());
                addToTrie(root.map.get(key), s, start+1);
            }
        }

        TrieNode build(List<String> wordDict) {
            TrieNode root = new TrieNode();
            for (String s : wordDict) addToTrie(root, s, 0);
            return root;
        }

        Map<Integer, List<String>> cache;

        public List<String> wordBreak(String s, List<String> wordDict) {
            TrieNode root   = build(wordDict);
            cache           = new HashMap<>();
            return helper(s, 0, root);
        }

        List<String> helper(String s, int start, TrieNode root) {
            if (!cache.containsKey(start)) {
                List<String> rs = new ArrayList<>();
                TrieNode node = root;
                for (int i = start; i < s.length(); i++) {
                    char key = s.charAt(i);
                    if (!node.contains(key)) break;
                    node = node.map.get(key);
                    if (node.value != null) {
                        if (i + 1 == s.length()) {
                            rs.add(node.value);
                        } else {
                            List<String> temp = helper(s, i + 1, root);
                            for (String ss : temp) {
                                rs.add(node.value + " " + ss);
                            }
                        }
                    }
                }
                cache.put(start, rs);
            }
            return cache.get(start);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
