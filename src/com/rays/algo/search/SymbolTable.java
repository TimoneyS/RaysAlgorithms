package com.rays.algo.search;

/**
 * ���ű� API<br/>
 * һ�ִ洢��ֵ�Ե����ݽṹ�����Ը��ݼ�����ȡ����Ӧ��ֵ������һЩԼ������ :</p>
 *  1.������Ϊ null<br>
 *  2.ֵ����Ϊ null<br>
 *  3.�������ظ�<br>
 *  
 * @author rays1
 *
 * @param <Key>
 * @param <Value>
 */
public interface SymbolTable <Key, Value> {
    
    /**
     * ��ȡֵ
     * @param key
     * @return
     */
    public Value get(Key key);

    /**
     * �����ֵ��
     * @param key
     * @param value
     */
    public void put(Key key, Value value);
    
    /**
     * ɾ����ֵ��
     * @param key
     */
    public void delete(Key key);
    
    /**
     * ���ű��Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty();
    
    /**
     * �Ƿ����ĳ����ֵ��
     * @param key
     * @return
     */
    public boolean contains(Key key);
    
    /**
     * ��ֵ�Ը���
     * @return
     */
    public int size();
    
    /**
     * ��ȡ���м�
     * @return
     */
    public Iterable<Key> keys();
    
}
