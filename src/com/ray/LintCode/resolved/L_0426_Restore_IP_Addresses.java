package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个只有数字的字符串，返回这个字符串可能组成的所有合法IP
 * 
 * 合法 IP ：
 *      1.能够组成 4 个  IP 位
 *      2.每个IP位的长度小于等于 3 大于等于 1.如果字符串小于等于3或者大于等于10，则直接判为不合法。
 *      3.长度为3的IP 第一位 <=2，如果第一位 ==2 则第二位应该 <=5，若第二位 ==5 则第三位必须 <=5
 *      
 * 如： "25525511135"
 *  [
 *      "255.255.11.135",
 *      "255.255.111.35"
 *  ]
 *
 * @author rays1
 *
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
 