package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two strings S and T, determine if they are both one edit distance apart.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: s = "aDb", t = "adb" 
 *      Output: true
 *      ```
 *      Example 2:
 *      ```
 *      Input: s = "ab", t = "ab" 
 *      Output: false
 *      Explanation:
 *      s=t ,so they aren't one edit distance apart
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/one-edit-distance/description
 * @date   2019-07-11 18:34:40
 */
public class L_0640_One_Edit_Distance {

    /**
     * 一次编辑有三种情况
     *      s 修改某个字符得到 t
     *      s 删除某个字符得到 t
     *      s 增加某个字符得到 t
     * 
     * 以上三种情况，均会有在 某个 位置 i s.charAt(i) != s.charAt(i)
     * 然后修正了这个不同的字符后，其余部分 s 和 t 完全一样
     *      1. s 在i修改
     *          s.sub(i+1) == t.sub(i+1)
     *      2. s 在i删除
     *          s.sub(i+1) = t.sub(i)
     *      3. s 在i增加
     *          s.sub(i) = t.sub(i+1)
     * 
     * 需要考虑一种特殊的情况是 s 和 t 在最后一个位置上有差异，此时无法比较该位置的元素
     * 一种简单的处理方法是将 s 和 t 都增加一个相同的字符在结果，使得需要编辑的位置总在字符内部
     * 也可以通过具体的特殊情况判断来规避。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isOneEditDistance(String s, String t) {
            s = s + "c";
            t = t + "c";
            
            for (int i = 0; i < s.length() && i < t.length(); i ++) {
                if (s.charAt(i) == t.charAt(i)) continue;
                else return equasl(s, i+1, t, i+1) || 
                        equasl(s, i, t, i+1) ||
                        equasl(s, i+1, t, i) ;
            }
            return false;
        }
        
        boolean equasl(String s, int i, String t, int j) {
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i++) != t.charAt(j++)) return false;
            }
            return i == s.length() && j == t.length();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
