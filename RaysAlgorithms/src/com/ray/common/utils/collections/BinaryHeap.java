package com.ray.common.utils.collections;

import static com.ray.common.utils.ArrayUtil.*;

/**
 * <b>�����</b><br/>
 * ����ѵ�ʵ�֣�������������ʵ����ȫ������<br/>
 * ֮���ڲ����ɾ��Ԫ��ʱ���ֶ�����������״̬���ɡ�<br/>
 * ����ʵ�ֵĶ������Ĺؼ����ڣ�����Ԫ��a[k] : <br/>
 * &nbsp;���ӽڵ�Ϊa[2k]��a[2k+1]<br/>
 * &nbsp;�丸�׽ڵ�Ϊa[k/2]<br/>
 * ���ڵ��Ҷ�ӽڵ���⿼���������<br/> 
 * 
 * @author rays1
 *
 * @param <Key>
 */
public class BinaryHeap <Key extends Comparable<Key>> {
    
    private Key[] inner;            // �ڲ����飬���������
    private int   cursor;           // �α꣬��Ԫ��ָ��Ϊ0����Ԫ�غ�ָ�����һ��Ԫ��
	
	@SuppressWarnings("unchecked")
    public BinaryHeap(int size) {
		inner = (Key[]) new Comparable[size+1];
		cursor = 0;
	}
	
	/**
	 * ����Ԫ��
	 * @param v
	 */
	public void insert(Key v) {
		inner[++cursor] = v;  // ��Ԫ�ط���ĩβ
		swim(cursor);         // ����Ԫ��ִ���ϸ�
	}
	
	/**
	 * ɾ�����ڵ�
	 * @return
	 */
	public Key delete() {
		Key key = inner[1];
		inner[1] = inner[cursor--];   // ��ĩβԪ�ط��ø��ڵ�λ��
		sink(1);                      // ���µĸ��ڵ�ִ���³�
		return key;
	}

	/**
	 * �ϸ�����
	 * @param index
	 */
	private void swim(int index) {
		while(index > 1 && less(inner, index/2, index)) {     // δ������ڵ���߸��ڵ��Ԫ�رȵ�ǰԪ��С
		    swap(inner, index, index/2);                      // ������ǰԪ�غ��丸�ڵ�
		    index/=2;                                         // ��ǰԪ����������
		}
	}
	
	/**
	 * �³�����
	 * @param index
	 */
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
	
}
