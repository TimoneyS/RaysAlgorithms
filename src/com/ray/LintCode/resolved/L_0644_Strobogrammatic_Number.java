package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 镜像数字是指一个数字沿中心旋转180°之后，没有任何变化。比如 "69" "88" "818" 都是镜像数字。
 * 编写算法判断某个数字是否是镜像数字。
 *
 * @author rays1
 *
 */
public class L_0644_Strobogrammatic_Number {

    static class Solution {
    
        public boolean isStrobogrammatic(String num) {
            
            int[] mirrorOf = new int[10];
            Arrays.fill(mirrorOf, -1);
            
            mirrorOf[0] = 0;
            mirrorOf[1] = 1;
            mirrorOf[6] = 9;
            mirrorOf[6] = 9;
            mirrorOf[8] = 8;
            mirrorOf[9] = 6;
            
            for (int i = 0, j = num.length()-1; i <= num.length()/2; i++, j--) {
                if (mirrorOf[num.charAt(i) - '0'] != num.charAt(j) - '0') return false;
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        String num = "818";
        
        Out.p(new Solution().isStrobogrammatic(num));
        
    }

}
