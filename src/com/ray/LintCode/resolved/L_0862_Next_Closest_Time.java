package com.ray.LintCode.resolved;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are valid. "1:34", "12:9" are invalid.
 * 
 * 给定一个数字表示的时间，重复这些数字，生成一个最接近给定时间的新的时间。
 * 任意数字可以重复任意次。
 *
 * @author rays1
 * @url    https://www.lintcode.com/problem/next-closest-time/description
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
        
        String time = "09:59";
        Out.p(new Solution().nextClosestTime(time));
        
    }

}
