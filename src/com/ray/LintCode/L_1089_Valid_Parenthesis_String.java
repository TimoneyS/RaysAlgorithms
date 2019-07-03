package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

1. Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
2. Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
3. Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
4. `'*'` could be treated as a single right parenthesis `')'` or a single left parenthesis `'('` or an empty string.
5. An empty string is also valid.
 *
 * Example :
 *   ```
Example 1:
	Input:  "()"
	Output:  true

	
Example 2:
	Input: "(*)"
	Output:  true
	
	Explanation:
	'*' is empty.
	
Example 3:
	Input: "(*))"
	Output: true
	
	Explanation:
	use '*' as '('.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-parenthesis-string/description
 * @date   2019-07-03 17:38:30
 */
public class L_1089_Valid_Parenthesis_String {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
