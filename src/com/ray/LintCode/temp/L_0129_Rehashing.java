package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:
 *      
 *      `size=3`, `capacity=4`
 *      
 *      	[null, 21, 14, null]
 *      	       ↓    ↓
 *      	       9   null
 *      	       ↓
 *      	      null
 *      
 *      The hash function is:
 *      
 *      	int hashcode(int key, int capacity) {
 *      	    return key % capacity;
 *      	}
 *      
 *      here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.
 *      
 *      rehashing this hash table, double the capacity, you will get:
 *      
 *      `size=3`, `capacity=8`
 *      
 *      	index:   0    1    2    3     4    5    6   7
 *      	hash : [null, 9, null, null, null, 21, 14, null]
 *      
 *      Given the original hash table, return the new hash table after rehashing .
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : [null, 21->9->null, 14->null, null]
 *      Output : [null, 9->null, null, null, null, 21->null, 14->null, null]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rehashing/description
 * @date   2019-07-11 18:30:55
 */
public class L_0129_Rehashing {

    static class Solution {
        
        public ListNode[] rehashing(ListNode[] hashTable) {

            ListNode[] newHash = new ListNode[hashTable.length*2];;
            
            for (int i = 0; i < hashTable.length; i++) {
                ListNode n = hashTable[i];
                while (n != null) {
                    addToHash(n.val, newHash);
                    n = n.next;
                }
            }
            
            return newHash;
        }
        
        public void addToHash(int key, ListNode[] newHash) {
            int index = key % newHash.length;
            
            if (index < 0) index +=  newHash.length;
            
            ListNode n = newHash[index];
            
            if (n == null) {
                newHash[index] = new ListNode(key);
            } else {
                while (n.next != null) {
                    n = n.next;
                }
                n.next = new ListNode(key);
            }
            
        }
        
    }

}
