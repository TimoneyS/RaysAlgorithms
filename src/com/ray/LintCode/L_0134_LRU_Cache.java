package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      <p style="line-height: 30px;">Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:&nbsp;<code style="font-size: 13px;">get</code>&nbsp;and&nbsp;<code style="font-size: 13px;">set</code>.</p><p style="line-height: 30px;"><code style="font-size: 13px;">get(key)</code>&nbsp;- Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.<br><code style="font-size: 13px;">set(key, value)</code>&nbsp;- Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *      Finally, you need to return the data from each get</p>
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      LRUCache(2)
 *      set(2, 1)
 *      set(1, 1)
 *      get(2)
 *      set(4, 1)
 *      get(1)
 *      get(2)
 *      Output: [1,-1,1]
 *      Explanation：
 *      cache cap is 2，set(2,1)，set(1, 1)，get(2) and return 1，set(4,1) and delete (1,1)，because （1,1）is the least use，get(1) and return -1，get(2) and return 1.
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：
 *      LRUCache(1)
 *      set(2, 1)
 *      get(2)
 *      set(3, 2)
 *      get(2)
 *      get(3)
 *      Output：[1,-1,2]
 *      Explanation：
 *      cache cap is 1，set(2,1)，get(2) and return 1，set(3,2) and delete (2,1)，get(2) and return -1，get(3) and return 2.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/lru-cache/description
 * @date   2019-07-11 18:31:00
 */
public class L_0134_LRU_Cache {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
