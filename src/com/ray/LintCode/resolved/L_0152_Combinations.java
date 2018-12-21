package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;
import com.ray.util.StringUtil;
import com.ray.util.Timer;

/**
 * 1..n个数字，寻找长度为 k 的所有可能的升序排列。
 * 
 * @author rays1
 *
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
