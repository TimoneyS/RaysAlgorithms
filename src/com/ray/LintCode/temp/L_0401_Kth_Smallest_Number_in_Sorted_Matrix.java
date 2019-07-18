package com.ray.LintCode.temp;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      Find the *k*th smallest number in a row and column sorted matrix.
 *      
 *      Each row and each column of the matrix is incremental.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *      [
 *        [1 ,5 ,7],
 *        [3 ,7 ,8],
 *        [4 ,8 ,9],
 *      ]
 *      k = 4
 *      Output: 5
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *      [
 *        [1, 2],
 *        [3, 4]
 *      ]
 *      k = 3
 *      Output: 3
 *      ```
 *
 * 挑战：
 *      O*(klogn*) time, *n* is the maximum of the width and height of the matrix.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/kth-smallest-number-in-sorted-matrix/description
 * @date   2019-07-11 18:32:34
 */
public class L_0401_Kth_Smallest_Number_in_Sorted_Matrix {

    public static class Solution {
        
        class Pair {
            public int x, y, val;
            public Pair(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }
        }
        class PairComparator implements Comparator<Pair> {
            public int compare(Pair a, Pair b) {
                return a.val - b.val;
            }
        }
        
        int[][] dirs = {
                {0, 1}, // 右
                {1, 0}  // 下
        };
        
        public int kthSmallest(int[][] matrix, int k) {
            
            int n = matrix.length;
            int m = matrix[0].length;
            boolean[][] marked = new boolean[n][m];
            
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new PairComparator());
            pq.add(new Pair(0, 0, matrix[0][0]));

            for(int i = 0; i < k - 1; i ++){
                Pair cur = pq.poll();
                for (int[] dir : dirs) {
                    int tx = cur.x + dir[0], ty = cur.y + dir[1];
                    if(tx < n && ty < m && !marked[tx][ty]){
                        marked[tx][ty] = true;
                        pq.add(new Pair(tx, ty, matrix[tx][ty]));
                    }
                }
            }
            return pq.peek().val;
        }
        
    }
    
    // 二分法
    static class Solution1 {
        class ResultType {
            public int num;
            public boolean exists;
            public ResultType(boolean e, int n) {
                exists = e;
                num = n;
            }
        }
        
        public ResultType check(int value, int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            
            boolean exists = false;
            int num = 0;
            int i = n - 1, j = 0;
            while (i >= 0 && j < m) {
                if (matrix[i][j] == value)
                    exists = true;
                    
                if (matrix[i][j] <= value) {
                    num += i + 1;
                    j += 1;
                } else {
                    i -= 1;
                }
            }
            
            return new ResultType(exists, num);
        }
        
        public int kthSmallest(int[][] matrix, int k) {
            // write your code here
            int n = matrix.length;
            int m = matrix[0].length;
            
            int left = matrix[0][0];
            int right = matrix[n - 1][m - 1];
            
            // left + 1 < right
            while (left <= right) {
                int mid = left + (right - left) / 2;
                ResultType type = check(mid, matrix);
                if (type.exists && type.num == k) {
                    return mid;
                } else if (type.num < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {
                {1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},
        };
        int k = 4;
        
        Out.p(new Solution().kthSmallest(matrix, k));
        
    }

}
