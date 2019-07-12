package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      You are standing at position `0` on an infinite number line. There is a goal at position `target`.
 *      
 *      On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 *      
 *      Return the minimum number of steps required to reach the destination.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: target = 3
 *      Output: 2
 *      Explanation:
 *      On the first move we step from 0 to 1.
 *      On the second step we step from 1 to 3.
 *      ```
 *      
 *      
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: target = 2
 *      Output: 3
 *      Explanation:
 *      On the first move we step from 0 to 1.
 *      On the second move we step  from 1 to -1.
 *      On the third move we step from -1 to 2.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reach-a-number/description
 * @date   2019-07-11 18:36:49
 */
public class L_0797_Reach_a_Number {


    /**
     * 技巧性题目，灵活度较大
     * 
     * 首先一次相加直到和大于目标，比较差值，如果是偶数，说明只需要将几个数又加号变为减号（里外里2倍，所以一定是偶数），若是奇数，就要想办法制造1，减去一个奇数加上下一个偶数即可，所以如果当前n是个奇数，就需要加上下一个偶数，如果当前是个偶数就需要减去下一个奇数，加上下一个偶数
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int reachNumber(int target) {
            long t = Math.abs(target);
            long n = (long) Math.ceil((-1.0 + Math.sqrt(1 + 8.0 * t)) / 2);

            long sum = n * (n + 1) / 2;
            long diff = sum - target;
            if (diff == 0) {
                return (int)n;
            } else if (diff % 2 == 0) {
                return (int)n;
            } else if ((diff + n + 1) % 2 == 0) {
                return (int)n + 1;
            } else {
                return (int)n + 2;
            }
            
//            Set<Integer> set1 = new HashSet<>();
//            Set<Integer> set2 = new HashSet<>();
//            int n = 1;
//            set1.add(0);
//            
//            while (true) {
//                for (int i : set1) {
//                    if (i == target) return n-1;
//                    set2.add(i+n);
//                    set2.add(i-n);
//                }
//                n++;
//                
//                Set<Integer> t = set1;
//                set1 = set2;
//                set2 = t;
//                set2.clear();
//            }
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
