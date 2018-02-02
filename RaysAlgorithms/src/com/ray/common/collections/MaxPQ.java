package com.ray.common.collections;

public interface MaxPQ<Key extends Comparable<Key>> {
    
    /**
     * ����Ԫ��
     * @param key
     */
    void insert(Key key);
    
    /**
     * ��ȡ���Ԫ��
     * @return
     */
    Key max();
    
    /**
     * ɾ�����Ԫ��
     * @return
     */
    Key delMax();
    
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
