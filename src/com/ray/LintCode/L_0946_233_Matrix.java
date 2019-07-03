package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a matric A. The first row of matrix A is 0, 233, 2333, 23333...(i.e., A(0,0)=0,A(0,1)=233,A(0,2)=2333,A(0,3)=23333...). Besides, A(i,j)=A(i-1,j)+A(i,j-1).
 *   
 *   Given an array X with `n` integers. X[i] is A(i+1,0), (i.e., X[0] is A(1,0), X[1] is A(2,0) ...), and a positive integer m.
 *   
 *   Return the value of A(n,m) % 10000007.
 *
 * Example :
 *   **Example1**
 *   
 *   ```
 *   Input: X=[1], m=1
 *   Output: 234
 *   Explanation:
 *   [[0,233],
 *    [1,234]]
 *   ```
 *   
 *   **Example2**
 *   
 *   ```
 *   Input: X=[0,0], m=2
 *   Output: 2799
 *   Explanation:
 *   [[0,233,2333],
 *    [0,233,2566],
 *    [0,233,2799]]
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/233-matrix/description
 * @date   2019-07-03 17:35:02
 */
public class L_0946_233_Matrix {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
