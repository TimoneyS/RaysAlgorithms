package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 *
 * 一个钟表用一个二进制显示时间，现在给定一个非负的数字 n 表示二进制的时间中 1 的数量。
 * 返回所有可能的时间。
 *
 * @author rays1
 *
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
        
        int num = 2;
        
        Out.p(new Solution().binaryTime(num));
        
    }

}
