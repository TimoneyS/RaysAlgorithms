package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a set of *n* nuts of different sizes and *n* bolts of different sizes. There is a one-one mapping between nuts and bolts. 
 *      
 *      Comparison of a nut to another nut or a bolt to another bolt is **not allowed**. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.  We will give you a compare function to compare nut with bolt.
 *      
 *      Using the function we give you, you are supposed to sort nuts or bolts, so that they can map in order.
 *
 * 用例：
 *      Given nuts = `['ab','bc','dd','gg']`, bolts = `['AB','GG', 'DD', 'BC']`. 
 *      
 *      Your code should find the matching of bolts and nuts. 
 *      
 *      According to the function, one of the possible return: 
 *      
 *      nuts = `['ab','bc','dd','gg']`, bolts = `['AB','BC','DD','GG']`.
 *      
 *      If we give you another compare function, the possible return is the following:
 *      
 *      nuts = `['ab','bc','dd','gg']`, bolts = `['BC','AA','DD','GG']`.
 *      
 *       So you must use the compare function that we give to do the sorting.
 *      
 *      The order of the nuts or bolts does not matter. You just need to find the matching bolt for each nut.
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/nuts-bolts-problem/description
 * @date   2019-07-11 18:32:32
 */
public class L_0399_Nuts_and_Bolts_Problem {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
