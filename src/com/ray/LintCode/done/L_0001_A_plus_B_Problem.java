package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *   编写函数实现两个数字相加
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/a-b-problem/description

 * @date   2019-07-10 00:33:13
 */
public class L_0001_A_plus_B_Problem {

    
    /**
     * 异或运算有一个别名叫做：不进位加法                       
     *      a^b 就是 a+b 之后，该进位的地方不进位的结果
     *      应该进位的位置自然是a和b里都是 1 的地方，就是 a&b ，那么 a&b << 1 就是进位之后的结果。
     *      
     *      所以：a + b = (a ^ b) + (a & b << 1) 
     * 令
     *      a' = a ^ b
     *      b' = (a & b) << 1
     *      
     *      那么 a + b = a' + b'
     *      
     * 因为进位不可能一直持续，所以b'最终会变为0，此时 a' 的值就是相加的结果。       
     * 
     * 示例：
     *      25 + 18 = 11001 + 10010
     *      
     *      11001           11001
     *    ^ 10010         & 10010
     *    -------         -------
     *      01011           10000
     *      
     *      问题转化为
     *      01011 + 100000
     *      
     *      01011           01011
     *   ^ 100000        & 100000
     *    -------         -------
     *     101011          000000
     *      
     * 结果为 101011 = 43     
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public int aplusb(int a, int b) {
            
            Out.p(Integer.toBinaryString(a));
            Out.p(Integer.toBinaryString(b));
            Out.sep();
            
            while (b != 0) {
                int temp = a ^ b;
                b = (a & b) << 1;
                a = temp;
                
                Out.p(Integer.toBinaryString(a));
                Out.p(Integer.toBinaryString(b));
                Out.sep();
            }
            return a;
        }
    
    }
    
    public static void main(String[] args) {
        
        int a = 25;
        int b = 18;
        
        Out.p(new Solution().aplusb(a, b));
        
    }

}
