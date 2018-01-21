package com.ray.common.utils.collections;

import static com.ray.common.utils.ArrayUtil.*;

/**
 * <b>二叉堆</b><br/>
 * 二叉堆的实现，核心是用数组实现完全二叉树<br/>
 * 之后在插入和删除元素时保持二叉树堆有序状态即可。<br/>
 * 数组实现的二叉树的关键在于，对于元素a[k] : <br/>
 * &nbsp;其子节点为a[2k]和a[2k+1]<br/>
 * &nbsp;其父亲节点为a[k/2]<br/>
 * 根节点和叶子节点额外考虑特殊情况<br/> 
 * 
 * @author rays1
 *
 * @param <Key>
 */
public class BinaryHeap <Key extends Comparable<Key>> {
    
    private Key[] inner;            // 内部数组，保存二叉树
    private int   cursor;           // 游标，无元素指向为0，有元素后指向最后一个元素
	
	@SuppressWarnings("unchecked")
    public BinaryHeap(int size) {
		inner = (Key[]) new Comparable[size+1];
		cursor = 0;
	}
	
	/**
	 * 插入元素
	 * @param v
	 */
	public void insert(Key v) {
		inner[++cursor] = v;  // 新元素放入末尾
		swim(cursor);         // 对新元素执行上浮
	}
	
	/**
	 * 删除根节点
	 * @return
	 */
	public Key delete() {
		Key key = inner[1];
		inner[1] = inner[cursor--];   // 将末尾元素放置根节点位置
		sink(1);                      // 对新的根节点执行下沉
		return key;
	}

	/**
	 * 上浮操作
	 * @param index
	 */
	private void swim(int index) {
		while(index > 1 && less(inner, index/2, index)) {     // 未到达根节点或者父节点的元素比当前元素小
		    swap(inner, index, index/2);                      // 交换当前元素和其父节点
		    index/=2;                                         // 当前元素索引修正
		}
	}
	
	/**
	 * 下沉操作
	 * @param index
	 */
	private void sink(int index) {
		while (index * 2 <= cursor) {                                 // 当前索引未超过边界
			int childIndex = index*2;                                 // 子节点索引
			if(less(inner, childIndex, childIndex+1)) childIndex ++;  // 选取较大的子节点的索引
			if(less(inner, index, childIndex)) {                      // 子节点更大
			    swap(inner, index, childIndex);                      
			    index = childIndex;
			} else {                                                  // 当前元素大于子节点
			    break;
			}
		}
	}
	
}
