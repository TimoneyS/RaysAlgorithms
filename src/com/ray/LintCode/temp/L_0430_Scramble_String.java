package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string `s1`, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *      
 *      Below is one possible representation of `s1 = "great"`:
 *      
 *              great
 *             /    \
 *            gr    eat
 *           / \    /  \
 *          g   r  e   at
 *                     / \
 *                    a   t
 *      
 *      To scramble the string, we may choose any non-leaf node and swap its two children.
 *      
 *      For example, if we choose the node `"gr"` and swap its two children, it produces a scrambled string `"rgeat"`.
 *      
 *              rgeat
 *             /    \
 *            rg    eat
 *           / \    /  \
 *          r   g  e   at
 *                     / \
 *                    a   t
 *      
 *      We say that `"rgeat"` is a scrambled string of `"great"`.
 *      
 *      Similarly, if we continue to swap the children of nodes `"eat"` and `"at"`, it produces a scrambled string `"rgtae"`.
 *      
 *              rgtae
 *             /    \
 *            rg    tae
 *           / \    /  \
 *          r   g  ta  e
 *                 / \
 *                t   a
 *      
 *      We say that `"rgtae"` is a scrambled string of `"great"`.
 *      
 *      Given two strings `s1` and `s2` of the same length, determine if `s2` is a scrambled string of `s1`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: s1 = "great", s2 = "rgeat"
 *      Output: true
 *      Explanation: As described above.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: s1 = "a", s2 = "b"
 *      Output: false
 *      ```
 *
 * 挑战：
 *      O(n<sup>3</sup>) time
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/scramble-string/description
 * @date   2019-07-11 18:33:04
 */
public class L_0430_Scramble_String {


    /**
     * 字符串的生成的二叉树，其实是对字符串的一种递归划分，而交换左右结点，则是子划分区域之间的交换
     * 这种交换的本质只是原字符串字符顺序的变动，可以称这种只有顺序变动的字符串之间的关系为 约等于
     * 如：s1 的划分在某个结点 发生发生交换后，得到 s2，
     *      s1 -----[...]----
     *      s2 -----[***]----
     *      
     *      s1 约等于 s2
     *      
     * 可以看出，s1 和 s2 只有交换部分的字符顺序的差别，可以通过划分消除掉无差别的部分，算法只需要关注发生了交换的区域即可。
     * 如下：     
     *      s1  [.....]
     *      s2  [*****]
     * 通过若干次的交换 s1 变为 s2
     * 首先 s1 可以划分为两个子字符串
     *      s1 [****] [...]
     *      
     * 那么通过 s1 变换为 s2 可能有两种情况
     *      1. s1 这两个子划分发生了交换
     *          这种情况下可知  
     *          s2  [...] [****]
     *          
     *      2. s1 这两个子划分未发生交换
     *          s2  [****] [...]
     * 
     * 因此可知 若要从 s1 变换为 s2 必然存在  s1 中的某个子划分的 约等于 s2 中的某个子划分
     * 
     * 算法只要从 s1 首部开始寻找 子字符串 sub1 ，然后分别在s2从首部和尾部寻找约等于 sub1 的子字符串。  
     * 
     * 实现的较为复杂，待简化
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isScramble(String s1, String s2) {
            return isScramble(s1, 0, s1.length()-1, s2, 0, s2.length()-1);
        }
        
        
        public boolean isScramble(String str1, int s1, int t1, String str2, int s2, int t2) {
            if (t1 - s1 != t2 - s2) return false;
            
            // 去除和头部相同的字符串
            while (s1 <= t1) {
                if (str1.charAt(s1) == str2.charAt(s2))      { s1 ++; s2 ++; }
                else if (str1.charAt(s1) == str2.charAt(t2)) { s1 ++; t2 --; }
                else break;
            }
            // 去除和尾部相同的字符串
            while (t1 >= s1) {
                if (str1.charAt(t1) == str2.charAt(s2))      { t1 --; s2 ++; }
                else if (str1.charAt(t1) == str2.charAt(t2)) { t1 --; t2 --; }
                else break;
            }
            
            // 去除头尾后，尾索引 < 首索引
            if (s1 == t1+1) return true;
            
            Map<Character, Integer> hashHead = new HashMap<>();
            Map<Character, Integer> hashTail = new HashMap<>();
            int i1 = s1, i2 = s2, ir2 = t2;
            while (i1 <= t1) {
                char     c1 = str1.charAt(i1),
                        cl2 = str2.charAt(i2),
                        cr2 = str2.charAt(ir2);
                addCount(hashHead, c1,   1);
                addCount(hashHead, cl2, -1);
                addCount(hashTail, c1,   1);
                addCount(hashTail, cr2, -1);
                if (i1 - s1 + 1 > 3) break;
                if (hashTail.size() == 0 || hashHead.size() == 0) break;
                i1  ++;
                i2  ++;
                ir2 --;
            }
            
            if (i1 == t1) {
                return hashHead.size() == 0 && t1 - s1 < 3;
            }
            
            if (hashHead.size() == 0) {
                
                // 头尾对等模式
                return  isScramble(
                                str1, i1+1, t1,   // str1 后
                                str2, i2+1, t2    // str2 后
                                ) && 
                        isScramble(
                                str1, s1, i1,     // str1 前
                                str2, s2, i2      // str2 前
                                );
            } else if (hashTail.size() == 0) {
                // 头尾交换模式
                return  isScramble(
                                str1, i1+1, t1,   // str1 后
                                str2, s2, ir2-1   // str2 前                                
                                ) && 
                        isScramble(
                                str1, s1, i1,     // str1 前
                                str2, ir2, t2     // str2 后
                                );
            } else {
                return false;
            }
        }
        
        private void addCount(Map<Character, Integer> hash, char c1, int i) {
            int count = 0;
            if (i > 0) {
                count = hash.containsKey(c1) ? hash.get(c1) + 1 : 1;
            } else {
                count = hash.containsKey(c1) ? hash.get(c1) - 1 : -1;
            }
            if (count == 0) {
                hash.remove(c1);
            } else {
                hash.put(c1, count);
            }
        }

    }
    
    public static void main(String[] args) {
        
        String s1 = "abcdef";
        String s2 = "defabc";
        
        Out.p(new Solution().isScramble(s1, s2));
        
    }

}
