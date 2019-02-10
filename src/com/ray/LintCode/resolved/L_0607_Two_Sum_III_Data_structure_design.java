package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;

import com.ray.io.Out;

/**
 * 设计实现一个 TwoSum 类，支持如下的操作：
 *      add  - 添加一个数字
 *      find - 寻找是否存在一对数字，其和为指定的value
 * @author rays1
 *
 */
public class L_0607_Two_Sum_III_Data_structure_design {
    
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
        TwoSum ts = new TwoSum();
        ts.add(1);
        ts.add(3);
        ts.add(5);
        
        Out.p(ts.find(4));
        Out.p(ts.find(7));
    }

}
