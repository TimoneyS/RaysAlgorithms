package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *      
 *      (Your task is to add three dots to this string to make it a valid IP address. Return all possible IP address.)
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "25525511135"
 *      Output: ["255.255.11.135", "255.255.111.35"]
 *      Explanation: ["255.255.111.35", "255.255.11.135"] will be accepted as well.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "1116512311"
 *      Output: ["11.165.123.11","111.65.123.11"]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/restore-ip-addresses/description
 * @date   2019-07-11 18:33:00
 */
public class L_0426_Restore_IP_Addresses {

    /**
     * 常规的动态规划问题，细节是题目要求 00 010 等属于不合法ip
     * @author rays1
     *
     */
    static class Solution {
    
        public List<String> restoreIpAddresses(String s) {
            
            ArrayList<String>   rs = new ArrayList<>();
            ArrayList<String> base = new ArrayList<>();
            restoreIpAddresses(rs, base, s, 0, 4);
            
            return rs;
        }
        
        public void restoreIpAddresses(List<String> rs, List<String> base, String str, int start, int n) {
            
            if (str.length() - start < n || (str.length() - start) > n*3 ) return;
            
            if (n <= 1) {
                String ip = str.substring(start);
                
                if (!valid(ip)) return;
                
                StringBuilder sb = new StringBuilder();
                for (String s : base) {
                    sb.append(s).append('.');
                }
                sb.append(ip);
                rs.add(sb.toString());
            } else {
                for (int l = 1; l <= 3; l++) {
                    if (start + l >= str.length()) continue;
                    String ip = str.substring(start, start+l);
                    if (!valid(ip)) continue;
                    
                    base.add(ip);
                    restoreIpAddresses(rs, base, str, start+l, n-1);
                    base.remove(base.size() - 1);
                }
            }
        }
        
        public boolean valid(String ip) {
            if (ip.length() == 0 || ip.length() > 3) return false;
            if (ip.charAt(0) == '0' && ip.length() > 1) return false;
            return Integer.valueOf(ip) <= 255;
        }
    
    }
    
    public static void main(String[] args) {
        String s = "00000";
        Out.p(new Solution().restoreIpAddresses(s));
    }

}
