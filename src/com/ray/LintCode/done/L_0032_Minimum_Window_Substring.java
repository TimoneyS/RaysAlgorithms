package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定原始字符串和目标字符串，在原始字符串中寻找最小的子字符串，这个子字符串包含所有目标字符串中的字符。
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: source = "abc", target = "ac"
 *      Output: "abc"
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: source = "adobecodebanc", target = "abc"
 *      Output: "banc"
 *      Explanation: "banc" is the minimum substring of source string which contains each char of target "abc".
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input: source = "abc", target = "aa"
 *      Output: ""
 *      Explanation: No substring contains two 'a'.
 *      ```
 *
 * 挑战：
 *      O(n) time
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-window-substring/description
 * @date   2019-07-11 16:26:16
 */
public class L_0032_Minimum_Window_Substring {

    /**
     * 用一个窗口在原始字符串上滑动，当窗口内的字符串不足够时，窗口向右延申。
     * 当字符串溢出时，窗口从左侧收缩。不断的记录最小的窗口值。
     * 
     * 维护两个数组
     * 
     * cc 当前字符计数
     * ct 目标字符计数
     * 
     * 寻找一个子字符串，其计数结果 cc，对于每一个字符 c 均有 cc[c] > ct[c]
     * 目标是 寻找符合以上条件的最短的子字符串
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String minWindow(String source, String target) {
            
            int[] count = new int[255];
            int[] base = new int[255];
            int[] rightTo = new int[source.length()];
            int head = 0, tail = -1;
            
            int prev = 0;
            int remain = target.length();
            
            for (int i = 0; i < target.length(); i++) {
                base[target.charAt(i)] ++;
            }
            
            for (int i = 0; i < source.length(); i++) {
                char c = source.charAt(i);
                if (base[c] == 0) {
                    continue;
                }
                
                if (remain == target.length()) {
                    head = i;
                }
                if (count[c] < base[c]) {
                    remain --;
                    if (remain == 0) {
                        tail = i;
                        remain --;
                    }
                }                    
                
                count[c] += 1;
                rightTo[prev] = i;
                prev = i;
                
                int j = head;
                while (j < i) {
                    c = source.charAt(j);
                    if (count[c] <= base[source.charAt(j)]) {
                        break;
                    }
                    count[source.charAt(j)] --;
                    j = rightTo[j];
                }
                
                if (i-j <= tail-head) {
                    tail = i;
                    head = j;
                } else {
                    for (int k = head; k < j; k = rightTo[k]) {
                        count[source.charAt(k)] ++;
                    }
                }
                
            }
            
            return source.substring(head, tail+1);
        }
    
    }
    
    public static void main(String[] args) {
        
        String source = "absdfaabab";
        String target = "adb";
        
        Out.p(new Solution().minWindow(source, target));
        
    }

}
