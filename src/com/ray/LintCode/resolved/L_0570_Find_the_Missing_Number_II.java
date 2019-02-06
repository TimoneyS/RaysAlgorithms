package com.ray.LintCode.resolved;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 
 * 给定一个字符串包含 1-n 之间数字，顺序随机，但是缺失了一个数字。
 * 寻找那个缺失的数字。
 *
 * 例如：
 *      n = 20, str = 19201234567891011121314151618
 *      
 *      返回 17
 *
 * @author rays1
 *
 */
public class L_0570_Find_the_Missing_Number_II {

    /**
     * 递归解法，使用一个set 保存 1 - n 的所有数
     * 
     * 向前遍历字符串，再不同的位置截断字符串会遇到的不同的的数字，每个数字可能有两种情况
     *      1. 数字在 set 中
     *          从set中移除元素，从剩下的字符串中继续寻找
     *      2. 数字不在 set 中
     *          说明该数字已经找到或者不是需要的数字，这个截断方法不合适返回 0，让上一级从其他位置截断
     *          
     *  如此进行，直到算法抵达字符串末尾，而且只剩下了一个数字，就是缺失的。        
     *          
     * @author rays1
     *
     */
    static class Solution {
    
        Set<Integer> cache;
        
        public int findMissing2(int n, String str) {
            cache = new HashSet<>();
            for (int i=1; i<=n; i++) cache.add(i);
            return helper(n, str, 0);
        }
        
        int helper(int n, String str, int start) {
            
            if (start == str.length()) {
                return cache.size() == 1 ? cache.iterator().next() : 0;
            } else {
                
                int base = 0, rs = 0;
                for (int i = start; i < str.length();i++) {
                    base = base * 10 + (str.charAt(i) - '0');
                    if (rs != 0 || base > n || base == 0) break;
                    if (!cache.contains(base)) continue;
                    cache.remove(base);
                    rs = helper(n, str, i+1);
                    cache.add(base);
                }
                return rs;
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int n = 11;
        String str = "111098765432";
        
        Out.p(new Solution().findMissing2(n, str));
        
    }

}
