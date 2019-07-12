package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Give a string, you can choose to split the string after one character or two adjacent characters, and make the string to be composed of only one character or two characters. Output all possible results.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: "123"
 *      Output: [["1","2","3"],["12","3"],["1","23"]]
 *      ```
 *      **Example2**
 *      ```
 *      Input: "12345"
 *      Output: [["1","23","45"],["12","3","45"],["12","34","5"],["1","2","3","45"],["1","2","34","5"],["1","23","4","5"],["12","3","4","5"],["1","2","3","4","5"]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/split-string/description
 * @date   2019-07-11 18:35:25
 */
public class L_0680_Split_String {

    /**
     * 用 dp[i] 表示到i位置的切割方案
     * 
     * dp[i] = s[i] * dp[i-1] + s[i-1, i] * dp[i-2]
     * 
     * 字符串乘方案的意思，表示将字符串加入到方案的每个已经存在的结果中
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        @SuppressWarnings("unchecked")
        public List<List<String>> splitString(String s) {
            return dp(s, s.length()-1, new List[s.length()]);
        }
        
        List<List<String>> dp(String s, int i, List<List<String>>[] dp) {
            
            if (i < 0) {
                List<List<String>> temp = new ArrayList<>();
                temp.add(new ArrayList<>());
                return temp;
            }
            
            if (dp[i] == null) {
                dp[i] = new ArrayList<>();
                
                String s1 = s.substring(i, i+1);
                List<List<String>> dp1 = dp(s, i-1, dp);
                for (List<String> l : dp1) {
                    List<String> l1 = new ArrayList<>(l);
                    l1.add(s1);
                    dp[i].add(l1);
                }
                
                if (i > 0) {
                    String s2 = i <= 0 ? s.substring(i, i+1) : s.substring(i-1, i+1);
                    List<List<String>> dp0 = dp(s, i-2, dp);
                    for (List<String> l : dp0) {
                        List<String> l1 = new ArrayList<>(l);
                        l1.add(s2);
                        dp[i].add(l1);
                    }
                }
                
            }
            return dp[i];
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
