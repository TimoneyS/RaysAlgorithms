package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 返回杨辉三角的前 n 行
 * @author rays1
 *
 */
public class L_0768_Yang_Hui_Triangle {

    /**
     *    0
     *   0  1
     *  0  1  2
     * 0  1  2  3
     * 
     * i = 前 i-1 + 前i
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<List<Integer>> calcYangHuisTriangle(int n) {
            
            List<List<Integer>> rs = new ArrayList<>();
            if (n != 0) rs.add(Arrays.asList(new Integer[] {1}));
            int prevIdx = 0;
            while (prevIdx+1 < n) {
                List<Integer> curr = new ArrayList<>();
                for (int i = 0; i <= prevIdx+1; i++) {
                    int t = 0;
                    if (i > 0)        t += rs.get(prevIdx).get(i-1);
                    if (i <= prevIdx) t += rs.get(prevIdx).get(i);
                    curr.add(t);
                }
                rs.add(curr);
                prevIdx ++;
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution().calcYangHuisTriangle(1));
        
    }

}
