package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [3,4],
 *   [2,3], [2,4],
 *   [1,2], [1,3], [1,4],
 * ]
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/combinations/
 * @since   2020-02-29 22:10:52
 */
public class L0077_Combinations {

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> rs = new ArrayList<>();
            dfs(1, n, k, new ArrayList<>(), rs);
            return rs;
        }

        private void dfs(int start, int n, int k, List<Integer> base, List<List<Integer>> rs) {
            if (k == 0) {
                rs.add(new ArrayList<>(base));
            } else {
                for (int i = start; i <= n; i++) {
                    base.add(i);
                    dfs(i + 1, n, k - 1, base, rs);
                    base.remove(base.size() - 1);
                }
            }
        }
    }

    static class Solution2 {
        public List<List<Integer>> combine(int n, int k) {
            return c(k, 1, n, 1);
        }

        public List<List<Integer>> c(int k, int start, int n, int level) {
            List<List<Integer>> rs = null;
            if (k == 1) {
                rs = new ArrayList<>();
                for (int i = start; i <= n; i++) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    rs.add(l);
                }
            } else {
                rs = new ArrayList<>();
                List<List<Integer>> temp;

                // 包含起点的结果
                temp = c(k-1, start+1, n, level + 1);
                for (List<Integer> list : temp) {
                    list.add(0, start);
                    rs.add(list);
                }

                // 不包含起点的结果
                if (n-start+1 >= k) {
                    temp = c(k, start+1, n, level + 1);
                    for (List<Integer> list : temp) {
                        rs.add(list);
                    }
                }

            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Out.p(new Solution().combine(n, k));
    }
}
