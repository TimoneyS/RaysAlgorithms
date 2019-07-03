package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   In a 2D `grid` from (0, 0) to (N-1, N-1), every cell contains a `1`, except those cells in the given list `mines` which are `0`. What is the largest axis-aligned plus sign of `1`s contained in the grid? Return the order of the plus sign. If there is none, return 0.

An "axis-aligned plus sign of `1`s of order **k**" has some center `grid[x][y] = 1` along with 4 arms of length `k-1` going up, down, left, and right, and made of `1`s. This is demonstrated in the diagrams below. Note that there could be `0`s or `1`s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for `1`s.

**Examples of Axis-Aligned Plus Signs of Order k:**
```
Order 1:
000
010
000

Order 2:
00000
00100
01110
00100
00000

Order 3:
0000000
0001000
0001000
0111110
0001000
0001000
0000000
```
 *
 * Example :
 *   ```
Example 1:
	Input:  N = 5, mines = [[4, 2]]
	Output:  2
	
	Explanation:
	11111
	11111
	11111
	11111
	11011
	In the above grid, the largest plus sign can only be order 2.  There is more than one.

Example 2:
	Input: N = 2, mines = []
	Output:  1
	
	Explanation:
	11
	11
	So the max size of '+' is 1.
	
Example 3:
	Input: N = 1, mines = [[0,0]]
	Output:  0
	
	Explanation:
	There is no '+' in the matrix.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/largest-plus-sign/description
 * @date   2019-07-03 17:37:13
 */
public class L_1044_Largest_Plus_Sign {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
