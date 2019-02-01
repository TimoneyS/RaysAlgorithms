package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ray.LintCode.util.NestedInteger;
import com.ray.io.In;
import com.ray.util.Timer;

/**
 * 
 * 给定一个列表，列表的每个元素可以是一个列表或者数字，将其展开位一个简单的只有数字的列表。
 * 
 * 例如：
 *      [1,2,[1,2]]     -> [1,2,1,2]
 *      [4,[3,[2,[1]]]] -> [4,3,2,1]
 * @author rays1
 *
 */
public class L_0022_Flatten_List {
    
    /**
     * 递归解法
     */
    static class Solution {

        public List<Integer> flatten(List<NestedInteger> nestedList) {
            List<Integer> rs = new ArrayList<>();
            flatten(rs, nestedList);
            return rs;
        }

        public void flatten(List<Integer> rs, List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger())
                    rs.add(nestedInteger.getInteger());
                else
                    flatten(rs, nestedInteger.getList());
            }
        }
        
    }
    
    public static void main(String[] args) {
        Scanner sc = In.getClassPathScanner(L_0022_Flatten_List.class, "L_0022_Flatten_List.in");
        StringBuilder sb = new StringBuilder();
        
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        
        Timer.CLICK();
        NestedInteger ni = NestedInteger.build(sb.toString());
        Timer.CLICK();
        new Solution().flatten(ni.getList());
        Timer.STOP();
        
//        Out.p(li);
        
    }
    
}
