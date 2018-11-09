package com.ray.algorithms.greedy;

import com.ray.io.Out;

/**
 * 
 * ����ʵ�����ϵ�һ���㼯{ x1, x2, ... , xn}����һ����λ���ȱ����伯�ϣ��������и����ĵ㣬��Ҫ��˼�����С��
 * <br>
 * ����㷨����ü��ϣ���֤���㷨����ȷ�ԡ�
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
