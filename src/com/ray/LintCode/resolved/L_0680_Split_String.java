package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个字符串，选择在一个或者两个相邻字符后切割字符串，输出所有可能的切割方案。
 *
 * 示例：
 *      输入 123
 *      输出  [1, 2, 3], [12, 3], [1, 23]
 * @author rays1
 *
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
        
        String s = "123";
        
        Out.p(new Solution().splitString(s));
        
    }

}
