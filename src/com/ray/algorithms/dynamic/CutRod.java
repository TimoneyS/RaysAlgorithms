package com.ray.algorithms.dynamic;

import java.util.Random;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * Serling公司购买长钢条，将其切割为短钢条出售。切割工序本身没有成本支出。公司管理层希望知道最佳的切割方案。
 * 假定我们知道Serling公司出售一段长为i英寸的钢条的价格为pi(i=1,2,…，单位为美元)。钢条的长度均为整英寸。
 * 
 * 一个价格表的样例如下：
 * 
 * -----------------------------------
 *  i  | 1  2  3  4  5  6  7  8  9 10
 * -----------------------------------
 *  Pi | 1  5  8  9 10 17 17 20 24 30
 * -----------------------------------
 * 
 * 设对应的收益为 Rn
 * 
 * 将钢条左侧切割下长度为i的一段，然后对右侧的钢条进行切割，左侧的钢条则不切割。
 * 则表示最优解的公式为
 *  Rn = max{Pi + Rn-i}
 * 
 * @author rays1
 *
 */
public class CutRod {
    
    /**
     * 带备忘的自顶向下的动态规划算法
     * @author rays1
     *
     */
    static class CutRodMemorized {

        int[] R;    // 记录长度为 n 的钢铁可切割的最大长度
        int[] S;    // 记录长度为 n 的钢条从何处开始切割
        
        public CutRodMemorized(int[] P) {
            
            int n = P.length;
            
            R = new int[n+1];
            S = new int[n+1];
            for (int i = 0; i < R.length; i++) {
                R[i] = -1;
                S[i] = -1;
            }
            
            int q = cut(n, P);
            
            Out.p(q);
            print(n);
            
        }
        
        public int cut(int n, int[] P) {
            if (n == 0)
                return 0;

            for (int i = 1; i <= n; i++) {

                if (R[n - i] == -1) // 子问题未求解
                    R[n - i] = cut(n - i, P);

                if (P[i - 1] + R[n - i] > R[n]) {
                    R[n] = P[i - 1] + R[n - i];
                    S[n] = i;
                }

            }
            
            return R[n];
        }
        
        public void print(int n) {
            
            while (n > 0) {
                Out.p(S[n]);
                n = n-S[n];
            }   
            
        }
        
    }
    
    /**
     * 自底向上的动态规划算法
     * @author rays1
     *
     */
    static class CutRodBottomUp {
        
        int[] R;
        int[] S;    // 记录长度为 n 的钢条从何处开始切割
        
        public CutRodBottomUp(int[] P) {

            int n = P.length;

            R = new int[n + 1];
            S = new int[n + 1];
            R[0] = 0;

            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= i; j++) {
                    if (R[i] < P[j-1] + R[i-j]) {
                        R[i] = P[j-1] + R[i-j];
                        S[i] = j;
                    }
                }

            }
            
            Out.p(R[n]);
            print(n);
        }
        
        public void print(int n) {
            
            while (n > 0) {
                Out.p(S[n]);
                n = n-S[n];
            }
            
        }

    }
    
    int[] R;
    int[] S;    // 记录长度为 n 的钢条从何处开始切割
    
   
    public static void main(String[] args) {
        
//      int[] P = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
      
//        int[] P = { 2, 5, 5};
      
      int n = 7;
      int[] P = new int[n];
      
      P[0] = 1;
      Random r = new Random(42);
      for (int i = 1; i < P.length; i++) {
          double num = r.nextDouble() + 1;
          P[i] = (int) (i * num - i*4/7);
      }
      Out.p(P);
      
      Timer t = Timer.create();
      
      t.click();
      new CutRodMemorized(P);
      t.click();
      Out.sep();
      new CutRodBottomUp(P);
      t.stop();
      
  }
    
}


