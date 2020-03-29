package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Short Encoding of Words
 * -----------------------------------------------------------------------------
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 * For example, if the list of words is [time, me, bell], we can write it as S = time#bell# and indexes = [0, 2, 5].
 * Then for each index, we will recover the word by reading from the reference string from that index until we reach a # character.
 * What is the length of the shortest reference string S possible that encodes the given words?
 *
 * Example:
 *      Example 1
 *      Input: words = [time, me, bell]
 *      Output: 10
 *      Explanation: S = time#bell# and indexes = [0, 2, 5].
 *      Note:
 *      	1 <= words.length <= 2000.
 *      	1 <= words[i].length <= 7.
 *      	Each word has only lowercase letters.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/short-encoding-of-words/
 * @since   2020-03-29 22:57:25
 */
public class L0839_Short_Encoding_of_Words {
    /**
     * 倒序访问单词，构建单词树，最终所有叶子结点的深度和就是最小长度
     */
    static class Solution {
        class TrieNode {
            int deepth;
            Map<Character, TrieNode> adj = new HashMap<>();
            public TrieNode(int deepth) {
                this.deepth = deepth;
            }
        }

        public int minimumLengthEncoding(String[] words) {
            TrieNode root = new TrieNode(0);
            int size = 0;
            for (String word : words) {
                TrieNode n = root;
                int cursor = 0;
                while (cursor < word.length()) {
                    char c = word.charAt( word.length() - 1 - cursor);
                    if (!n.adj.containsKey(c)) {
                        break;
                    }
                    n = n.adj.get(c);
                    cursor ++;
                }
                if (cursor == word.length()) continue;

                if (n.adj.size() == 0) size -= cursor == 0 ? 0 : cursor + 1;
                while (cursor < word.length()) {
                    char c = word.charAt(word.length() - 1 - cursor);
                    n.adj.put(c, new TrieNode(n.deepth + 1));
                    n = n.adj.get(c);
                    cursor++;
                }
                size += cursor + 1;
            }
            return size;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
