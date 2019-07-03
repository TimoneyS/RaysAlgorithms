package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Implement queue by circulant array. You need to support the following methods:
 *   1. `CircularQueue(n):`  initialize a circular array with size n to store elements
 *   2. `boolean isFull():`  return `true` if the array is full
 *   3. `boolean isEmpty():`  return `true` if there is no element in the array 
 *   4. `void enqueue(element):`  add an element to the queue
 *   5. `int dequeue():`  pop an element from the queue
 *
 * Example :
 *   Example 1:
```
Input:
CircularQueue(5)
isFull()
isEmpty()
enqueue(1)
enqueue(2)
dequeue()
Output:
["false","true","1"]
```

Example 2:
```
Input:
CircularQueue(5)
isFull()
isEmpty()
enqueue(1)
enqueue(2)
dequeue()
dequeue()
enqueue(1)
enqueue(2)
enqueue(3)
enqueue(4)
enqueue(5)
isFull()
dequeue()
dequeue()
dequeue()
dequeue()
dequeue()
Output:
["false","true","1","2","true","1","2","3","4","5"]
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/implement-queue-by-circular-array/description
 * @date   2019-07-03 17:35:10
 */
public class L_0955_Implement_Queue_by_Circular_Array {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
