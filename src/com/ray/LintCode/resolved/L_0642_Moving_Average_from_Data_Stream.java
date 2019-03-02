package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个数字流和一个窗口尺寸，计算窗口滑动过程中的平均数。
 *
 * 例如：
 *      MovingAverage m = new MovingAverage(3);
 *      m.next(1)  = 1                  // return 1.00000
 *      m.next(10) = (1 + 10) / 2       // return 5.50000
 *      m.next(3)  = (1 + 10 + 3) / 3   // return 4.66667
 *      m.next(5)  = (10 + 3 + 5) / 3   // return 6.00000
 *
 * @author rays1
 *
 */
public class L_0642_Moving_Average_from_Data_Stream {

    static class MovingAverage {

        int[] inner;
        int cursor = 0, size = 0;
        double sum = 0;
        
        public MovingAverage(int size) {
            inner = new int[size];
        }

        public double next(int val) {
            sum += val;
            if (size < inner.length) {
                size ++;
            } else {
                cursor = cursor % size;
                sum -= inner[cursor];
            }
            inner[cursor++] = val;
            return sum / size;
            
        }
        
    }
    
    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        Out.p(m.next(1));   // = 1 // return 1.00000
        Out.p(m.next(10));  // = (1 + 10) / 2 // return 5.50000
        Out.p(m.next(3));   // = (1 + 10 + 3) / 3 // return 4.66667
        Out.p(m.next(5));   // = (10 + 3 + 5) / 3 // return 6.00000

    }

}
