package com.ray.LintCode.resolved;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0157_Unique_Characters {

    class Solution {
        /*
         * @param str: A string
         * @return: a boolean
         */
        public boolean isUnique(String str) {
            int[] count = new int[256];
            for (int i = 0; i < str.length(); i++) {
                if (count[str.charAt(i)] == 0)
                    count[str.charAt(i)] ++;
                else
                    return false;
            }
            return true;
        }
    }

}
