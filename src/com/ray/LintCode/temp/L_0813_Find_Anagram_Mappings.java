package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two lists `A` and `B`, and `B` is an anagram of `A`. `B` is an anagram of `A` means `B` is made by randomizing the order of the elements in `A`.
 *      We want to find an _index mapping_ `P`, from `A` to `B`. `A` mapping `P[i] = j` means the `ith` element in `A` appears in `B` at index `j`.
 *      These lists `A` and `B` may contain duplicates. If there are multiple answers, output any of them.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input:  A = [12, 28, 46, 32, 50] and B = [50, 12, 32, 46, 28]
 *      Output: [1, 4, 3, 2, 0]
 *      Explanation:
 *      As P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input:  A = [1, 2, 3, 4, 5] and B = [5, 4, 3, 2, 1]
 *      Output: [4, 3, 2, 1, 0]
 *      Explanation:
 *      As P[0] = 4 because the 0th element of A appears at B[4], and P[1] = 3 because the 1st element of A appears at B[3], and so on.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-anagram-mappings/description
 * @date   2019-07-11 18:36:53
 */
public class L_0813_Find_Anagram_Mappings {

    /**
     * 两个数组 A, B
     * 
     * 寻找中间数组，对于 P[i] = j 有 A[i] = B[j]
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] anagramMappings(int[] A, int[] B) {
            
            int[] rs = new int[A.length];
            
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                map.put (B[i], i);
            }
            for (int i = 0; i < A.length; i++) {
                rs[i] = map.get (A[i]);
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
