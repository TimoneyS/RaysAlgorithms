package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Design a data structure that supports all following operations in average **O(1)** time.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input:
 *   insert(1)
 *   insert(1)
 *   insert(2)
 *   getRandom()
 *   remove(1)
 *   
 *   // Init an empty collection.
 *   RandomizedCollection collection = new RandomizedCollection();
 *   
 *   // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 *   collection.insert(1);
 *   
 *   // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 *   collection.insert(1);
 *   
 *   // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 *   collection.insert(2);
 *   
 *   // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 *   collection.getRandom();
 *   
 *   // Removes 1 from the collection, returns true. Collection now contains [1,2].
 *   collection.remove(1);
 *   
 *   // getRandom should return 1 and 2 both equally likely.
 *   collection.getRandom();
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input:
 *   insert(1)
 *   insert(1)
 *   getRandom()
 *   remove(1)
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/insert-delete-getrandom-o1-duplicates-allowed/description
 * @date   2019-07-03 17:35:08
 */
public class L_0954_Insert_Delete_GetRandom_O1_Duplicates_allowed {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
