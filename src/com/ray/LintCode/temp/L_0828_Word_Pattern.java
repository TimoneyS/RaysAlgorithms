package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a `pattern` and a string `str`, find if `str` follows the same pattern.
 *      Here **follow** means a full match, such that there is a bijection between a letter in `pattern` and a **non-empty** word in `str`.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:  pattern = "abba" and str = "dog cat cat dog"
 *      Output: true
 *      Explanation:
 *      The pattern of str is abba
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input:  pattern = "abba" and str = "dog cat cat fish"
 *      Output: false
 *      Explanation:
 *      The pattern of str is abbc
 *      ```
 *      
 *      **Example3**
 *      
 *      ```
 *      Input:  pattern = "aaaa" and str = "dog cat cat dog"
 *      Output: false
 *      Explanation:
 *      The pattern of str is abba
 *      ```
 *      
 *      **Example4**
 *      
 *      ```
 *      Input:  pattern = "abba" and str = "dog cat cat fish"
 *      Output: false
 *      Explanation:
 *      The pattern of str is abbc
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-pattern/description
 * @date   2019-07-11 18:37:14
 */
public class L_0828_Word_Pattern {


    static class Solution {
    
        public boolean wordPattern(String pattern, String teststr) {
            
            String[] arr = teststr.split(" ");
            Map<String, Character> map1 = new HashMap<>();
            Map<Character, String> map2 = new HashMap<>();
            
            int cursor = 0;
            for (String word : arr) {
                
                char c =  pattern.charAt(cursor++);
                
                if (map1.containsKey(word) && map2.containsKey(c)) {
                    if (map1.get(word) != c || !map2.get(c).equals(word)) return false;
                } else if (!map1.containsKey(word) && !map2.containsKey(c)) {
                    map1.put(word, c);
                    map2.put(c, word);
                } else {
                    return false;
                }
                
            }
            
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        String pattern = "abba" , teststr = "dog cat cat dog";
        Out.p(new Solution().wordPattern(pattern, teststr));
        
    }

}
