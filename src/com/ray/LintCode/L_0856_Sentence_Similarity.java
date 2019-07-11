package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two sentences `words1`, `words2` (each represented as an array of strings), and a list of similar word pairs `pairs`, determine if two sentences are similar.
 *      
 *      For example, `words1 = great acting skills` and `words2 = fine drama talent` are similar, if the similar word pairs are `pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]`.
 *      
 *      Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are **not** necessarily similar.
 *      
 *      However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 *      
 *      Also, a word is always similar with itself. For example, the sentences `words1 = ["great"], words2 = ["great"], pairs = []` are similar, even though there are no specified similar word pairs.
 *      
 *      Finally, sentences can only be similar if they have the same number of words. So a sentence like `words1 = ["great"]` can never be similar to `words2 = ["doubleplus","good"]`.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: words1 = ["great","acting","skills"], words2 = ["fine","drama","talent"] and pairs = [["great","fine"],["drama","acting"],["skills","talent"]]
 *      Output: true
 *      Explanation:
 *      "great" is similar with "fine"
 *      "acting" is similar with "drama"
 *      "skills" is similar with "talent"
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: words1 = ["fine","skills","acting"], words2 = ["fine","drama","talent"] and pairs = [["great","fine"],["drama","acting"],["skills","talent"]]
 *      Output: false
 *      Explanation:
 *      "fine" is the same as "fine"
 *      "skills" is not similar with "drama"
 *      "acting" is not similar with "talent"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sentence-similarity/description
 * @date   2019-07-11 18:37:39
 */
public class L_0856_Sentence_Similarity {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
