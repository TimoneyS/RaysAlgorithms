package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 * <p>
 * Example
 * <p>
 * <li> offset=0 => "abcdefg"
 * <li> offset=1 => "gabcdef"
 * <li> offset=2 => "fgabcde"
 * <li> offset=3 => "efgabcd"
 * <p>
 * Challenge : Rotate in-place with O(1) extra memory.
 * @author rays1
 *
 */
public class L_0008_Rotate_String {
    
    static class Solution {
        /**
         * @param str: An array of char
         * @param offset: An integer
         * @return: nothing
         */
        public void rotateString(char[] str, int offset) {
            // write your code here
            if (str.length == 0) return;
            if (offset > str.length) offset = offset % str.length;
            char[] newChar = new char[str.length];
            for (int i = 0; i < newChar.length; i++) newChar[i] = str[i];
            for (int i = 0; i < str.length; i ++)
                str[i] = newChar[(i - offset + str.length)%str.length];
        }
        
    }
    
    public static void main(String[] args) {
        
        char[] str = "cppjavapy".toCharArray(); 
        
        new Solution().rotateString(str, 25);
        
        Out.p(str);
    }
    
}
