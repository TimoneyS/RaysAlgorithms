package com.ray.util.collections;

/**
 * 

 * 最小优先级队列<br/>
 * 
 * 内部使用数据表示的二叉树保存数据，二叉树是无序的，但是所有的父节点一定小于其子节点，所以根节点是最小的元素<br/>
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

    private Key[] inner;            // 内部数组，保存二叉树
    private int   cursor;           // 游标，无元素指向为0，有元素后指向最后一个元素

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
        inner[++cursor] = key;  // 新元素放入末尾
        swim(cursor);           // 对新元素执行上浮
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

    @Override
    public boolean contains(Key key) {
        for (Key k : inner) {
            if (k ==  null) break;
            
            if (k.hashCode() == key.hashCode()) 
                return true;
        }
        return false;
    }

    /*********************
     * (辅助方法)调整数组尺寸
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
     * (辅助方法)上浮
     *********************/
    private void swim(int index) {
        // 不断的向上比对，如果当前结点元素比父结点小则交换
        while(index > 1 && less(index, index/2)) {
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
            if(less(childIndex+1, childIndex)) childIndex ++;
            if(less(childIndex, index)) {
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

}
