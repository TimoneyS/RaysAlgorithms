package com.ray.LintCode.resolved;

/**
 * Ugly number is a number that only have factors 2, 3 and 5.
 * Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * <p>
 * 
 * @author rays1
 *
 */
public class L_0004_Ugly_Number {
    
    static class Solution {
        /**
         * @param n: An integer
         * @return: the nth prime number as description.
         */
        public int nthUglyNumber(int k) {
            // write your code here
                    if(k<7)
               return k;
            int t2=0,t3=0,t5=0;
            
            int[] result = new int[k];
            result[0]=1;
            for(int i=1;i<k;++i){
                result[i]= Math.min(result[t2]*2, Math.min(result[t3]*3,result[t5]*5));
                if(result[i]==result[t2]*2)
                    t2++;
                if(result[i]==result[t3]*3)
                    t3++;
                if(result[i]==result[t5]*5)
                    t5++;
            }
            return result[k-1];
        }
    }
    
}
