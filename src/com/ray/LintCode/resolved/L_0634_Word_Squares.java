package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 根据一系列的不重复的单词，构建出所有可能的单词矩阵。
 *
 * 一个有效的单词矩阵是指, 如果从第 k 行读出来的单词和第 k 列读出来的单词相同(0 <= k < max(numRows, numColumns))，那么就是一个单词矩阵.
 * 例如
 *      单词序列为 ["ball","area","lead","lady"] ,构成一个单词矩阵。
 *      因为对于每一行和每一列，读出来的单词都是相同的。
 *          b a l l
 *          a r e a
 *          l e a d
 *          l a d y
 *
 * @author rays1
 *
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
        
        String[] words = {"aaa", "bbb"};
        
        Out.p(new Solution().wordSquares(words));
        
    }

}
