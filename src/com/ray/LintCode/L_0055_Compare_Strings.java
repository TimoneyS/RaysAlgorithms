package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 * 
 * The characters in string A and B are all Upper Case letters.
 *
 * <p>
 * 
 * For A = "ABCD", B = "ACD", return true.
 * For A = "ABCD", B = "AABC", return false.
 * 
 * @author rays1
 *
 */
public class L_0055_Compare_Strings {

    static class Solution {
        /**
         * @param A: A string
         * @param B: A string
         * @return: if string A contains all of the characters in B return true else return false
         */
        public boolean compareStrings(String A, String B) {
            if (B.length() > A.length()) return false;
            
            int n = B.length();
            boolean[] marked = new boolean[n];
            
            for (int i = 0; i < A.length(); i++) {
                for (int j = 0; j < B.length(); j++) {
                    if (!marked[j] && B.charAt(j) == A.charAt(i)) {
                        marked[j] = true;
                        n --;
                        break;
                    }
                }
            }
            if (n == 0) return true;
            return false;
        }
    }
    
    public static void main(String[] args) {
        
        String A = "ABCD";
        String B = "AABC";
        
        
        Out.p(new Solution().compareStrings(A, B));
        
    }

}
