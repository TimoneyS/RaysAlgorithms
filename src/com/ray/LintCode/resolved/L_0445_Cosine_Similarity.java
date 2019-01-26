package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 余弦相似性
 * 
 * 余弦相似性是内积空间的两个矢量之间的相似性的度量，其测量它们之间的角度的余弦。
 * 0° 的余弦为1，对于任何其他角度，余弦小于 1。
 * 
 * cos(α) = ∑ ( Ai * Bi) / ( √∑(Ai^2) ) * √∑(Bi^2) 
 *
 *
 * @author rays1
 *
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
