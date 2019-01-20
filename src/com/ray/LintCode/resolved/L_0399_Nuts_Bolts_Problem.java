package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给出不同尺寸的 n 个螺母和 n 个螺栓，螺母和螺栓一一对应。
 *
 * @author rays1
 *
 */
public class L_0399_Nuts_Bolts_Problem {
    
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
