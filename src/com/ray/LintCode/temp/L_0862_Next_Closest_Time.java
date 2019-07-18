package com.ray.LintCode.temp;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
 *      
 *      You may assume the given input string is always valid. For example, "01:34", "12:09" are valid. "1:34", "12:9" are invalid.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "19:34"
 *      Output: "19:39"
 *      Explanation:
 *        The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  
 *        It is not 19:33, because this occurs 23 hours and 59 minutes later.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "23:59"
 *      Output: "22:22"
 *      Explanation: It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/next-closest-time/description
 * @date   2019-07-11 18:38:03
 */
public class L_0862_Next_Closest_Time {

    /**
     * 考虑暴力算法 4 * 4 * 4 * 4 = 256
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String nextClosestTime(String time) {
            
            int hou = digit(time, 0) * 10 + digit(time, 1);
            int min = digit(time, 3) * 10 + digit(time, 4);
            
            Set<Integer> set = new HashSet<>();
            set.add(digit(time, 0));
            set.add(digit(time, 1));
            set.add(digit(time, 2));
            set.add(digit(time, 3));
            
            for (int i = 0; i < 24 * 60; i++) {
                
                min += 1;
                if (min >= 60) {
                    min %= 60;
                    hou ++;
                    if (hou >= 24) hou %= 24;
                }
                if (    set.contains(min/10) &&
                        set.contains(min%10) &&
                        set.contains(hou/10) &&
                        set.contains(hou%10))
                    break;
                
            }
            
            return String.format("%2s:%2s", hou, min).replace(' ', '0');
        }
        
        int digit(String time, int i) {
            return time.charAt(i)-'0';
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
