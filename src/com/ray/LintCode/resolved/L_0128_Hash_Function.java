package com.ray.LintCode.resolved;

/**
 * 
 * In data structure Hash,
 * hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero.
 * The objective of designing a hash function is to "hash" the key as unreasonable as possible.
 * A good hash function can avoid collision as less as possible.
 * A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:
 * 
 * hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE 
 *                               = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE
 *                               = 3595978 % HASH_SIZE
 * 
 * here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).
 * 
 * Given a string as a key and the size of hash table, return the hash value of this key.f
 * 
 * 实现描述的 hash 算法
 * 在哈希数据结构中，hash函数可以将一个对象转换为指定范围内的一个数字。好的哈希方法会尽可能将生成的数字均匀的分布在指定范围内。
 * 一个广泛使用的hash函数使用了魔法数字 33
 *      hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) * 33^1 + ascii(d)) % HASH_SIZE
 *                       = (97 * 33^3 + 98 * 33^2 + 99 * 33^1 +100) % HASH_SIZE
 *                       = 3595978 % HASH_SIZE
 * @author rays1
 *
 */
public class L_0128_Hash_Function {
    
    class Solution {
        public int hashCode(char[] key, int HASH_SIZE) {
            long sum = 0;
            for(int i = 0; i < key.length;i++) {
                int k = (int)(key[i]);
                sum = (sum * 33 + k) % HASH_SIZE; 
            }
            return (int)sum;
        }
    }

}
