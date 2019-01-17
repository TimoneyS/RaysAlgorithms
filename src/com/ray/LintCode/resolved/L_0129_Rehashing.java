package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;

/**
 * 一个哈希表 size=3, capacity=4，结构如下：
 *          [null, 21, 14, null]
 *                 ↓   ↓
 *                 9  null
 *                 ↓
 *                null
 *  哈希算法为 key % capacity，因此 9 和 21 在同一位置
 *  将哈希表的容量调整为原来的双倍，则 size=3, capacity=8，哈希表的结构也将发生变化
 *  
 *  index:   0    1    2    3     4    5    6   7
 *  hash : [null, 9, null, null, null, 21, 14, null]
 *  
 *  设计调整算法
 *  
 * @author rays1
 *
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
