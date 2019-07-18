package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a roman numeral, convert it to an integer.
 *      
 *      The answer is guaranteed to be within the range from 1 to 3999.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "IV"
 *      Output: 4
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "XCIX"
 *      Output: 99
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/roman-to-integer/description
 * @date   2019-07-11 18:32:50
 */
public class L_0419_Roman_to_Integer {

    /**
     * 遍历字符串，将每个字符转换为罗马数字对应的10进制数字
     * 如果当前字符小于下一个字符，说明该字符属于被减的部分，则该字符对应的值设置为负数
     * 累加即可
     *
     */
    static class Solution {
    
        static Map<Character, Integer> hash = new HashMap<> ();
        
        static {
            hash.put('I', 1    );
            hash.put('V', 5    );
            hash.put('X', 10   );
            hash.put('L', 50   );
            hash.put('C', 100  );
            hash.put('D', 500  );
            hash.put('M', 1000 );
        }
        
        public int romanToInt(String s) {
            int rs = 0;
            for (int i = 0; i < s.length(); i++) {
                int val = hash.get(s.charAt(i));
                if (i < s.length() - 1 && hash.get(s.charAt(i+1)) > val)
                    val = -val;
                rs += val;
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "IV";
        
        Out.p(new Solution().romanToInt(s));
        
    }

}
