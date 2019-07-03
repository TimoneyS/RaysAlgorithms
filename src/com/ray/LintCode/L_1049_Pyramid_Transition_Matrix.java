package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

Return true if we can build the pyramid all the way to the top, otherwise false.
 *
 * Example :
 *   ```
Example 1:
	Input:  bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
	Output:  true
	
	Explanation:
	We can stack the pyramid like this:
    A
   / \
  D   E
 / \ / \
X   Y   Z

	This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.

	
Example 2:
	Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
	Output:  false
	
	Explanation:
	We can't stack the pyramid to the top.
	Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D. 
	
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/pyramid-transition-matrix/description
 * @date   2019-07-03 17:37:20
 */
public class L_1049_Pyramid_Transition_Matrix {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
