package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 *
 * 给定两个字符串，寻找缺失的字符串。
 * 
 * 示例
 *      输入
 *          str1 = "This is an example"
 *          str2 = "is example"
 *      输出
 *          ["This", "an"]
 * @author rays1
 *
 */
public class L_0684_Missing_String {

    /**
     * 题目不明所以，其实就是 str1 - str2
     * 不过是单词级别的减法。
     * 
     * str1 -> l1
     * str2 -> l2 
     * 
     * rs = l2 - l1
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<String> missingString(String str1, String str2) {
            
            Set<String> set = new HashSet<>(Arrays.asList(str2.split(" ")));
            List<String> rs = new ArrayList<>();
            
            for (String s : str1.split(" "))
                if (!set.contains(s)) rs.add(s);
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
