package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      There are m undirected edges on the map, Each edge (x, y, w) represents the weight of position `x` to position `y` is `w`. There may be multiple paths from position `0` to position `n`. We define the risk value of a path as the maximum weight of all the edges in this path.
 *      What is the smallest risk value in all paths from position `0` to position `n`?
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Give n = `2`, m = `2`, x = `[0, 1]`, y = `[1, 2]`, w = `[1, 2]`, return `2`.
 *      Input:
 *      2
 *      2
 *      [0,1]
 *      [1,2]
 *      [1,2]
 *      Output:
 *      2
 *      
 *      Explanation:
 *      Path1: 0→1→ 2 (risk value: 2)
 *      The minimum risk value is 2.
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Give n = `3`, m = `4`, x = `[0, 0, 1, 2]`, y = `[1, 2, 3, 3]`, w = `[1, 2, 3, 4]`, return `3`.
 *      Input:
 *      3
 *      4
 *      [0,0,1,2]
 *      [1,2,3,3]
 *      [1,2,3,4]
 *      Output:
 *      3
 *      
 *      Explanation:
 *      Path1: 0→1→ 3 (risk value: 3)
 *      Path2: 0→2→ 3 (risk value: 4)
 *      The minimum risk value is 3.
 *      ```
 *      
 *      **Example 3:**
 *      ```
 *      Give n = `4`, m = `5`, x = `[0, 1, 1, 2, 3]`, y = `[1, 2, 3, 4, 4]`, w = `[3, 2, 4, 2, 1]`, return `3`.
 *      Input:
 *      4
 *      5
 *      [0,1,1,2,3]
 *      [1,2,3,4,4]
 *      [3,2,4,2,1]
 *      Output:
 *      3
 *      
 *      Explanation:
 *      Path1: 0→1→ 2 → 4 (risk value: 3)
 *      Path2: 0→1→ 3 → 4 (risk value: 4)
 *      The minimum risk value is 3.
 *      ```
 *      
 *      **Example 4:**
 *      ```
 *      Give n = `5`, m = `7`, x = `[0, 0, 1, 2, 3, 3, 4]`, y = `[1, 2, 3, 4, 4, 5, 5]`, w = `[2, 5, 3, 4, 3, 4, 1]`, return `3`.
 *      Input:
 *      5
 *      7
 *      [0,0,1,2,3,3,4]
 *      [1,2,3,4,4,5,5]
 *      [2,5,3,4,3,4,1]
 *      Output:
 *      3
 *      
 *      Explanation:
 *      Path1: 0→1→ 3 → 5 (risk value: 4)
 *      Path2: 0→1→ 3 → 4 → 5 (risk value: 3)
 *      Path3: 0→2→ 4 → 3 → 5 (risk value: 5)
 *      Path4: 0→2→ 4 → 5 (risk value: 5)
 *      The minimum risk value is 3.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-risk-path/description
 * @date   2019-07-11 18:36:40
 */
public class L_0783_Minimum_Risk_Path {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
