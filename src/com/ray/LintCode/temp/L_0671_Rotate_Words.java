package com.ray.LintCode.temp;

import java.util.HashSet;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      The words are same rotate words if rotate the word to the right by loop, and get another. Count how many different rotate word sets in dictionary.
 *      
 *      E.g. picture and turepic are same rotate words.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : ["picture", "turepic", "icturep", "word", "ordw", "lint"]
 *      Output : 3
 *      Explanation : 
 *      "picture", "turepic", "icturep" are same ratote words.
 *      "word", "ordw" are same too.
 *      "lint" is the third word that different from the previous two words.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rotate-words/description
 * @date   2019-07-11 18:35:21
 */
public class L_0671_Rotate_Words {


    /**
     * 旋转单词具有传递性，每组旋转单词只需要保存一个代表即可。
     * 
     * 判断是否时单词需要一次查询，复杂度根据算法不同，在 size 和 size^2 之间
     * 这里偷懒，存储的时候使用了 s + s，这样保证所有可能的旋转单词都在这个字符串之中
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int countRotateWords(List<String> words) {
            HashSet<String> set = new HashSet<>();
            for (String word : words) {
                boolean flag = true;
                for (String s : set) {
                    if (s.indexOf(word) != -1 && s.length() == word.length() * 2) {
                        flag = false;
                        break;
                    }
                }
                if (flag)set.add(word+word);
            }
            return set.size();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
