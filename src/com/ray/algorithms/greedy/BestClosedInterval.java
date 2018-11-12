package com.ray.algorithms.greedy;

import com.ray.io.Out;

/**
 * 
 * 对于实数线上的一个点集 X = { x1, x2, ... , xn}，求一个单位长度闭区间集合，包含所有给定的点，并要求此集合最小。
 * <br>
 * 设计算法求出该集合，并证明算法的正确性。
 * 
 * <p>
 * 算法
 * <li> 以第一个点为起点，设置闭合区间，所有在该区间内的点，都属于该集合。
 * <li> 寻找不在上述区间中的第一个顶点，重复上述过程。
 * <p>
 * 证明
 * <p>
 * 设闭区间 C，包含点 x0, ... , xi，则 xi - x0 <= 1.
 * C 必然属于点集 X 的某个最优闭区间集合。
 * <p>
 * 设点集X的最优闭区间集合的第一个闭区间为C0
 * <li>若 C0 = C 则得证明。
 * <li>若 C0 != C ，则用 C 替换 C0（因为C是从起点可达得最大区间，C0必然小于C），得到得最优解将包含 C
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
            if (intervalOf[i-1] != intervalOf[i]) Out.p();
            Out.pt(x[i] + "  ");
        }
        
    }
    
    public static void main(String[] args) {
        double[] x = {0.5, 0.7, 1.2, 1.5, 2.3, 3.7, 3.9, 4.3, 5.7};
        new BestClosedInterval(x);
    }
    
}
