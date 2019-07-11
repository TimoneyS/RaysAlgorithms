package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Design a data structure that supports all following operations in average `O(1)` time.
 *      
 *      - `insert(val)`: Inserts an item val to the set if not already present.
 *      - `remove(val)`: Removes an item val from the set if present.
 *      - `getRandom`: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * 用例：
 *      ```
 *      // Init an empty set.
 *      RandomizedSet randomSet = new RandomizedSet();
 *      
 *      // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 *      randomSet.insert(1);
 *      
 *      // Returns false as 2 does not exist in the set.
 *      randomSet.remove(2);
 *      
 *      // Inserts 2 to the set, returns true. Set now contains [1,2].
 *      randomSet.insert(2);
 *      
 *      // getRandom should return either 1 or 2 randomly.
 *      randomSet.getRandom();
 *      
 *      // Removes 1 from the set, returns true. Set now contains [2].
 *      randomSet.remove(1);
 *      
 *      // 2 was already in the set, so return false.
 *      randomSet.insert(2);
 *      
 *      // Since 2 is the only number in the set, getRandom always return 2.
 *      randomSet.getRandom();
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/insert-delete-getrandom-o1/description
 * @date   2019-07-11 18:35:10
 */
public class L_0657_Insert_Delete_GetRandom_O1 {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
