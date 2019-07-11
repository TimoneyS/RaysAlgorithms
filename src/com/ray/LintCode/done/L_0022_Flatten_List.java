package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ray.LintCode.util.NestedInteger;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一个列表，列表中的每个元素可能是一个列表也可能是一个整数，将这样的列表摊平为一个证数列表
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

    /**
     * 递归解法，递归解析列表，遇到元素是列表是，进入下一层递归。
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> flatten(List<NestedInteger> nestedList) {
            List<Integer> rs = new ArrayList<>();
            flatten(rs, nestedList);
            return rs;
        }

        public void flatten(List<Integer> rs, List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    rs.add(nestedInteger.getInteger());
                } else {
                    flatten(rs, nestedInteger.getList());
                }
            }
        }
    
    }
    
    /**
     * 非递归解法
     * 
     * 将列表加入栈中，依次解析栈顶的元素
     *      当元素是列表时，记录当前位置
     *      将新列表加入栈
     *      解析栈顶元素。
     * 
     * @author rays1
     *
     */
    static class Solution2 {
        
        public List<Integer> flatten(List<NestedInteger> nestedList) {
            List<Integer> rs = new ArrayList<>();
            Stack<Integer> indexStack = new Stack<>();
            Stack<List<NestedInteger>> listStack = new Stack<>();
            
            listStack.push(nestedList);
            indexStack.push(0);
            
            while (!listStack.isEmpty()) {
                
                int index = indexStack.peek();
                
                if (listStack.peek().size() > index) {
                    NestedInteger ni = listStack.peek().get(index);
                    indexStack.pop();
                    indexStack.push(index+1);
                    if (ni.isInteger()) {
                        rs.add(ni.getInteger());
                    } else {
                        indexStack.push(0);
                        listStack.push(ni.getList());
                    }
                } else {
                    listStack.pop();
                    indexStack.pop();
                }
            }
            
            return rs;
        }

    }

    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
