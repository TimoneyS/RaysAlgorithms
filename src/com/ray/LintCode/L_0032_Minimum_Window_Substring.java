package com.ray.LintCode;

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
            int[] leftOf = new int[source.length()];
            
            int head = 0, tail = -1;
            int cursor = 0;
            int remain = target.length(); // how many character remain that not in window 
            
            for (char c : at) ct[c] ++;
            
            for (int i = 0; i < as.length; i++) {
                char c = as[i];
                if (ct[c] > 0) {

                    if (remain == target.length()) head = i;
                    
                    if (cc[c] < ct[c]) {
                        if (remain >= 0) {
                            tail = i;
                            remain --;
                        }
                    }                    
                    
                    cc[c] += 1;
                    leftOf[cursor] = i;
                    cursor = i;
                    
                    int j = head;
                    while (j < i) {
                        if (cc[as[j]] <= ct[as[j]]) break;
                        cc[source.charAt(j)] --;
                        j = leftOf[j];
                    }
                    
                    if (i-j <= tail-head) {
                        tail = i;
                        head = j;
                    } else {
                        for (int k = head; k < j; k = leftOf[k]) cc[as[k]] ++;
                    }
                    
                    Out.sep();
                    for (int k = 0; k < cc.length; k++) {
                        if (cc[k] > 0) Out.pf("count[%s]=%s\n", (char)k, cc[k]);
                    }
                    
                    Out.pf("source[%s]=%s,head=%s,tail=%s\n", i, c, head, tail);
                    
                }
            }
            
            return source.substring(head, tail+1);
        }
    }
    
    public static void main(String[] args) {
        
        String source = "aaaaaaaaaaaabbbbbcdd";
        String target = "abcdd";
        
        Out.p(new Solution().minWindow(source, target));
        
    }

}
