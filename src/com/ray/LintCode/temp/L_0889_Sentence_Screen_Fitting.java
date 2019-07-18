package com.ray.LintCode.temp;

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


    /**
     * 设想一个由句子构成的字符串，然后无限循环
     * 
     * 那么用每一行切割字符串，如果切割的结束是空格，则说明可以直接切割。
     * 如果切割的结束是字符，那么则需要将结束所在的单词让出给下一行去切割。
     * 
     * 同时记录每一行切割掉的单词的字符数，最终切割的总字符 / 句子字符数 = 句子数。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int wordsTyping(String[] sentence, int rows, int cols) {
            StringBuilder sb = new StringBuilder();
            for (String s : sentence) sb.append(s).append(" ");
            String word = sb.toString();

            int len = word.length();
            int start = 0;
            for (int i = 0; i < rows; i++) {
                start += cols;
                if (word.charAt(start % len) == ' ') {
                    start ++;
                } else {
                    while (start > 0 && word.charAt(start%len) != ' ')
                        start --;
                    start++;
                }
            }
            return start /  len;
        }
    
    }
    
    public static void main(String[] args) {
        
        String[] sentence = {"bcgqp", "xlqayc", "jzsxzhu", "ycxbxpxllq", "xqhz", "xtkegmw", "rtmye", "sxszyk", "mogkdakn", "tul", "jfn", "wh", "lldk", "schxgncgw", "jfdosso", "vnmxlag", "vkfo", "pzn", "nvyhr", "cqkerpihgn", "rrlggse"};
        
        int rows = 868;
        int cols = 942;
        
        Out.p(new Solution().wordsTyping(sentence, rows, cols));
        
    }

}
