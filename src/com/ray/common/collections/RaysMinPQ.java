package com.ray.common.collections;

import static com.ray.util.RArrays.less;
import static com.ray.util.RArrays.swap;

import java.util.NoSuchElementException;
import java.util.Random;

import com.ray.util.io.Out;
import com.ray.util.Timer;

/**
 * ����ʵ�ֵ���С���ȼ�����
 * @author rays1
 *
 * @param <Key>
 */
public class RaysMinPQ<Key extends Comparable<Key>> implements MinPQ<Key> {

    public RaysMinPQ() {
        this(1);
    }
    
    @SuppressWarnings("unchecked")
    public RaysMinPQ(int capacity) {
        inner = (Key[]) new Comparable[capacity+1];
        cursor = 0;
    }
    
    @Override
    public void insert(Key key) {
        resize();
        inner[++cursor] = key;  // ��Ԫ�ط���ĩβ
        swim(cursor);           // ����Ԫ��ִ���ϸ�
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
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return inner[1];
    }

    @Override
    public Key delMin() {
        Key v = min();
        inner[1] = inner[cursor--];
        sink(1);
        return v;
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
        while(index > 1 && less(inner, index, index/2)) {     // δ������ڵ���߸��ڵ��Ԫ�رȵ�ǰԪ��С
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
            if(less(inner, childIndex+1, childIndex)) childIndex ++;  // ѡȡ�ϴ���ӽڵ������
            if(less(inner, childIndex, index)) {                      // �ӽڵ����
                swap(inner, childIndex, index);                      
                index = childIndex;
            } else {                                                  // ��ǰԪ�ش����ӽڵ�
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        MinPQ<Integer> pq = new RaysMinPQ<Integer>();
        
        int size = 20;
        Random r = new Random(42);
        
        Timer t = Timer.create();
        
        t.click();
        for (int i = 0; i < size; i++) {
            pq.insert(r.nextInt(size * 10));
        }
        t.click();
        while (!pq.isEmpty())
            Out.p(pq.delMin());
        t.stop();
    }
    
}
