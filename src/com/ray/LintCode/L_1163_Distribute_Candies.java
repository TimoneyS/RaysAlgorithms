package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
 *
 * Example :
 *   Input: candies = [1,1,2,2,3,3]
 *   Output: 3
 *   Explanation:
 *   There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 *   Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
 *   The sister has three different kinds of candies. 
 *   
 *   Input: candies = [1,1,2,3]
 *   Output: 2
 *   Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
 *   The sister has two different kinds of candies, the brother has only one kind of candies.
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/distribute-candies/description
 * @date   2019-07-03 17:39:53
 */
public class L_1163_Distribute_Candies {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
