package com.ray.LintCode.tostudy;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      Given a matric A. The first row of matrix A is 0, 233, 2333, 23333...(i.e., A(0,0)=0,A(0,1)=233,A(0,2)=2333,A(0,3)=23333...).
 *      Besides, A(i,j)=A(i-1,j)+A(i,j-1).
 *      
 *      Given an array X with `n` integers. X[i] is A(i+1,0), (i.e., X[0] is A(1,0), X[1] is A(2,0) ...), and a positive integer m.
 *      
 *      Return the value of A(n,m) % 10000007.
 *      
 *      给出一个矩阵A，矩阵的第一行是0,233，2333,23333...(也就是说，A(0,0)=0,A(0,1)=233,A(0,2)=2333,A(0,3)=23333...)，
 *      除此之外，A(i,j)=A(i-1,j)+A(i,j-1)。
 *
 *      给出一个拥有n个整数的数组X，X[i]表示A(i+1,0)，(也就是说X[0]表示A(1,0),X[1]表示A(2,0)...),以及一个正整数m。
 *
 *      求A(n,m)%10000007的值。
 *
 * 用例：
 *      **用例1**
 *      输入: X=[1], m=1
 *      输出: 234
 *      解释:
 *      [[0,233],
 *       [1,234]]
 *      
 *      **用例2**
 *      输入: X=[0,0], m=2
 *      输出: 2799
 *      解释:
 *      [[0,233,2333],
 *       [0,233,2566],
 *       [0,233,2799]]
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/233-matrix/description
 * @date   2019-07-21 19:35:02
 */
public class L_0946_233_Matrix {

    /**
     * 
     * 假设给定的数组 X = [a, b]
     * 
     * 则矩阵的下一列是 X 存在着一个映射关系，这个关系实际上是一个矩阵乘法
     *                             
     *  | 10,  0,  0, 1 | X |23| = |     233 |
     *  | 10,  1,  0, 1 |   | a|   |   a+233 |
     *  | 10,  1,  1, 1 |   | b|   | a+b+233 |
     *  |  0,  0,  0, 1 |   | 3|   |       3 |
     *  
     *  而第二列则是在第一列的基础上继续做乘法，前面的矩阵可以称之为关系矩阵 A
     *  对于给定的数字 m，第 m 列可以通过如下运算得到
     *  
     *      ( A * ( A ... * (A * S))) = A ^ m * S 
     *  
     *  因此算法变为求矩阵的幂，矩阵的幂方法和数字的幂方法类似，利用快速幂算法可以从 O(n) 简化为O(log(n))
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        int mod = 10000007;
        
        // 计算
        public int calcTheValueOfAnm(int[] X, int m) {
            if (X.length == 0 && m == 0) {
                return 0;
            }
            if (m == 0) {
                return X[X.length - 1];
            }
            long[][] mA = new long[X.length+2][X.length+2];
            buildRelationMatrix(mA);
            mA = power(mA, m);
            
            long ans = 23 * mA[mA.length-2][0] + 3 * mA[mA.length-2][mA.length-1];
            for (int i = 1; i < mA.length-1; ++i) {
                ans = (ans + mA[mA.length-2][i] * X[i - 1] % mod)%mod;
            }
            ans %= 10000007;
            return (int)ans;
        }
        
        // 构造关系矩阵
        public void buildRelationMatrix(long[][] mA) {
            for (int i = 0; i < mA.length-1; ++i) {
                mA[i][0] = 10;
            }
            for (int i = 0; i < mA.length; ++i) {
                mA[i][mA.length-1] = 1;
            }
            for (int i = 1; i < mA.length-1; ++i) {
                for (int j = 1; j <= i; ++j) {
                    mA[i][j] = 1;
                }
            }
        }
        
        // 矩阵乘法
        public long[][] mutiply(long[][] a, long[][] b){
            long[][] temp = new long[a.length][a.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    for (int k = 0; k < a.length; k++) {
                        temp[i][j] += a[i][k] * b[k][j];
                        temp[i][j] %= mod;
                    }
                }
            }
            return temp;
        }
        
        // 矩阵求幂
        public long[][] power(long[][] mA, int a) {
            long[][] mB = new long[mA.length][mA.length];
            
            for(int i = 0; i < mA.length; ++i) {
                for(int j = 0; j < mA.length; ++j) {
                    mB[i][j] = (i == j ? 1 : 0);
                }
            }
            
            while(a > 0) {
                if((a & 1) == 1) {
                    mB = mutiply(mB, mA);
                }
                mA = mutiply(mA, mA);
                a /= 2;
            }
            return mB;
        }
        

    }
    
    public static void main(String[] args) {
        
//        int[] X= {4773,25778,20895,12687,28108,29789};
//        int m = 100000000;
               
        int[] X = {29316,1267,23239,23508,4925,14019};
        int m = 32132111;
//        
        Timer.CLICK();
        Out.p(new Solution().calcTheValueOfAnm(X, m));
        Timer.STOP();
    }

}
