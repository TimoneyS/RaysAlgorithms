package com.ray.algo.dynamic;

import java.util.Arrays;
import java.util.Random;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 最大子段和问题
 * @author rays1
 *
 */
public class MaxSum {
     
    public MaxSum(int[] A) {
        
        int sum = 0;
        int b = 0;
        
        int x = 0,y = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (b>0) {
                b += A[i];
            } else {
                b = A[i];
                x = i;
            }
            if (b > sum) {
                sum = b;
                y = i;
            }
        }
        
        Out.pf("Max = %s, from %s to %s\n", sum, x, y);
        
    }
    
    public static void main(String[] args) {
        
        Random r = new Random(42);
        int n = 16;
        int[] arr = new int[n];
        
        int num = 10;
        int nRate = 3;
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(num) - num/nRate;
        }
        
        Out.p(Arrays.toString(arr));
        
        Timer t = Timer.create();
        
        t.click();
        new MaxSum(arr);
        t.click();
        new MaxSumSub(arr);
        t.stop();
    }
    
}
