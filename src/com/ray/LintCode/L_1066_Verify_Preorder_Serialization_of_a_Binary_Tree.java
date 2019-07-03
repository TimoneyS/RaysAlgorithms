package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

~~~~.
     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
~~~~
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 *
 * Example :
 *   ```
Example 1:
	Input:  tree = "#"
	Output:  true
	
	Explanation:
	Empty tree is legal.
	
Example 2:
	Input: tree = "9,3,4,#,#,1,#,#,2,#,6,#,#"
	Output:  true

Example 3:
	Input: tree = "1,#"
	Output:  false
	
	Explanation:
	It's not a complete tree.
	
Example 4:
	Input: tree = "9,#,#,1"
	Output:  false
	
	Explanation:
	It's not a tree.

```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/verify-preorder-serialization-of-a-binary-tree/description
 * @date   2019-07-03 17:37:45
 */
public class L_1066_Verify_Preorder_Serialization_of_a_Binary_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
