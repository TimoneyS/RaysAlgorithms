package com.ray.utils;

/**
 * <p>Table��һ�ִ洢��ֵ�Ե����ݽṹ�����Ը��ݼ�����ȡ����Ӧ��ֵ</p>
 * <p><b>Լ��</b><br>
 * 1.������Ϊ null<br>
 * 2.ֵ����Ϊ null<br>
 * 3.�������ظ�<br>
 * @author Ray
 *
 * @param <Key>  ��
 * @param <Value> ֵ
 */
public interface SymbolTable <Key extends Comparable<Key>, Value> {
	void put(Key key, Value value);
	Value get(Key key);
	Value delete(Key key);
	int size();
	
//	boolean isEmpty();
//	boolean contains(Key key);
}
