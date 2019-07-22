package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      We have two special characters. The first character can be represented by one bit `0`. The second character can be represented by two bits (`10` or `11`).
 *      
 *      Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 *      
 *      我们有两个特殊的字符。第一个字符可以用一位 0 来表示。第二个字符可以用两位(10 或者 11)表示。
 *      现在给出一个字符串表示若干位。返回最后一个字符是否必定为一位字符。给出的字符串总是以 0 结尾。
 *      
 * 用例：
 *      **用例 1:**
 *      输入: 
 *      bits = [1, 0, 0]
 *      输出: True
 *      解释: 
 *          The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 *      
 *      **用例 2:**
 *      输入: 
 *      bits = [1, 1, 1, 0]
 *      输出: False
 *      解释: 
 *          The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/1-bit-and-2-bit-characters/description
 * @date   2019-07-22 17:39:51
 */
public class L_0973_1_bit_and_2_bit_Characters {

    /**
     * 遇到 1 就进位，如果能够遍历到最后一位，说明最后一位为单独字符。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isOneBitCharacter(int[] bits) {
            
            int i = 0;
            for (i = 0; i < bits.length; i++) {
                if (i == bits.length - 1) {
                    return true;
                }
                if (bits[i] == 1) {
                    i++;
                }
            }
            
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] bits = {1, 0, 0};
        
        Out.p(new Solution().isOneBitCharacter(bits));
        
    }

}
