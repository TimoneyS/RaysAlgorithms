package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给你两个字符串 S 和 T, 判断他们是否只差一步编辑。
 *
 * 例如：
 *      输入: s = "aDb", t = "adb" 
 *      输出: true
 *      
 *      输入: s = "ab", t = "ab" 
 *      输出: false
 *      解释:
 *      s=t ,所以他们不相差一次编辑的距离
 *
 * @author rays1
 *
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
        
        String s = "a";
        String t = "ab";
        
        Out.p(new Solution().isOneEditDistance(s, t));
        
    }

}
