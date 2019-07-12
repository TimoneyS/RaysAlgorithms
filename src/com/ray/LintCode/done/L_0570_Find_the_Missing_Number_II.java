package com.ray.LintCode.done;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Giving a string with number from 1-`n` in random order, but miss `1` number.Find that number.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: n = 20 and str = 19201234567891011121314151618
 *      Output: 17
 *      Explanation:
 *      19'20'1'2'3'4'5'6'7'8'9'10'11'12'13'14'15'16'18
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: n = 6 and str = 56412
 *      Output: 3
 *      Explanation:
 *      5'6'4'1'2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-the-missing-number-ii/description
 * @date   2019-07-11 18:34:01
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
        
        Out.p(new Solution());
        
    }

}
