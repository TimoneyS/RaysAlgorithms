package com.ray.LintCode;

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

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
