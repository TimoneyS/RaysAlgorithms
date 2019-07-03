package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Print a binary tree in an `m*n` 2D  string array following these rules:
 *   
 *   1. The row number `m` should be equal to the height of the given binary tree.
 *   2. The column number `n` should always be an odd number.
 *   3. The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (**left-bottom part and right-bottom part**). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 *   4. Each unused space should contain an empty string `""`.
 *   5. Print the subtrees following the same rules.
 *
 * Example :
 *   **Example 1:**

```
Input:{1,2}
    1
   /
  2
Output:
 [["", "1", ""],
  ["2", "", ""]]
```
**Example 2:**
```
Input:{1,2,3,#,4}
    1
   / \
  2   3
   \
    4
Output:
 [["", "", "", "1", "", "", ""],
  ["", "2", "", "", "", "3", ""],
  ["", "", "4", "", "", "", ""]]
```
**Example 3:**
```
Input:{1,2,5,3,#,#,#,4}
        1
       / \
      2   5
     / 
    3 
   / 
  4 
Output:
 [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/print-binary-tree/description
 * @date   2019-07-03 17:38:49
 */
public class L_1105_Print_Binary_Tree {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
