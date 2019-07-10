package com.ray.LintCode;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.NestedInteger;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  [[1,1],2,[1,1]]
 *      	Output: [1,1,2,1,1]
 *      	
 *      	Explanation:
 *      	flatten it into a simply list with integers.
 *      
 *      Example 2:
 *      	Input:  [1,2,[1,2]]
 *      	Output:[1,2,1,2]
 *      	
 *      	Explanation:  
 *      	flatten it into a simply list with integers.
 *      
 *      Example 3:
 *      	Input: [4,[3,[2,[1]]]]
 *      	Output:[4,3,2,1]
 *      	
 *      	Explanation: 
 *      	flatten it into a simply list with integers.
 *      
 *      ```
 *
 * 挑战：
 *      Do it in non-recursive.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flatten-list/description
 * @date   2019-07-10 22:54:06
 */
public class L_0022_Flatten_List {

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
        
        Out.p(new Solution());
        
    }

}
