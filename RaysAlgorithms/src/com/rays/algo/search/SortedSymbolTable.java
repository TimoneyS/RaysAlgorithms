package com.rays.algo.search;

/**
 * ��Ϊ���������ͣ��ҷ��ű��м��������
 * @author rays1
 *
 * @param <Key>
 * @param <Value>
 */
public interface SortedSymbolTable <Key extends Comparable<Key>,Value> extends SymbolTable<Key, Value> {
    /**
     * ��С�ļ�
     * @return
     */
    public Key min();
    
    /**
     * ɾ����С��
     */
    public void deleteMin();
    
    /**
     * ɾ������
     */
    public void deleteMax();
    
    /**
     * ���ļ�
     * @return
     */
    public Key max();
    
    /**
     * С�ڵ���key������
     * @param key
     * @return
     */
    public Key floor(Key key);
    
    /**
     * ���ڵ���key����С��
     * @param key
     * @return
     */
    public Key ceiling(Key key);
    
    /**
     * С��key�ļ�������
     * @param key
     * @return
     */
    public int rank(Key key);
    
    /**
     * ����Ϊk�ļ�
     * @param index
     * @return
     */
    public Key select(int k);

    /**
     * lo��hi֮������м�
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(Key lo, Key hi);
}
