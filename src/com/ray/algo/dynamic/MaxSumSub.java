package com.ray.algo.dynamic;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 最大字段和问题
 * 分治法解决方案
 * @author rays1
 *
 */
public class MaxSumSub {
     
    public MaxSumSub(int[] A) {
        
        int n = A.length;
        
        int max = subsum(A, 0, n-1);
        
        Out.pf("Max = %s\n", max);
//        Out.pf("Max = %s, from %s to %s\n", max, x, y);
        
    }
    
    public int subsum(int[] a, int l, int r) {
        
        int sum = 0;
        if (l == r)
            sum = a[l] > 0 ? a[l] : 0;
        else {
            int mid = (l+r)/2;
            
            int lSum = subsum(a, l, mid);
            int rSum = subsum(a, mid + 1, r);
            
            int maxLs = 0;
            int ls = 0;
            for (int i = mid; i >= l; i --) {
                ls += a[i];
                if (ls > maxLs) maxLs = ls;
            }
            
            int maxRs = 0;
            int rs = 0;
            for (int i = mid +1; i<=r; i++) {
                rs += a[i];
                if (rs > maxRs) maxRs = rs;
            }
            
            sum += maxLs + maxRs;
            
            if (sum < lSum) sum = lSum;
            if (sum < rSum) sum = rSum;
            
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        
//        Random r = new Random(42);
//        int n = 15;
//        int[] arr = new int[n];
//        
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = r.nextInt(n) - n/5;
//        }
        
        int[] arr = {5, -7, 0, 2};
        
        Out.p(Arrays.toString(arr));
        
        new MaxSumSub(arr);
        
    }
    
}
