package com.ray.util.collections;

import java.util.Random;

import com.ray.util.Timer;

/**
 * 个人实现的最大优先级队列
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
        inner[++cursor] = key;  // 新元素放入末尾
        swim(cursor);           // 对新元素执行上浮
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
    
    private Key[] inner;            // 内部数组，保存二叉树
    private int   cursor;           // 游标，无元素指向为0，有元素后指向最后一个元素
    
    /**************************************
     * (辅助方法)上浮操作
     * @param index
     **************************************/
    private void swim(int index) {
        while(index > 1 && less(index/2, index)) {     // 未到达根节点或者父节点的元素比当前元素小
            swap(index, index/2);                      // 交换当前元素和其父节点
            index/=2;                                         // 当前元素索引修正
        }
    }
    
    /**************************************
     * (辅助方法)下沉操作
     * @param index
     **************************************/
    private void sink(int index) {
        while (index * 2 <= cursor) {                                 // 当前索引未超过边界
            int childIndex = index*2;                                 // 子节点索引
            if(less(childIndex, childIndex+1)) childIndex ++;         // 选取较大的子节点的索引
            if(less(index, childIndex)) {                             // 子节点更大
                swap(index, childIndex);                      
                index = childIndex;
            } else {                                                  // 当前元素大于子节点
                break;
            }
        }
    }
    
    /*********************
     * (辅助方法)比对
     *********************/
    private boolean less(int a, int b) {
        
        return inner[a].compareTo(inner[b]) < 0;
    }
    
    /*********************
     * (辅助方法)交换
     *********************/
    private void swap(int i, int j) {
        Key temp = inner[i];
        inner[i] = inner[j];
        inner[j] = temp;
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
