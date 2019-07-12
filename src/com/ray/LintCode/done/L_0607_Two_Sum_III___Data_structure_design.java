package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 描述：
 *      Design and implement a TwoSum class. It should support the following operations: `add` and `find`.
 *      
 *      `add` - Add the number to an internal data structure.
 *      `find` - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      add(1); add(3); add(5);
 *      find(4) // return true
 *      find(7) // return false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/two-sum-iii-data-structure-design/description
 * @date   2019-07-11 18:34:28
 */
public class L_0607_Two_Sum_III___Data_structure_design {

    /**
     * 统计字符出现的次数和字符
     * 在 set 中寻找每个 value - n
     *      如果存在且 value -n != n 或者 value - n == n 而且 n 的次数大于1 返回 true
     * 
     * @author rays1
     *
     */
    static class TwoSum {
        
        HashSet<Integer> nums  = new HashSet<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        
        public void add(int number) {
            nums.add(number);
            if (!count.containsKey(number))
                count.put(number, 0);
            count.put(number, count.get(number)+1);
        }

        public boolean find(int value) {
            for (int n : nums) {
                if (nums.contains(value-n) && !(value - n == n && count.get(n) <= 1))
                    return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        
        
    }

}
