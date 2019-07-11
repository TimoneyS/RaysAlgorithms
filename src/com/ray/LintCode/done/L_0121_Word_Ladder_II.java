package com.ray.LintCode.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two words (*start* and *end*), and a dictionary, find all shortest transformation sequence(s) from *start* to *end*, output sequence in dictionary order.
 *      Transformation rule such that:
 *      
 *      1. Only one letter can be changed at a time
 *      2. Each intermediate word must exist in the dictionary
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：start = "a"，end = "c"，dict =["a","b","c"]
 *      Output：[["a","c"]]
 *      Explanation：
 *      "a"->"c"
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
 *      Output：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 *      Explanation：
 *      1."hit"->"hot"->"dot"->"dog"->"cog"
 *      2."hit"->"hot"->"lot"->"log"->"cog"
 *      The dictionary order of the first sequence is less than that of the second.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-ladder-ii/description
 * @date   2019-07-11 18:30:50
 */
public class L_0121_Word_Ladder_II {

    /**
     * 方法时间复杂度较高，考虑如何优化
     * @author rays1
     *
     */
    static class Solution {
        
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            dict.add(end);
            dict.remove(start);
            
            Map<String, Set<String>> pathTo = new HashMap<>();
            Queue<String> queue1 = new ArrayDeque<>();
            Queue<String> queue2 = new ArrayDeque<>();
            List<List<String>> rs =  new ArrayList<List<String>>();
            
            
            
            queue1.add(start);
            while (!queue1.isEmpty()) {
                
                String curr = queue1.poll();
                
                for (String next : dict) {
                    int diff = diff(curr, next);
                    if (diff == 1) {
                        addPath(curr, next, pathTo);
                        queue2.add(next);
                    }
                }
                
                if (queue1.isEmpty()) {
                    Iterator<String> it = dict.iterator();
                    while (it.hasNext()) {
                        if (pathTo.containsKey(it.next())) it.remove();
                    }
                    Queue<String> t = queue1;
                    queue1 = queue2;
                    queue2 = t;
                }
                
            }
            
            Out.p(pathTo);
            
            buildResult(rs, null, end, pathTo);
            
            return rs;
        }
        
        private void buildResult(List<List<String>> rs, List<String> path, String curr, Map<String, Set<String>> pathTo) {
            
            Set<String> adj = pathTo.get(curr);
            
            if (adj == null) {
                path.add(0, curr);
                rs.add(path);
                return;
            }
            
            for (String next : adj) {
                List<String> p = new ArrayList<>();
                if (path != null)
                    p.addAll(path);
                p.add(0, curr);
                buildResult(rs, p, next, pathTo);
            }
            
        }

        private void addPath(String curr, String next, Map<String, Set<String>> pathTo) {
            Set<String> list = pathTo.get(next);
            if (list == null) {
                list = new HashSet<String>();
                pathTo.put(next, list);
            }
            list.add(curr);
        }

        private int diff(String s1, String s2) {
            int c = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) c++;
                if (c >= 2) break;
            }
            return c;
        }
        
    }
    
    public static void main(String[] args) {
        
        String start = "qa";
        String end = "sq";
        String[] dictArr = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        Set<String> dict = new HashSet<String>();
        
        for (String s : dictArr) {
            dict.add(s);
        }
        
        List<List<String>> list = new Solution().findLadders(start, end, dict);
        
        list.sort((List<String> o1, List<String> o2) -> {
                return o1.toString().compareTo(o2.toString());
        });
        
        Out.p(list);
        
    }

}
