package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 
 * 格雷码是二进制数字系统，其中两个连续码元仅有一位不同。
 * 给定一个正整数，表示码元的位数，找到所有格雷码的序列。
 * 格雷码序列必须以0开头并覆盖所有2^n个整数。
 *
 * @author rays1
 *
 */
public class L_0411_Gray_Code {

    /**
     * n 位的格雷码可以从 n-1 位的格雷码以上下镜射后加上新位元的方式快速的得到
     *  如  2 位的格雷码为
     *      00
     *      01
     *      11
     *      10
     *      
     *  镜面反射之后              ->       加上新位元
     *      00                      000
     *      01                      001
     *      11                      011
     *      10                      010
     * ----------------------------------------
     *      10                      110
     *      11                      111
     *      01                      101
     *      00                      100
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> grayCode(int n) {
            List<Integer> rs = null;
            if (n == 0) {
                rs = new ArrayList<>();
                rs.add(0);
            } else {
                rs = grayCode(n-1);
                int prefix = 1 << (n-1);
                int size = rs.size();
                for (int i = 0; i < size; i++) {
                    rs.add(rs.get(size-i-1) | prefix);
                }
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 1;
        
        Out.p(new Solution().grayCode(n));
        
    }

}
