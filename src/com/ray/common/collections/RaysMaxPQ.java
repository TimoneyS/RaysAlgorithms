package com.ray.common.collections;

import static com.ray.util.RArrays.less;
import static com.ray.util.RArrays.swap;

import java.util.Random;

import com.ray.util.Timer;

/**
 * ����ʵ�ֵ�������ȼ�����
 * @author rays1
 *
 * @param <Key>
 */
public class RaysMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {

    public RaysMaxPQ() {
        this(1);
    }
    
    @SuppressWarnings("unchecked")
    public RaysMaxPQ(int capacity) {
        inner = (Key[]) new Comparable[capacity+1];
        cursor = 0;
    }
    
    @Override
    public void insert(Key key) {
        resize();
        inner[++cursor] = key;  // ��Ԫ�ط���ĩβ
        swim(cursor);           // ����Ԫ��ִ���ϸ�
    }

    @Override
    public Key max() {
        return inner[1];
    }

    @Override
    public Key delMax() {
        Key v = max();
        inner[1] = inner[cursor--];
        sink(1);
        return v;
    }
    
    @SuppressWarnings("unchecked")
    public void resize() {
        if (cursor+1 < inner.length) return;
        
        int newSize = inner.length * 2;
        Key[] temp = inner;
        inner = (Key[]) new Comparable[newSize];
        for (int i = 0; i < temp.length; i++) {
            inner[i] = temp[i];
        }
    }

    @Override
    public boolean isEmpty() {
        return cursor == 0;
    }

    @Override
    public int size() {
        return cursor;
    }
    
    private Key[] inner;            // �ڲ����飬���������
    private int   cursor;           // �α꣬��Ԫ��ָ��Ϊ0����Ԫ�غ�ָ�����һ��Ԫ��
    
    /**************************************
     * (��������)�ϸ�����
     * @param index
     **************************************/
    private void swim(int index) {
        while(index > 1 && less(inner, index/2, index)) {     // δ������ڵ���߸��ڵ��Ԫ�رȵ�ǰԪ��С
            swap(inner, index, index/2);                      // ������ǰԪ�غ��丸�ڵ�
            index/=2;                                         // ��ǰԪ����������
        }
    }
    
    /**************************************
     * (��������)�³�����
     * @param index
     **************************************/
    private void sink(int index) {
        while (index * 2 <= cursor) {                                 // ��ǰ����δ�����߽�
            int childIndex = index*2;                                 // �ӽڵ�����
            if(less(inner, childIndex, childIndex+1)) childIndex ++;  // ѡȡ�ϴ���ӽڵ������
            if(less(inner, index, childIndex)) {                      // �ӽڵ����
                swap(inner, index, childIndex);                      
                index = childIndex;
            } else {                                                  // ��ǰԪ�ش����ӽڵ�
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new RaysMaxPQ<Integer>();
        
        int size = 2000000;
        Random r = new Random(42);
        
        Timer t = Timer.create();
        
        t.click();
        for (int i = 0; i < size; i++) {
            pq.insert(r.nextInt(size * 10));
        }
        t.click();
        pq.delMax();
        t.stop();
        
    }
    
}
