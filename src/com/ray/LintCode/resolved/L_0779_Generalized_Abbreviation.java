package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 编写一个函数来生成一个单词的所有缩写。
 * 
 * 例如：
 *      word
 *      生成
 *      
 *      "word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"
 * 
 * 
 * @author rays1
 *
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
        
        String word = "word";
        Out.p(new Solution().generateAbbreviations(word));
        
    }

}
