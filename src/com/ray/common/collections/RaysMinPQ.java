package com.ray.common.collections;

/**
 * 

 * ��С���ȼ�����<br/>
 * 
 * �ڲ�ʹ�����ݱ�ʾ�Ķ������������ݣ�������������ģ��������еĸ��ڵ�һ��С�����ӽڵ㣬���Ը��ڵ�����С��Ԫ��<br/>
 * 
 *              1
 *           /     \
 *          3       3
 *        /   \   /   \
 *       4     7 6     5   
 * 
 * @author rays1
 *
 * @param <Key>
 */
public class RaysMinPQ<Key extends Comparable<Key>> implements MinPQ<Key> {

    private Key[] inner;            // �ڲ����飬���������
    private int   cursor;           // �α꣬��Ԫ��ָ��Ϊ0����Ԫ�غ�ָ�����һ��Ԫ��

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

    @Override
    public Key min() {
        if (isEmpty()) return null;
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

    /*********************
     * (��������)��������ߴ�
     *********************/
    @SuppressWarnings("unchecked")
    private void resize() {
        if (cursor+1 < inner.length) return;
        int newSize = inner.length * 2;
        Key[] temp = inner;
        inner = (Key[]) new Comparable[newSize];
        for (int i = 0; i < temp.length; i++) {
            inner[i] = temp[i];
        }
    }

    /*********************
     * (��������)�ϸ�
     *********************/
    private void swim(int index) {
        // ���ϵ����ϱȶԣ������ǰ���Ԫ�رȸ����С�򽻻�
        while(index > 1 && less(inner[index], inner[index/2])) {
            swap(inner, index, index/2);
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
            if(less(inner[childIndex+1], inner[childIndex])) childIndex ++;
            if(less(inner[childIndex], inner[index])) {
                swap(inner, childIndex, index);
                index = childIndex;
            } else {
                break;
            }
        }
    }
    
    /*********************
     * (��������)�ȶ�
     *********************/
    private  boolean less(Key a, Key b) {
        return a.compareTo(b) < 0;
    }
    
    /*********************
     * (��������)����
     *********************/
    public void swap(Key[] arr, int i, int j) {
        Key temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
