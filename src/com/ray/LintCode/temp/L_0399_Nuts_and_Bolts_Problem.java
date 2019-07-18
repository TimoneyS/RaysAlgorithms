package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a set of *n* nuts of different sizes and *n* bolts of different sizes. There is a one-one mapping between nuts and bolts. 
 *      
 *      Comparison of a nut to another nut or a bolt to another bolt is **not allowed**. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.  We will give you a compare function to compare nut with bolt.
 *      
 *      Using the function we give you, you are supposed to sort nuts or bolts, so that they can map in order.
 *
 * 用例：
 *      Given nuts = `['ab','bc','dd','gg']`, bolts = `['AB','GG', 'DD', 'BC']`. 
 *      
 *      Your code should find the matching of bolts and nuts. 
 *      
 *      According to the function, one of the possible return: 
 *      
 *      nuts = `['ab','bc','dd','gg']`, bolts = `['AB','BC','DD','GG']`.
 *      
 *      If we give you another compare function, the possible return is the following:
 *      
 *      nuts = `['ab','bc','dd','gg']`, bolts = `['BC','AA','DD','GG']`.
 *      
 *       So you must use the compare function that we give to do the sorting.
 *      
 *      The order of the nuts or bolts does not matter. You just need to find the matching bolt for each nut.
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/nuts-bolts-problem/description
 * @date   2019-07-11 18:32:32
 */
public class L_0399_Nuts_and_Bolts_Problem {

    public interface NBComparator {
        public int cmp(String a, String b);
    }
    
    /**
     * 题目等同于如下：
     *      一个数组A，如 [1,2,3,4,5]
     *      按某种方式打乱顺序成为 B，如：[2,5,1,4,3]
     *      按别中方式打乱顺序成为 C，如：[4,2,5,3,1]
     * 设计算法将 B 和 C 中的元素调整为 一致，限制是元素不能和自己数组中的元素比较     
     * 
     * 平方级的算法可接受的
     * 
     * 还有一种解法是，从B中寻找一个元素作为分割点，分割C中的元素，从C中寻找分割点，分割B中的元素
     * 互相快速排序
     * 复杂是是 nlogn
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
            
            for (int i = 0; i < bolts.length; i ++) {
                int j = i;
                for (; i < nuts.length; i++) {
                    if (compare.cmp(nuts[j], bolts[i]) == 0) break;
                }
                swap(nuts,i, j);
            }
            
        }
        
        void swap(String[] arr, int i, int j) {
            String t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
