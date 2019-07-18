package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a set of words **without duplicates**, find all [`word squares`](https://en.wikipedia.org/wiki/Word_square "Word square") you can build from them.
 *      
 *      A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 *      
 *      For example, the word sequence `["ball","area","lead","lady"]` forms a word square because each word reads the same both horizontally and vertically.
 *      ```
 *      b a l l
 *      a r e a
 *      l e a d
 *      l a d y
 *      ```
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      ["area","lead","wall","lady","ball"]
 *      Output:
 *      [["wall","area","lead","lady"],["ball","area","lead","lady"]]
 *      
 *      Explanation:
 *      The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:
 *      ["abat","baba","atan","atal"]
 *      Output:
 *       [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-squares/description
 * @date   2019-07-11 18:34:36
 */
public class L_0634_Word_Squares {

    /**
     * 将搜索的单词的按照前缀分类
     * 
     * 每次添加一个单词到列表中，然后再寻找符合前缀要求的字符串中寻找下一层的解答，
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public List<List<String>> wordSquares(String[] words) {
            List<List<String>> rs = new ArrayList<>();
            if (words.length == 0) return rs;
            
            Map<String, ArrayList<String>> prefixMap = init(words);
            List<String> base     = new ArrayList<>();
            dfs(0, words, prefixMap, base, rs);
            return rs;
        }
        
        private void dfs(int level, String[] words, Map<String, ArrayList<String>> prefixMap, List<String> base,
                List<List<String>> rs) {

            if (level == words[0].length()) {
                rs.add(new ArrayList<>(base));
                return;
            }
            
            String prefix = "";
            for (String word : base) {
                prefix += word.charAt(level);
            }
            
            if (!prefixMap.containsKey(prefix)) return;
            
            for (String word : prefixMap.get(prefix)) {
                base.add(word);
                dfs(level+1, words, prefixMap, base, rs);
                base.remove(base.size()-1);
            }
            
        }

        private Map<String, ArrayList<String>> init(String[] words) {
            Map<String, ArrayList<String>> map = new HashMap<>();
            map.put("", new ArrayList<>());
            for (String word : words) {
                String prefix = "";
                map.get("").add(word);
                for (int i = 0;i< word.length(); i++) {
                    prefix += word.charAt(i);
                    if( !map.containsKey(prefix)) {map.put(prefix, new ArrayList<>());}
                    map.get(prefix).add(word);
                }
            }
            return map;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
