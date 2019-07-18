package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a list of strings, you could concatenate these strings together into a loop, where for each string you could choose to reverse it or not. Among all the possible loops, you need to find the lexicographically biggest string after cutting the loop, which will make the looped string into a regular one.
 *      
 *      Specifically, to find the lexicographically biggest string, you need to experience two phases:
 *      
 *      1. Concatenate all the strings into a loop, where you can reverse some strings or not and connect them in the same order as given.
 *      2. Cut and make one breakpoint in any place of the loop, which will make the looped string into a regular one starting from the character at the cutpoint.
 *      
 *      And your job is to find the lexicographically biggest one among all the possible regular strings.
 *      
 *      Note that the string concatenation order and the direction of the loop are all left to right (i.e. the direction in which the index increases).
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: ["abc", "xyz"]
 *      Output: "zyxcba"
 *      Explanation: 
 *        You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-", 
 *        where '-' represents the looped status. 
 *        The answer string came from the fourth looped one, 
 *        where you could cut from the middle character 'a' and get "zyxcba".
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: ["awef", "eawf", "zdaeff", "awefzewaf", "awefzewaf"]
 *      Output: "zfewafewafwaezdaefffawezfewafawe"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/split-concatenated-strings/description
 * @date   2019-07-11 18:38:13
 */
public class L_0876_Split_Concatenated_Strings {


    /**
     * 用每个最大的字符切割这个单词的正向和反向，然后和其他单词的最大字典序组合。
     * 返回结果中的最大值。
     * @author rays1
     *
     */
    static class Solution {
    
        
        public String splitLoopedString(List<String> strs) {
            for (int i = 0; i < strs.size(); i++) {
                strs.set(i, max(strs.get(i)));
            }
            
            List<int[]> starts = new ArrayList<>();
            for (int i = 0; i < strs.size(); i++) {
                for (int j = 0; j < strs.get(i).length(); j++) {
                    choose(starts, strs, i, j);
                }
            }
            
            Out.p(strs);
            
            for (int[] idx : starts) Out.p(idx);
            
            String max = null;
            for (int[] idx : starts) {

                String left  = left(strs, idx[0]);
                String right = right(strs, idx[0]);
                
                String cl = strs.get(idx[0]).substring(0, idx[1]);
                String cr = strs.get(idx[0]).substring(idx[1]);
                max = max(cr + right +  left + cl, max);
                
                String rev = new StringBuilder().append(strs.get(idx[0])).reverse().toString();
                idx[1] = strs.get(idx[0]).length()-idx[1]-1;
                
                cl = rev.substring(0, idx[1]);
                cr = rev.substring(idx[1]);
                
                max = max(cr + right +  left + cl, max);                
                
            }
            return max;
        }

        private String right(List<String> strs, int idx) {
            StringBuilder sb = new StringBuilder();
            for (int i = idx+1; i < strs.size(); i++)
                sb.append(strs.get(i));
            return sb.toString();
        }

        private String left(List<String> strs, int idx) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < idx; i++)
                sb.append(strs.get(i));
            return sb.toString();
        }

        private String max(String s) {
            String rev = new StringBuilder().append(s).reverse().toString();
            if (s.compareTo(rev) < 0) return rev;
            return s;
        }
        
        private String max(String s, String s2) {
            if (s2 != null && s.compareTo(s2) < 0) return s2;
            return s;
        }
        
        void choose(List<int[]> starts, List<String> list, int i, int j) {
            char c = listChar(list, i, j);
            if (starts.size() == 0) {
                starts.add(new int[] {i, j});
            } else {
                int[] idxs = starts.get(0);
                char top   = listChar(list, idxs[0], idxs[1]); 
                if (c > top) {
                    starts.clear();
                    starts.add(new int[] {i, j});
                } else if (c == top) {
                    starts.add(new int[] {i, j});
                }
            }
        }
        
        char listChar(List<String> list, int i, int j) {
            return list.get(i).charAt(j);
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
