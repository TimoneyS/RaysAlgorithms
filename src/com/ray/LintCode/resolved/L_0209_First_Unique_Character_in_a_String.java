package com.ray.LintCode.resolved;

/**
 * Find the first unique character in a given string. You can assume that there is at least one unique character in the string.
 * 
 * 返回字符串中第一个只有出现一次的字符
 * 
 * "abaccdeff" -> 'b'
 *
 * @author rays1
 *
 */
public class L_0209_First_Unique_Character_in_a_String {

    /**
     * 无额外空间，平方级别算法
     * @author rays1
     *
     */
    static class Solution {
        public char firstUniqChar(String str) {
            for (int i = 0; i < str.length(); i++) {
                boolean flag = false;
                for (int j = 0; j < str.length(); j ++) {
                    if (i!=j&&str.charAt(i) == str.charAt(j)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return str.charAt(i);
            }
            return 'c';
        }
    }

}
