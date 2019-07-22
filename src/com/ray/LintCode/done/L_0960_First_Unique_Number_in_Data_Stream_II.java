package com.ray.LintCode.done;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      We need to implement a data structure named `DataStream`. There are `two` methods required to be implemented:
 *          1. `void add(number)` // add a new number 
 *          2. `int firstUnique()` // return first unique number
 *          
 *      我们需要实现一个叫 DataStream 的数据结构。并且这里有 两 个方法需要实现：
 *          void add(number) // 加一个新的数
 *          int firstUnique() // 返回第一个独特的数    
 *
 * 用例：
 *      用例 1:
 *      ```
 *      输入:
 *      add(1)
 *      add(2)
 *      firstUnique()
 *      add(1)
 *      firstUnique()
 *      输出:
 *      [1,2]
 *      
 *      用例 2:
 *      输入:
 *      add(1)
 *      add(2)
 *      add(3)
 *      add(4)
 *      add(5)
 *      firstUnique()
 *      add(1)
 *      firstUnique()
 *      add(2)
 *      firstUnique()
 *      add(3)
 *      firstUnique()
 *      add(4)
 *      firstUnique()
 *      add(5)
 *      add(6)
 *      firstUnique()
 *      输出:
 *      [1,2,3,4,5,6]
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.com/problem/first-unique-number-in-data-stream-ii/description
 * @date   2019-07-22 15:15:46
 */
public class L_0960_First_Unique_Number_in_Data_Stream_II {

    /**
     * 用 LinkedHashSet 保存所有唯一的元素
     * 用 HashSet 保存所有元素
     * 
     * 添加一个元素时，如果已经包含在唯一元素中，那么需要取消唯一性
     * 否则如果未包含在所有元素中，那么是新的唯一元素
     * 
     * LinkedHashSet 可以保证唯一元素的顺序。
     * 
     * @author rays1
     *
     */
    static class DataStream {
        
        LinkedHashSet<Integer> unique;
        Set<Integer> all;
        
        public DataStream(){
            unique = new LinkedHashSet<>();
            all = new HashSet<>();
        }
        
        public void add(int num) {
            
            if (unique.contains(num)) {
                unique.remove(num);
            } else if (!all.contains(num)) {
                unique.add(num);
            }
            
            all.add(num);
        }

        public int firstUnique() {
            return unique.iterator().next();
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new DataStream());
        
    }

}
