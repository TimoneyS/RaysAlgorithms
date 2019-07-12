package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a watch with a binary display time and a non-negative integer n which represents the number of `1`s on a given timetable, return all possible time.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 1
 *      Output: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *      ```
 *      **Example2**
 *      ```
 *      Input: 2
 *      Output: ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","10:00","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-watch/description
 * @date   2019-07-11 18:35:42
 */
public class L_0706_Binary_Watch {


    /**
     * hour < 12, minute < 60，
     * 所以最多小时可以有 3位1，分钟可以有5位1
     * 
     * 先统计所有的位数位 n 对应的时间，然后分别相加即可
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<String> binaryTime(int num) {
            List<String> rs = new ArrayList<>();
            if (num < 0 || num > 8) return rs;
            
            Map<Integer, List<String>> hMap = new HashMap<>();
            Map<Integer, List<String>> mMap = new HashMap<>();            
            
            for (int i = 0; i < 12; i++) {
                int c = count(Integer.toBinaryString(i));
                if (!hMap.containsKey(c))
                    hMap.put(c, new ArrayList<>());
                hMap.get(c).add(i+"");
            }
            
            for (int i = 0; i < 60; i++) {
                int c = count(Integer.toBinaryString(i));
                if (!mMap.containsKey(c))
                    mMap.put(c, new ArrayList<>());
                mMap.get(c).add(i < 10 ? "0"+i : ""+i);
            }
            
            for (int i = 0; i <= 3 && i <= num; i ++) {
                if (!mMap.containsKey(num-i)) continue;
                for (String p : hMap.get(i)) {
                    for (String s : mMap.get(num-i)) {
                        rs.add(p+":"+s);
                    }
                }
            }
            
            return rs;
        }
        
        int count(String bs) {
            int c = 0;
            for (int j = 0; j < bs.length(); j++)
                if (bs.charAt(j) == '1') c++;
            return c;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
