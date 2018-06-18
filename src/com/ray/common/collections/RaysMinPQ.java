package com.ray.common.collections;

import static com.ray.util.RArrays.less;
import static com.ray.util.RArrays.swap;

import java.util.NoSuchElementException;
import java.util.Random;

import com.ray.util.io.Out;
import com.ray.util.Timer;

/**
 * 个人实现的最小优先级队列
 * 
 * 内部使用数据表示的二叉树保存数据
 * 
 *              4
 *           /     \
 *          2       6
 *        /   \   /   \
 *       1     3 5     7   
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

    /*********************
     * (辅助方法)重新调整内部数组的尺寸
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

    /**************************************
     * (辅助方法)上浮操作
     * @param index
     **************************************/
    private void swim(int index) {
        int fIndex = index/2;
        while(index > 1 && less(inner, index, fIndex)) {     // 未到达根节点或者父节点的元素比当前元素小
            swap(inner, index, fIndex);                      // 交换当前元素和其父节点
            index = fIndex;                                  // 当前元素索引修正
        }
    }

    /**************************************
     * (辅助方法)下沉操作
     * @param index
     **************************************/
    private void sink(int index) {
        while (index * 2 <= cursor) {                                 // 当前索引未超过边界
            int childIndex = index*2;                                 // 子节点索引
            if(less(inner, childIndex+1, childIndex)) childIndex ++;  // 选取较大的子节点的索引
            if(less(inner, childIndex, index)) {                      // 子节点更大
                swap(inner, childIndex, index);
                index = childIndex;
            } else {                                                  // 当前元素大于子节点
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
