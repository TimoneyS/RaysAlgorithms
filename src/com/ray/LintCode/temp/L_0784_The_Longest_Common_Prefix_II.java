package com.ray.LintCode.temp;

import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` strings `dic` and a target string, output the maximum length of the longest common prefix of the target string with the given `n` strings.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: dic = ["abcba","acc","abwsf"] and target = "abse"
 *      Output: 2
 *      Explanation:
 *      The longest common prefix of “abse” and “abcba” is “ab”, and the length is 2. The longest common prefix of “abse” and “acc” is “a”, and the length is 1. The longest common prefix of “abse” and “abwsf” is “ab”, and the length is 2. max(2,1,2) = 2.
 *      ```
 *      
 *      
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: dic = ["aaa","bbb","aabb"] and target = "aaab"
 *      Output: 3
 *      Explanation:
 *      The longest common prefix of “aaab” and “aaa” is “aaa”, and the length is 3. The longest common prefix of “aaab” and "bbb" is "", and the length is 0. The longest common prefix of “aaab” and “aabb” is “aa”, and the length is 2. max(3,0,2) = 3.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/the-longest-common-prefix-ii/description
 * @date   2019-07-11 18:36:41
 */
public class L_0784_The_Longest_Common_Prefix_II {


    static class Solution {
    
        public int the_longest_common_prefix(List<String> dic, String target) {
            int rs = 0;
            for (String s : dic) {
                rs = Math.max(rs, common(s, target));
            }
            return rs;
        }

        private int common(String s, String target) {
            int i = 0;
            while (true) {
                if (i >= s.length() || i >= target.length() || s.charAt(i) != target.charAt(i))
                    break;
                i++;
            }
            return i;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
