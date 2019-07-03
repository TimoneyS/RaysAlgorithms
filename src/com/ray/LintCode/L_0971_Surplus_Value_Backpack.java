package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   There is a backpack with a capacity of `c`.
 *   There are `n` Class A items, the volume of the `i th` Class A item is `a[i]`, and the value of the item is the remaining capacity of the backpack after loading the item * `k1`.
 *   There are `m` Class B items, the volume of the `i th` Class B item is `b[i]`, and the value of the item is the remaining capacity of the backpack after loading the item * `k2`.
 *   Find the maximum value can be obtained.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Given k1 = `3`,k2 = `2`,c = ` 7`,n = `2`,m = `3`,a = `[4,3]`,b = `[1,3,2]`，return `23`.
 *   Input:
 *   3 2 7 2 3
 *   [4,3]
 *   [1,3,2]
 *   Output:
 *   23
 *   
 *   Explanation:
 *   2 * (7-1)+2*(6-2) + 3 * (4-3) = 23
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Given k1 = `1`,k2 = `2`,c = ` 5`,n = `1`,m = `1`,a = `[2]`,b = `[1]`，return `10`.
 *   Input:
 *   1 2 5 1 1
 *   [2]
 *   [1]
 *   Output:
 *   10
 *   
 *   Explanation:
 *   2 * (5-1)+1*(4-2) = 10
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/surplus-value-backpack/description
 * @date   2019-07-03 17:35:13
 */
public class L_0971_Surplus_Value_Backpack {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
