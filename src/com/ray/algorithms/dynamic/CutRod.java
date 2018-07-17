package com.ray.algorithms.dynamic;

import java.util.Random;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * Serling��˾���򳤸����������и�Ϊ�̸������ۡ��и����û�гɱ�֧������˾�����ϣ��֪����ѵ��и����
 * �ٶ�����֪��Serling��˾����һ�γ�ΪiӢ��ĸ����ļ۸�Ϊpi(i=1,2,������λΪ��Ԫ)�������ĳ��Ⱦ�Ϊ��Ӣ�硣
 * 
 * һ���۸����������£�
 * 
 * -----------------------------------
 *  i  | 1  2  3  4  5  6  7  8  9 10
 * -----------------------------------
 *  Pi | 1  5  8  9 10 17 17 20 24 30
 * -----------------------------------
 * 
 * ���Ӧ������Ϊ Rn
 * 
 * ����������и��³���Ϊi��һ�Σ�Ȼ����Ҳ�ĸ��������и���ĸ������и
 * ���ʾ���Ž�Ĺ�ʽΪ
 *  Rn = max{Pi + Rn-i}
 * 
 * @author rays1
 *
 */
public class CutRod {
    
    /**
     * ���������Զ����µĶ�̬�滮�㷨
     * @author rays1
     *
     */
    static class CutRodMemorized {

        int[] R;    // ��¼����Ϊ n �ĸ������и����󳤶�
        int[] S;    // ��¼����Ϊ n �ĸ����Ӻδ���ʼ�и�
        
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

                if (R[n - i] == -1) // ������δ���
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
     * �Ե����ϵĶ�̬�滮�㷨
     * @author rays1
     *
     */
    static class CutRodBottomUp {
        
        int[] R;
        int[] S;    // ��¼����Ϊ n �ĸ����Ӻδ���ʼ�и�
        
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
    int[] S;    // ��¼����Ϊ n �ĸ����Ӻδ���ʼ�и�
    
   
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


