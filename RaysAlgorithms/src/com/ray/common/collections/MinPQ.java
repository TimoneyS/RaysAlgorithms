package com.ray.common.collections;

/**
 * ��С���ȼ�����
 * @author rays1
 *
 * @param <Key>
 */
public interface MinPQ<Key extends Comparable<Key>> {
    
    /**
     * ����Ԫ��
     * @param key
     */
    void insert(Key key);
    
    /**
     * ��ȡ��СԪ��
     * @return
     */
    Key min();
    
    /**
     * ɾ����СԪ��
     * @return
     */
    Key delMin();
    
    /**
     * �����Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();
    
    /**
     * ������Ԫ�ظ���
     * @return
     */
    int size();
    
}
