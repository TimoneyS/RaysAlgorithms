package com.ray.LintCode.done;

import java.util.LinkedList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个数字 n，打印1到n的数字，注意：
 *          如果数字可以被3整除，打印 fizz
 *          如果数字可以被5整除，打印 buzz
 *          如果数字可以同时被3和5整除，打印 fizz buzz
 *          除此之外打印数字本身
 * 用例：
 *      如果 n = 15 返回
 *      [
 *        "1", "2", "fizz",
 *        "4", "buzz", "fizz",
 *        "7", "8", "fizz",
 *        "buzz", "11", "fizz",
 *        "13", "14", "fizz buzz"
 *      ]
 *
 * 挑战：
 *      只用一个 if 语句
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/fizz-buzz/description
 * @date   2019-07-10 21:39:13
 */
public class L_0009_Fizz_Buzz {

    static class Solution {
    
        public List<String> fizzBuzz(int n) {
            // write your code here
            
            List<String> rs = new LinkedList<String>();
            
            for (int i = 1; i <= n; i++) {
                
                boolean a = i % 3 == 0;
                boolean b = i % 5 == 0;
                
                if (a && b)
                    rs.add("fizz buzz");
                else if (a)
                    rs.add("fizz");                    
                else if (b)
                    rs.add("buzz");
                else
                    rs.add(i+"");
                
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
