package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` numbers, now we need to merge `n` numbers into one number. And each time we can only select and merge two numbers a,b. Each merger needs to consume `a+b` energy. Output the minimum energy consumed by merging `n` numbers.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  [1,2,3,4]
 *      	Output:  19
 *      	
 *      	Explanation:
 *      	Merge 1,2, which consumes 3 energy, and the rest is [3,4,3]. 
 *      	Then merge 3,3, which consumes 6 energy, and the rest is [6,4].
 *      	Then merge the last two numbers, which consumes 10 energy, and a total of 19 energy was consumed.
 *      
 *      Example 2:
 *      	Input: [2,8,4,1]
 *      	Output:  25
 *      	
 *      	Explanation:
 *      	Merge 1,2, which consumes 3 energy, and the rest is [8,4,3]. 
 *      	Merge 3,4, which consumes 7 energy, and the rest is [7,8]. 
 *      	Merge the last two numbers, which consumes 15 energy, 
 *      	and a total of 25 energy was consumed. 
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/merge-number/description
 * @date   2019-07-11 18:36:46
 */
public class L_0791_Merge_Number {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
