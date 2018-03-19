package com.rays.algo.string.search;

public interface StringST<Value> {

    /** 向字符串符号表插入键值对 */
    void put(String key, Value val);

    /** 键key对应的值 */
    Value get(String key);

    /** 删除key */
    void delete(String key);

    /** 检查表重是否包含key */
    boolean contains(String key);

    /** 表是否为空 */
    boolean isEmpty();

    /** s的前缀中最长的键 */
    String longestPrefixOf(String s);

    /** 所有以s为前缀的键 */
    Iterable<String> keysWithPrefix(String s);

    /** 所有和s匹配的键 */
    Iterable<String> keysMatch(String s);

    /** 返回表中键值对的数量 */
    int size();

    /** 返回所有键 */
    Iterable<String> keys();

}
