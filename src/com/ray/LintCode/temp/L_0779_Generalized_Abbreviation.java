package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Write a function to generate the generalized abbreviations of a word.(order does not matter)
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: 
 *      word = "word", 
 *      Output: 
 *      ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *      word = "today"
 *      Output:
 *      ["1o1a1","1o1ay","1o2y","1o3","1od1y","1od2","1oda1","1oday","2d1y","2d2","2da1","2day","3a1","3ay","4y","5","t1d1y","t1d2","t1da1","t1day","t2a1","t2ay","t3y","t4","to1a1","to1ay","to2y","to3","tod1y","tod2","toda1","today"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/generalized-abbreviation/description
 * @date   2019-07-11 18:36:37
 */
public class L_0779_Generalized_Abbreviation {

    /**
     * 
     * 单词的缩写
     *   dp(i)
     *      c[i] + dp(i+1)
     *      1 + c[i+1] + dp(i+2)
     *      2 + c[i+2] + dp(i+3)
     *      3 + c[i+3] + dp(i+4)
     *      ...
     * @author rays1
     *
     */
    static class Solution {
    
        public List<String> generateAbbreviations(String word) {
            
            @SuppressWarnings("unchecked")
            List<String>[] dp = new List[word.length()+1];
            
            dp[word.length()] = Arrays.asList(new String[] {""});
            
            for (int i = word.length()-1; i >= 0; i--) {
                dp[i] = new ArrayList<String>();
                for (String s : dp[i+1]) dp[i].add( word.charAt(i)+s);
                int ct = 1;
                for (int j = i + 1; j < word.length(); j ++) {
                    for (String s : dp[j+1]) {
                        if (j < word.length()) dp[i].add(Integer.toString(ct) + word.charAt(j) + s);
                        else                   dp[i].add(Integer.toString(ct) + s);
                    }
                    ct ++;
                }
                dp[i].add(ct+"");
            }
            
            return dp[0];
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
