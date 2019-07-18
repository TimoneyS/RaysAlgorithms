package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个只包含字母的字符串，将其排列为小写字母在前，大写字母在后的顺序。
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  "abAcD"
 *      	Output:  "acbAD"
 *      
 *      Example 2:
 *      	Input: "ABC"
 *      	Output:  "ABC"
 *      	
 *      ```
 *
 * 挑战：
 *      一次遍历，原地排序
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sort-letters-by-case/description
 * @date   2019-07-11 18:00:46
 */
public class L_0049_Sort_Letters_by_Case {

    /**
     * 从字符串左右开始遍历，将左侧遇到的大写字母和右侧遇到的小写字母交换。
     * 直到左右指针相遇。
     * @author rays1
     *
     */
    static class Solution {
        
        public void sortLetters(char[] chars) {
            int N = chars.length;
            
            int l = 0, r = chars.length - 1;
            while (l < r) {
                while (l < N && !isUpper(chars[l])) {
                    l++;
                }
                while (r > 0 &&  isUpper(chars[r])) {
                    r--;
                }
                if (l >= r) {
                    break;
                }
                
                char t = chars[l];
                chars[l] = chars[r];
                chars[r] = t;
            }
        }
        
        private boolean isUpper(char c) {
            return c >= 'A' && c <= 'Z';
        }
        
    }
    
    public static void main(String[] args) {
        
        String s = "abAcD";
        char[] chars = s.toCharArray();
        new Solution().sortLetters(chars);
        
        Out.p(chars);
        
        
    }

}
