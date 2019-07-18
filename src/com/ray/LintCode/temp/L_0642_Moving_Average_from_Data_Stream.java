package com.ray.LintCode.temp;

/**
 * 描述：
 *      Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      MovingAverage m = new MovingAverage(3);
 *      m.next(1) = 1 // return 1.00000
 *      m.next(10) = (1 + 10) / 2 // return 5.50000
 *      m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
 *      m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/moving-average-from-data-stream/description
 * @date   2019-07-11 18:34:42
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
        
    }

}
