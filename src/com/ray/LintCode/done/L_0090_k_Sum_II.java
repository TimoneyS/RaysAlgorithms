package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      Given n unique postive integers, number k (1<=k<=n)  and target. 
 *      
 *      Find all possible k integers where their sum is target.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [1,2,3,4], k = 2, target = 5
 *      Output:  [[1,4],[2,3]]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [1,3,4,6], k = 3, target = 8
 *      Output:  [[1,3,4]]	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/k-sum-ii/description
 * @date   2019-07-11 18:30:06
 */
public class L_0090_k_Sum_II {

    static class Solution {
        
        List<List<Integer>>[][][] mem;
        
        /*
         * @param A: an integer array
         * @param k: a postive integer <= length(A)
         * @param target: an integer
         * @return: A list of lists of integer
         */
        @SuppressWarnings("unchecked")
        public List<List<Integer>> kSumII(int[] A, int k, int target) {
            mem = (List<List<Integer>>[][][]) new List[A.length+1][k+1][target+1];
            return kSum(A, 0, k, target);
        }
        
        public List<List<Integer>> kSum(int[] A, int s, int k, int target) {
            
            if (target < 0 || s >= A.length || k < 0) return null;
            
            if (mem[s][k][target] != null && k < 5)
                return cloneList(mem[s][k][target]);
            
            List<List<Integer>> rs = new ArrayList<>();
            
            if (target == A[s] && k == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(A[s]);
                rs.add(l);
            } else {
            
                List<List<Integer>> rs1 = kSum(A, s+1, k, target);
                List<List<Integer>> rs2 = kSum(A, s+1, k-1, target-A[s]);
                
                if (rs1 != null)
                    rs.addAll(rs1);
                if (rs2 != null) {
                    for (List<Integer> list : rs2) {
                        list.add(0, A[s]);
                    }
                    rs.addAll(rs2);
                }
                
            }
            
            mem[s][k][target] = cloneList(rs);
            return rs;
        }
        
        public List<List<Integer>> cloneList(List<List<Integer>> rs) {
            List<List<Integer>> copy = new ArrayList<>();
            for (List<Integer> list : rs) {
                List<Integer> l = new ArrayList<>();
                for (Integer integer : list) {
                    l.add(integer);
                }
                copy.add(l);
            }
            return copy;
        }
        
    }
    
    static class Solution1 {
        
        List<List<Integer>>[][][] mem;
        
        /*
         * @param A: an integer array
         * @param k: a postive integer <= length(A)
         * @param target: an integer
         * @return: A list of lists of integer
         */
        @SuppressWarnings("unchecked")
        public List<List<Integer>> kSumII(int[] A, int k, int target) {
            mem = (List<List<Integer>>[][][]) new List[A.length+1][k+1][target+1];
            return kSum(A, 0, k, target);
        }
        
        public List<List<Integer>> kSum(int[] A, int s, int k, int target) {
            
            if (target < 0 || s >= A.length || k < 0) return null;
            
            List<List<Integer>> rs = new ArrayList<>();
            
            if (target == A[s] && k == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(A[s]);
                rs.add(l);
            } else {
            
                List<List<Integer>> rs1 = kSum(A, s+1, k, target);
                List<List<Integer>> rs2 = kSum(A, s+1, k-1, target-A[s]);
                
                if (rs1 != null)
                    rs.addAll(rs1);
                if (rs2 != null) {
                    for (List<Integer> list : rs2) {
                        list.add(0, A[s]);
                    }
                    rs.addAll(rs2);
                }
                
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,3,4,6,9,10,12,14,16,19,22,25};
        int k = 5;
        int target = 55;
        
        Timer.CLICK();
        Out.p(new Solution().kSumII(A, k, target));
        Timer.CLICK();
        Out.p(new Solution1().kSumII(A, k, target));
        Timer.STOP();
        
    }

}
