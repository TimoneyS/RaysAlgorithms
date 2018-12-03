package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a string source and a string target, find the minimum window in source
 * which will contain all the characters in target.
 * <p>
 * For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"
 * <p>
 * Challenge: O(n)
 * 
 * @author rays1
 *
 */
public class L_0032_Minimum_Window_Substring {

    /**
     * 维护两个数组
     * 
     * cc 当前字符计数
     * ct 目标字符计数
     * 
     * 寻找一个子字符串，其计数结果 cc，对于每一个字符 c 均有 cc[c] > ct[c]
     * 目标是 寻找符合以上条件的最短的子字符串
     * 
     * 
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
        /**
         * @param source
         *            : A string
         * @param target:
         *            A string
         * @return: A string denote the minimum window, return "" if there is no
         *          such a string
         */
        public String minWindow(String source, String target) {
            
            char[] as = source.toCharArray();
            char[] at = target.toCharArray();
            
            int[] cc = new int[255]; // count current
            int[] ct = new int[255]; // count target
            int[] rightOf = new int[source.length()];
            
            int head = 0, tail = -1;
            int prev = 0;
            int remain = target.length(); // how many character remain that not in window 
            
            for (char c : at) ct[c] ++;
            
            for (int i = 0; i < as.length; i++) {
                
                if (ct[as[i]] <= 0) continue;
                
                if (remain == target.length()) head = i;
                
                if (cc[as[i]] < ct[as[i]] && remain >= 0) {
                    tail = i;
                    remain --;
                }                    
                
                cc[as[i]] ++;
                rightOf[prev] = i;
                prev = i;
                
                // current char equals head char will strike a clean operation
                if (cc[as[i]] > ct[as[i]] && as[head] == as[i]) {
                    
                    int j = head;
                    while (j < i) {
                        if (cc[as[j]] <= ct[as[j]]) break;
                        cc[source.charAt(j)] --;
                        j = rightOf[j];
                    }
                    
                    if (i-j <= tail-head) {
                        tail = i;
                        head = j;
                    } else {
                        for (int k = head; k < j; k = rightOf[k]) cc[as[k]] ++;
                    }
                    
                }
                
            }
            
            return source.substring(head, tail+1);
        }
    }
    
    public static void main(String[] args) {
        
        String source = "aaaaaaaaaaaabbbbbbbbaccccccccccccccccabc";
        String target = "abc";
        
        Out.p(new Solution().minWindow(source, target));
        
    }

}
