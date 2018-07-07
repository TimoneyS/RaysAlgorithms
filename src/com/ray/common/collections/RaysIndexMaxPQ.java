package com.ray.common.collections;

import com.ray.io.Out;

/**
 * 

 * 最小优先级队列<br/>
 * 
 * 内部使用数据表示的二叉树保存数据，二叉树是无序的，但是所有的父节点一定小于其子节点，所以根节点是最小的元素<br/>
 * 
 * @author rays1
 *
 * @param <Key>
 */
public class RaysIndexMaxPQ<Key extends Comparable<Key>> {

    private int[] inner;            // 和最小优先级队列类似，这里保存的不是元素而是元素的索引
    private int[] heapIndex;        // 存储元素索引在堆中的位置  
    private Key[] keys;             // 实际存储元素
    private int   cursor;           // 游标，无元素指向为0，有元素后指向最后一个元素
    
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
     * 为空判断
     * @return
     */
    public boolean isEmpty() {
        return cursor == 0;
    }
    
    /**
     * 是否包含
     * @param i
     * @return
     */
    public boolean contains(int i) {
        return heapIndex[i] != -1;
    }
    
    /**
     * 尺寸
     * @return
     */
    public int size() {
        return cursor;
    }

    /**
     * 插入元素
     * @param index
     * @param key
     */
    public void insert(int index, Key key) {
        cursor++;

        keys[index] = key; // 新元素放入末尾
        inner[cursor] = index;
        heapIndex[index] = cursor;

        swim(cursor); // 对新元素执行上浮
    }

    /**
     * 获取最小元素索引
     * @return
     */
    public int minIndex() {
        return inner[1];
    }
    
    /**
     * 获取最小元素
     * @return
     */
    public Key minKey() {
        if (isEmpty()) return null;
        return keys[inner[1]];
    }

    /**
     * 删除最小元素并返回索引
     * @return
     */
    public int delMax() {
        int min = inner[1];
        
        inner[1] = inner[cursor--];
        sink(1);
        return min;
    }
    
    /**
     * 根据索引获取元素
     * @param i
     * @return
     */
    public Key keyOf(int i) {
        return keys[i];
    }
    
    /**
     * 改变索引对应元素，可能导致二叉堆的变化
     * @param i
     * @param key
     */
    public void changeKey(int i, Key key) {
        keys[i] = key;
        swim(heapIndex[i]);
        sink(heapIndex[i]);
    }

    /*********************
     * (辅助方法)上浮
     *********************/
    private void swim(int index) {
        
        // 不断的向上比对，如果当前结点元素比父结点小则交换
        while(index > 1 && less(index/2, index)) {
            swap(index, index/2);
            index = index/2;
        }
        
    }

    /*********************
     * (辅助方法)下沉
     *********************/
    private void sink(int index) {
        // 不断的和子节点中较小的子节点交换
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
     * (辅助方法)比对
     *********************/
    private boolean less(int idx1, int idx2) {
        return keys[inner[idx1]].compareTo(keys[inner[idx2]]) < 0;
    }
    
    /*********************
     * (辅助方法)交换
     *********************/
    private void swap(int i, int j) {
        int temp = inner[i];
        inner[i] = inner[j];
        inner[j] = temp;
        // 这里i、j是堆索引，元素索引为 inner[i], inner[j]
        // 原本 heapIndex[inner[i]] = i
        // 原本 heapIndex[inner[j]] = j
        // 在 inner[i] 和 inner[j] 交换位置后，等式不能成立，需要调整 heapIndex
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
