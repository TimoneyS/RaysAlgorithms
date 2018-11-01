package com.ray.algorithms.greedy;

import com.ray.util.ArrayUtil;

/**
 * �ѡ������
 * <p>
 * �ٶ�n����ļ��� S = { a1, a2, ... , an }��ÿ��� ai ����һ����ʼʱ�� si �ͽ���ʱ�� fi <br>
 * ����ݣ�� ai �� aj ��� si �� fj ����  sj �� fi,����ƻ ai �� aj ����
 * <p>
 * �������԰��ŵ�������ң�ֻҪ��֤ÿ�����ҵĻ������ݡ�Ҫ��ʹ�þ������ٵĽ��Ұ������л��
 * <p>
 * �����Ű���
 * 
 * <p>
 * �㷨��<br>
 * 
 * 
 * @author rays1
 *
 */
public class ActiveSelectorPlus {
    
    int[]     event;        // �¼�
    boolean[] isStart;      // �¼��ǿ�ʼ���ǽ���
    int[]     active;       // �¼���Ӧ�Ļ
    
    public ActiveSelectorPlus(int[] s, int[] f) {
        
        int n = s.length;
        
        event = new int[n*2];
        isStart = new boolean[n*2];
        active = new int[n*2];
        
        for (int i = 0; i < event.length; i++) {
            s[2*i] = s[i];
            s[2*i+1] = f[i];
            isStart[2*i] = true;
            active[2*i] = i; 
            active[2*i+1] = i;
        }
        
        sortEvent();
        
        
        
    }
    
    private void sortEvent() {
        
        for (int i = event.length-1; i > 0; i --) {
            for (int j = 0; j < i; j ++) {
                if (event[i] < event[i+1] && isStart[i]) {
                    eventSwap(i, i+1);
                }
            }
        }
        
    }

    private void eventSwap(int i, int j) {
        ArrayUtil.swap(event, i, j);
        ArrayUtil.swap(isStart, i, j);
        ArrayUtil.swap(active, i, j);
    }
    
}
