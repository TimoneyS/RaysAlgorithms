package com.ray.algorithms.greedy;

import com.ray.io.Out;

/**
 * 
 * 对于实数线上的一个点集{ x1, x2, ... , xn}，求一个单位长度闭区间集合，包含所有给定的点，并要求此集合最小。
 * <br>
 * 设计算法求出该集合，并证明算法的正确性。
 * 
 * @author rays1
 *
 */
public class BestClosedInterval {

    public BestClosedInterval(double[] x) {
        
        int[] intervalOf = new int[x.length]; 
        
        double start = x[0];
        int cursor = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > start + 1) {
                start = x[i];
                cursor ++;
            }
            intervalOf[i] = cursor;
        }
        
        Out.pt(x[0] + "  ");
        for (int i = 1; i < x.length; i++) {
            if (intervalOf[i-1] != intervalOf[i])
                Out.p();
            Out.pt(x[i] + "  ");
        }
        
    }
    
    public static void main(String[] args) {
        double[] x = {0.5, 0.7, 1.2, 1.5, 2.3, 3.7, 3.9, 4.3, 5.7};
        new BestClosedInterval(x);
    }
    
}
