package com.ray.LintCode;

import java.util.ArrayList;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a dictionary, find all of the longest words in the dictionary.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: {
 *      		"dog",
 *      		"google",
 *      		"facebook",
 *      		"internationalization",
 *      		"blabla"
 *      		}
 *      	Output: ["internationalization"]
 *      
 *      
 *      Example 2:
 *      	Input:  {
 *      		"like",
 *      		"love",
 *      		"hate",
 *      		"yes"		
 *      		}
 *      	Output: ["like", "love", "hate"]
 *      	
 *      
 *      ```
 *
 * 挑战：
 *      It's easy to solve it in two passes, can you do it in one pass?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-word/description
 * @date   2019-07-11 18:30:59
 */
public class L_0133_Longest_Word {

    static class Solution {
        /**
         * @param dictionary: an array of strings
         * @return: an arraylist of strings
         */
        ArrayList<String> longestWords(String[] dictionary) {
            // write your code here
            
            int wordsize=0;
            ArrayList<String> result = new ArrayList<String>();
            
            for(String s : dictionary) {
                if(s.length() > wordsize) {
                    result = new ArrayList<String>();
                    result.add(s);
                    wordsize = s.length();
                } else if(s.length() == wordsize) {
                    result.add(s);
                }
            }
            
            return result;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
