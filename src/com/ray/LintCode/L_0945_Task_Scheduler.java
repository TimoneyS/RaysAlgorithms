package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval `n` that means between two `same tasks`, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the `least` number of intervals the CPU will take to finish all the given tasks.
 *
 * Example :
 *   **Example1**

```
Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B.
```

**Example2**

```
Input: tasks = ['A','A','A','B','B','B'], n = 1
Output: 6
Explanation:
A -> B -> A -> B -> A -> B.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/task-scheduler/description
 * @date   2019-07-03 17:35:00
 */
public class L_0945_Task_Scheduler {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
