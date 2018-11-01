package com.ray.algorithms.greedy;

import com.ray.io.Out;
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
 * �����еĻ�Ŀ�ʼ�¼��ͽ���ʱ��ŵ�һ��ʱ�����ϣ���ͬ��ʱ�俪ʼʱ��Ƚ���ʱ�俿��<br>
 * ���α���ʱ�䣬ÿ��ʱ�����Ϊһ���¼���
 * <p>
 * ��ǰ�¼������ĳ����Ŀ�ʼʱ�䣺<br>
 *  1.�����Ƿ��н��ҿ��У�Ȼ�󽫻���䵽�ý��ҡ����������æ����˵���ý����Ѿ��������˻�ҵ�ǰ�¼���δ������<br>
 *  2.���û�н��ҿ��У����·���һ������<br>
 * <p>
 * ��ǰʱ�������ĳ����Ľ���ʱ�䣺<br>
 *  1.Ѱ�һ���ڵĽ��ң�����������Ϊ���� 
 * 
 * @author rays1
 *
 */
public class ActiveSelectorPlus {
    
    int[]     eventArray;        // �¼�
    boolean[] isActiveStart;      // �¼��ǿ�ʼ���ǽ���
    int[]     eventActive;       // �¼���Ӧ�Ļ
    
    int       hallNum = 0;
    boolean[] isHallBusy;
    int[]     activeHall;       // ����ڵĽ���
    
    public ActiveSelectorPlus(int[] s, int[] f) {
        
        int n = s.length;
        
        eventArray = new int[n*2];
        isActiveStart = new boolean[n*2];
        eventActive = new int[n*2];
        
        isHallBusy = new boolean[n];
        activeHall = new int[n];
        
        for (int i = 0; i < s.length; i++) {
            eventArray[2*i] = s[i];
            eventArray[2*i+1] = f[i];
            isActiveStart[2*i] = true;
            eventActive[2*i] = i; 
            eventActive[2*i+1] = i;
        }

        sortEvent();
        
        for (int i = 0; i < eventArray.length; i++) {
            handleEvent(i);
        }
        
    }
    
    /**
     * �����¼�
     * @param event
     */
    private void handleEvent(int eventIndex) {
        
        int activeIndex = eventActive[eventIndex]; // �¼���Ӧ�Ļ
        
        if (isActiveStart[eventIndex]) {
            // �ǿ�ʼ������ҪΪ���һ�����ý���
            int hallIndex = 0;
            while (hallIndex < hallNum) {
                if (!isHallBusy[hallIndex]) break;
                hallIndex ++;
            }
            
            // û�п��еĽ��ң�������ֻҪ������+1�������϶࣬���ܼ򵥵�ʹ�� n ��Ϊ���ҵ�����Ĵ�С���Ϳ�����Ҫ��������Ȳ���
            if (hallIndex == hallNum) hallNum ++;
            activeHall[activeIndex] = hallIndex;
            isHallBusy[hallIndex] = true;
            
        } else {
            // �ǽ�����������Ҫ���ý��ҿ���
            int hallIndex = activeHall[activeIndex];
            isHallBusy[hallIndex] = false;
        }
        
    }

    private void sortEvent() {
        for (int i = 0; i < eventArray.length; i++) {
            int minIndex = ArrayUtil.indexOfMin(eventArray, i, eventArray.length - 1);
            ArrayUtil.swap(eventArray, i, minIndex);
            ArrayUtil.swap(isActiveStart, i, minIndex);
            ArrayUtil.swap(eventActive, i, minIndex);
        }
    }

    
    public static void main(String[] args) {
        
        int[] s = {1, 3, 0, 5, 3, 5,  6,  8,  8,  2, 12};
        int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        ActiveSelectorPlus asp = new ActiveSelectorPlus(s, f);
        
        Out.p(asp.activeHall);
        
    }
    
}
