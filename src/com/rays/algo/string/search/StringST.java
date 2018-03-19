package com.rays.algo.string.search;

public interface StringST<Value> {

    /** ���ַ������ű�����ֵ�� */
    void put(String key, Value val);

    /** ��key��Ӧ��ֵ */
    Value get(String key);

    /** ɾ��key */
    void delete(String key);

    /** �������Ƿ����key */
    boolean contains(String key);

    /** ���Ƿ�Ϊ�� */
    boolean isEmpty();

    /** s��ǰ׺����ļ� */
    String longestPrefixOf(String s);

    /** ������sΪǰ׺�ļ� */
    Iterable<String> keysWithPrefix(String s);

    /** ���к�sƥ��ļ� */
    Iterable<String> keysMatch(String s);

    /** ���ر��м�ֵ�Ե����� */
    int size();

    /** �������м� */
    Iterable<String> keys();

}
