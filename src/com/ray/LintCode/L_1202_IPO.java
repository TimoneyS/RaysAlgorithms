package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Suppose LintCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LintCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most **k** distinct projects before the IPO. Help LintCode design the best way to maximize its total capital after finishing at most **k** distinct projects.

You are given several projects. For each project i, it has a pure profit **Pi** and a minimum capital of **Ci** is needed to start the corresponding project. Initially, you have **W** capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

To sum up, pick a list of at most **k** distinct projects from given projects to maximize your final capital, and output your final maximized capital.
 *
 * Example :
 *   **Example 1:**
```
Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1]
Output: 4
Explanation: 
Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
```

**Example 2:**
```
Input：k=1, W=0, Profits=[1,2,3], Capital=[1,1,2]
Output：0
Explanation：No project options.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/ipo/description
 * @date   2019-07-03 17:40:57
 */
public class L_1202_IPO {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
