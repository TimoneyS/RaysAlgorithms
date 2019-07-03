package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You are playing the following Flip Game with your friend: Given a string that contains only these two characters: `+` and `-`, you and your friend take turns to flip two **consecutive** `"++"` into `"--"`. The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.
 *
 * Example :
 *   **Example1**

```
Input:  s = "++++"
Output: 
[
  "--++",
  "+--+",
  "++--"
]
```

**Example2**

```
Input: s = "---+++-+++-+"
Output: 
[
	"---+++-+---+",
	"---+++---+-+",
	"---+---+++-+",
	"-----+-+++-+"
]

```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flip-game/description
 * @date   2019-07-03 17:34:21
 */
public class L_0914_Flip_Game {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
