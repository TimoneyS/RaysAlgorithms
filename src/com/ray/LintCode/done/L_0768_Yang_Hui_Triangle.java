package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer `n`, return the first `n-line` Yang Hui triangle.
 *      给定一个整数 n，返回前 n 行的杨辉三角。
 * 用例：
 *      **用例 1:**
 *      ```
 *      输入 : n = 4
 *      输出 :  
 *      [
 *       [1]
 *       [1,1]
 *       [1,2,1]
 *       [1,3,3,1]
 *      ]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/yang-hui-triangle/description
 * @date   2019-09-26 11:37:12
 */
public class L_0768_Yang_Hui_Triangle {

    /**
     *      1
     *     1 1
     *    1 2 1
     *   1 3 3 1
     * ---------------
     *   1
     *   1 1
     *   1 2 1
     *   1 3 3 1
     *   
     * 每一行的数字数量等于行号
     * a[i][j] = a[i-1][j-1] + a[i-i][j]
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<List<Integer>> calcYangHuisTriangle(int n) {
            
            List<List<Integer>> rs = new ArrayList<>();
            if (n != 0) {
                rs.add(Arrays.asList(new Integer[] {1}));
            }
            
            for (int i = 1; i < n; i++) {
                List<Integer> curr = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    int l = j == 0 ? 0 : rs.get(i-1).get(j-1);
                    int u = j == i ? 0 : rs.get(i-1).get(j);
                    curr.add(l+u);
                }
                rs.add(curr);
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution().calcYangHuisTriangle(7));
        
    }

}
