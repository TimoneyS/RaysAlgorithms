package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      Cosine similarity is a measure of similarity between two vectors of an inner product space that measures the cosine of the angle between them. The cosine of 0° is 1, and it is less than 1 for any other angle.
 *      
 *      See Wiki: [Cosine Similarity](https://en.wikipedia.org/wiki/Cosine_similarity "")
 *      
 *      Here is the formula:
 *      
 *      ![cosine-similarity](https://lintcode-media.s3.amazonaws.com/problem/cosine-similarity.png "")
 *      
 *      Given two vectors *A* and *B* with the same size, calculate the cosine similarity.
 *      
 *      Return `2.0000` if cosine similarity is invalid (for example A = [0] and B = [0]).
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: A = [1,4,0], B = [1,2,3]
 *      Output: 0.5834
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: A = [1], B = [2]
 *      Output: 1.0000
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/cosine-similarity/description
 * @date   2019-07-11 18:33:11
 */
public class L_0445_Cosine_Similarity {


    /**
     * 按照公式即可
     *
     */
    static class Solution {
    
        public double cosineSimilarity(int[] A, int[] B) {
            
            double dividend = 0;
            
            double temp = 0;
            for (int num : A) temp += num * num;
            dividend = Math.sqrt(temp);
            
            temp = 0;
            for (int num : B) temp += num * num;
            
            dividend *= Math.sqrt(temp);
            
            if (dividend == 0) return 2;
            
            temp = 0;
            for (int i = 0; i < B.length; i++) {
                temp += A[i] * B[i];
            }
            
            return temp / dividend;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,2,3};
        int[] B = {2,3,4};
        
        Out.p(new Solution().cosineSimilarity(A, B));
        
    }

}
