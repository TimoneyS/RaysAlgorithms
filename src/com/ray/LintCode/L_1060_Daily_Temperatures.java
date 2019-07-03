package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a list of daily `temperatures`, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list `temperatures = [73, 74, 75, 71, 69, 72, 76, 73]`, your output should be `[1, 1, 4, 2, 1, 1, 0, 0]`.
 *
 * Example :
 *   ```
Example 1:
	Input:  temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
	Output:  [1, 1, 4, 2, 1, 1, 0, 0]
	
	Explanation:
	Just find the first day after it which has higher temperatures than it.

	
Example 2:
	Input: temperatures = [50, 40, 39, 30]
	Output:  [0,0,0,0]
	
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/daily-temperatures/description
 * @date   2019-07-03 17:37:35
 */
public class L_1060_Daily_Temperatures {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
