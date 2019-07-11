package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a `rows x cols` screen and a sentence represented by a list of **non-empty** words, find **how many times** the given sentence can be fitted on the screen.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 *      	Output: 1
 *      	
 *      	Explanation:
 *      	I-had
 *      	apple
 *      	pie-I
 *      	had--
 *      	
 *      	The character '-' signifies an empty space on the screen.
 *      	
 *      Example 2:
 *      	Input:  rows = 2, cols = 8, sentence = ["hello", "world"]
 *      	Output:  1
 *      	
 *      	Explanation:
 *      	
 *      	hello---
 *      	world---
 *      	
 *      	The character '-' signifies an empty space on the screen.
 *      
 *      Example 3:
 *      	Input: rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
 *      	Output:  2
 *      	
 *      	Explanation:
 *      	a-bcd-
 *      	e-a---
 *      	bcd-e-
 *      
 *      	The character '-' signifies an empty space on the screen.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sentence-screen-fitting/description
 * @date   2019-07-11 18:38:21
 */
public class L_0889_Sentence_Screen_Fitting {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
