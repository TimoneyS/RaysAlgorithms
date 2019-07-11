package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a `pattern` and a string `str`, find if `str` follows the same pattern.
 *      
 *      Here **follow** means a full match, such that there is a [bijection](https://baike.baidu.com/item/%E5%8F%8C%E5%B0%84/942799?fr=aladdin "bijection") between a letter in `pattern` and a **non-empty** substring in `str`.(i.e if `a` corresponds to `s`, then `b` cannot correspond to `s`. For example, given pattern = `"ab"`, str = `"ss"`, return `false`.)
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      pattern = "abab"
 *      str = "redblueredblue"
 *      Output: true
 *      Explanation: "a"->"red","b"->"blue"
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      pattern = "aaaa"
 *      str = "asdasdasdasd"
 *      Output: true
 *      Explanation: "a"->"asd"
 *      ```
 *      
 *      **Example 3**
 *      
 *      ```plain
 *      Input:
 *      pattern = "aabb"
 *      str = "xyzabcxzyabc"
 *      Output: false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-pattern-ii/description
 * @date   2019-07-11 18:37:14
 */
public class L_0829_Word_Pattern_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
