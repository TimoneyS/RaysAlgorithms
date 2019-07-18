package com.ray.LintCode.done;

import com.ray.util.Assert;

/**
 * 描述：
 *      实现函数 atoi 来将一个字符串转换为一个整数。
 *      如果字符串不能够被转换，返回 0
 *      如果值超过了整型的范围，返回  2147483647 或 -2147483648
 *
 * 用例：
 *      **用例 1**
 *      Input: "10"
 *      Output: 10

 *      **用例 2**
 *      Input: "123123123123123"
 *      Output: 2147483647
 *      Explanation: 123123123123123 > INT_MAX, so we return INT_MAX
 *      
 *      **Example 3**
 *      Input: "1.0"
 *      Output: 1
 *      Explanation: We just need to change the first vaild number
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/string-to-integer-atoi/description
 * @date   2019-07-11 18:08:12
 */
public class L_0054_String_to_Integer_atoi {

    static class Solution {
        
        public int atoi(String str) {
            
            int rs = 0;
            boolean is_neg = false;
            int cursor = 0;
            
            while (cursor < str.length()) {
                char c = str.charAt(cursor);
                if (c == ' ') {
                    cursor ++;
                } else {
                    if (c == '-') {
                        cursor++;
                        is_neg = true;
                    } else if (c == '+') {
                        cursor++;
                    }
                    break;
                }
            }
            
            while (cursor < str.length()) {
                char c = str.charAt(cursor++);
                
                if (c < 48 || c > 58) {  // 非数字 跳出循环
                    break;
                }
                
                if (is_neg) {   // 负数
                    rs = rs * 10 - (c - 48);
                    if (rs > 0) {
                        rs = Integer.MIN_VALUE;
                        break;
                    }
                } else {        // 正数
                    rs = rs * 10 + (c - 48);
                    if (rs < 0) {
                        rs = Integer.MAX_VALUE;
                        break;
                    }
                }
                
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        Assert.assertEquals(new Solution().atoi(" 2147483648"), Integer.MAX_VALUE);
        Assert.assertEquals(new Solution().atoi("-2422147483648"), Integer.MIN_VALUE);
        Assert.assertEquals(new Solution().atoi("-2422.147483648"), -2422);
    }

}
