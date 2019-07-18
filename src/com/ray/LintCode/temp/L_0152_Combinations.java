package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;
import com.ray.util.StringUtil;
import com.ray.util.Timer;

/**
 * 描述：
 *      Given two integers `n` and `k`. Return all possible combinations of `k` numbers out of `1, 2, ... , n`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: n = 4, k = 2
 *      Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: n = 4, k = 1
 *      Output: [[1],[2],[3],[4]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/combinations/description
 * @date   2019-07-11 18:31:14
 */
public class L_0152_Combinations {

    static class Solution {
        
        public List<List<Integer>> combine(int n, int k) {
            
            return c(k, 1, n, 1);
        }
        
        public List<List<Integer>> c(int k, int start, int n, int level) {
            
            Out.pf("%sc(%s, %s, %s)\n", StringUtil.multiString("    ", level), k, start, n);
            
            List<List<Integer>> rs = null;
            if (k == 1) {
                rs = new ArrayList<>();
                for (int i = start; i <= n; i++) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    rs.add(l);
                }
            } else {
                rs = new ArrayList<>();
                List<List<Integer>> temp;
                
                // 包含起点的结果 
                temp = c(k-1, start+1, n, level + 1);
                for (List<Integer> list : temp) {
                    list.add(0, start);
                    rs.add(list);
                }
                
                // 不包含起点的结果
                if (n-start+1 >= k) {
                    temp = c(k, start+1, n, level + 1);
                    for (List<Integer> list : temp) {
                        rs.add(list);
                    }
                }
                
            }
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        int n = 3;
        int k = 2;
        
        Timer.CLICK();
        List<List<Integer>> rs = new Solution().combine(n, k);
        Timer.STOP();
        Out.p(rs);
    }
}
