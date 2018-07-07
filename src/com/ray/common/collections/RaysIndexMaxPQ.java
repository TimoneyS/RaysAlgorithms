package com.ray.common.collections;

import com.ray.io.Out;

/**
 * 

 * ��С���ȼ�����<br/>
 * 
 * �ڲ�ʹ�����ݱ�ʾ�Ķ������������ݣ�������������ģ��������еĸ��ڵ�һ��С�����ӽڵ㣬���Ը��ڵ�����С��Ԫ��<br/>
 * 
 * @author rays1
 *
 * @param <Key>
 */
public class RaysIndexMaxPQ<Key extends Comparable<Key>> {

    private int[] inner;            // ����С���ȼ��������ƣ����ﱣ��Ĳ���Ԫ�ض���Ԫ�ص�����
    private int[] heapIndex;        // �洢Ԫ�������ڶ��е�λ��  
    private Key[] keys;             // ʵ�ʴ洢Ԫ��
    private int   cursor;           // �α꣬��Ԫ��ָ��Ϊ0����Ԫ�غ�ָ�����һ��Ԫ��
    
    @SuppressWarnings("unchecked")
    public RaysIndexMaxPQ(int capacity) {
        inner = new int[capacity+1];
        heapIndex = new int[capacity]; 
        keys = (Key[]) new Comparable[capacity];
        
        for (int i = 0; i < heapIndex.length; i++) {
            heapIndex[i] = -1;
        }
        
        cursor = 0;
    }

    /**
     * Ϊ���ж�
     * @return
     */
    public boolean isEmpty() {
        return cursor == 0;
    }
    
    /**
     * �Ƿ����
     * @param i
     * @return
     */
    public boolean contains(int i) {
        return heapIndex[i] != -1;
    }
    
    /**
     * �ߴ�
     * @return
     */
    public int size() {
        return cursor;
    }

    /**
     * ����Ԫ��
     * @param index
     * @param key
     */
    public void insert(int index, Key key) {
        cursor++;

        keys[index] = key; // ��Ԫ�ط���ĩβ
        inner[cursor] = index;
        heapIndex[index] = cursor;

        swim(cursor); // ����Ԫ��ִ���ϸ�
    }

    /**
     * ��ȡ��СԪ������
     * @return
     */
    public int minIndex() {
        return inner[1];
    }
    
    /**
     * ��ȡ��СԪ��
     * @return
     */
    public Key minKey() {
        if (isEmpty()) return null;
        return keys[inner[1]];
    }

    /**
     * ɾ����СԪ�ز���������
     * @return
     */
    public int delMax() {
        int min = inner[1];
        
        inner[1] = inner[cursor--];
        sink(1);
        return min;
    }
    
    /**
     * ����������ȡԪ��
     * @param i
     * @return
     */
    public Key keyOf(int i) {
        return keys[i];
    }
    
    /**
     * �ı�������ӦԪ�أ����ܵ��¶���ѵı仯
     * @param i
     * @param key
     */
    public void changeKey(int i, Key key) {
        keys[i] = key;
        swim(heapIndex[i]);
        sink(heapIndex[i]);
    }

    /*********************
     * (��������)�ϸ�
     *********************/
    private void swim(int index) {
        
        // ���ϵ����ϱȶԣ������ǰ���Ԫ�رȸ����С�򽻻�
        while(index > 1 && less(index/2, index)) {
            swap(index, index/2);
            index = index/2;
        }
        
    }

    /*********************
     * (��������)�³�
     *********************/
    private void sink(int index) {
        // ���ϵĺ��ӽڵ��н�С���ӽڵ㽻��
        while (index * 2 <= cursor) {
            int childIndex = index*2;
            if(less(childIndex, childIndex+1)) childIndex ++;
            if(less(index, childIndex)) {
                swap(childIndex, index);
                index = childIndex;
            } else {
                break;
            }
        }
    }
    
    /*********************
     * (��������)�ȶ�
     *********************/
    private boolean less(int idx1, int idx2) {
        return keys[inner[idx1]].compareTo(keys[inner[idx2]]) < 0;
    }
    
    /*********************
     * (��������)����
     *********************/
    private void swap(int i, int j) {
        int temp = inner[i];
        inner[i] = inner[j];
        inner[j] = temp;
        // ����i��j�Ƕ�������Ԫ������Ϊ inner[i], inner[j]
        // ԭ�� heapIndex[inner[i]] = i
        // ԭ�� heapIndex[inner[j]] = j
        // �� inner[i] �� inner[j] ����λ�ú󣬵�ʽ���ܳ�������Ҫ���� heapIndex
        heapIndex[inner[i]] = i;
        heapIndex[inner[j]] = j;
        
    }
    
    public static void main(String[] args) {
        
        String[] arr = {"d", "g", "f", "a", "e", "c", "b", "h"};
        RaysIndexMaxPQ<String> pq = new RaysIndexMaxPQ<>(arr.length);
        
        
        for (int i = 0; i < arr.length; i++) {
            pq.insert(i, arr[i]);
        }
        
        while (!pq.isEmpty()) {
            int idx = pq.delMax();
            Out.p(arr[idx]);
        }
        
    }

}
