package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 *
 * 罗马数字转换为整数
 * 
 * 参见 L_0418_Integer_to_Roman
 * 
 *
 * @author rays1
 *
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
