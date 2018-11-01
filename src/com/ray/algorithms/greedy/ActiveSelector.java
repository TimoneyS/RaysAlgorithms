package com.ray.algorithms.greedy;

import com.ray.io.Out;

/**
 * �ѡ������
 * <p>
 * �ٶ�n����ļ��� S = { a1, a2, ... , an }��ÿ��� ai ����һ����ʼʱ�� si �ͽ���ʱ�� fi <br>
 * ����ݣ�� ai �� aj ��� si �� fj ����  sj �� fi,����ƻ ai �� aj ����
 * <p>
 * ��S�������ݻ�Ӽ���
 * 
 * @author rays1
 *
 */
public class ActiveSelector {

    int[] s;
    int[] f;
    boolean[] marked;
    
    public ActiveSelector(int[] s, int[] f) {
        this.s = s;
        this.f = f;
        marked = new boolean[s.length];
        
        sortActive();
        int rs = maxSelector(0, s.length-1);
        
        Out.p(rs);
    }
    
    // ÿ��ѡ�����ʱ������Ļ��Ȼ�����������
    private int maxSelector(int i, int j) {
        marked[i] = true;
        for (int k = i; k <= j; k++)
            if (s[k] >= f[i]) return 1 + maxSelector(k, j); 
        return 0;
    }

    // ���������ʱ������
    private void sortActive() {
        for (int i = 0; i < s.length-1;  i++) {
            for (int j = 0; j < s.length-1;  j++) {
                if (f[i+1] < f[i]) swap(i, i+1);
            }    
        }
    }
    
    private void swap(int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        f[i] = f[j];
        f[j] = temp;
    }
    
    public static void main(String[] args) {
        
        int[] s = {1, 3, 0, 5, 3, 5,  6,  8,  8,  2, 12};
        int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        
        ActiveSelector as = new ActiveSelector(s, f);
        
        for (int i = 0; i < f.length; i++) {
            
            if (as.marked[i])
                Out.p(as.s[i] + " " + as.f[i]);
        }
        
        
    }

}
