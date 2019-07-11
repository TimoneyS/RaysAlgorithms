package com.ray.LintCode.done;

/**
 * 描述：
 *      Find the first unique character in a given string. You can assume that there is at least one unique character in the string.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: "abaccdeff"
 *      	Output:  'b'
 *      	
 *      	Explanation:
 *      	There is only one 'b' and it is the first one.
 *      
 *      
 *      Example 2:
 *      	Input: "aabccd"
 *      	Output:  'b'
 *      	
 *      	Explanation:
 *      	'b' is the first one.
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/first-unique-character-in-a-string/description
 * @date   2019-07-11 18:31:58
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
