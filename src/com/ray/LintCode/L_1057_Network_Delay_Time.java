package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   There are `N` network nodes, labelled `1` to `N`.
 *   
 *   Given `times`, a list of travel times as **directed** edges `times[i] = (u, v, w)`, where `u` is the source node, `v` is the target node, and `w` is the time it takes for a signal to travel from source to target.
 *   
 *   Now, we send a signal from a certain node `K`. How long will it take for all nodes to receive the signal? If it is impossible, return `-1`.
 *
 * Example :
 *   ```
Example 1:
	Input:  times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
	Output:  2
	
Example 2:
	Input: times = [[1,2,1],[1,2,2]], N = 2, K = 1
	Output:  1
	
	Explanation:
	Choose the shortest one.
	
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/network-delay-time/description
 * @date   2019-07-03 17:37:31
 */
public class L_1057_Network_Delay_Time {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
