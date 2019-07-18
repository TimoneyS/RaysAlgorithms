package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.ray.LintCode.util.OutputCollector;
import com.ray.io.Out;

/**
 * 描述：
 *      Use Map Reduce to find anagrams in a given list of words.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "lint lint lnit ln"
 *      Output: 
 *        ["lint", "lint", "lnit"]
 *        ["ln"]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "ab ba cab"
 *      Output:
 *        ["ab", "ba"]
 *        ["cab"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/anagram-map-reduce/description
 * @date   2019-07-11 18:33:34
 */
public class L_0503_Anagram_Map_Reduce {

    static class Solution {
    
        
        public static class Map {
            public void map(String key, String value,
                            OutputCollector<String, String> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, String value);
                StringTokenizer tokenizer = new StringTokenizer(value);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    output.collect(new String(chars), word);
                }
            }
        }

        public static class Reduce {
            public void reduce(String key, Iterator<String> values,
                               OutputCollector<String, List<String>> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, List<String> value);
                List<String> results = new ArrayList<String>();
                while (values.hasNext()) {
                    results.add(values.next());
                }
                output.collect(key, results);
            }
                
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
