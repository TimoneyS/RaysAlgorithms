package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

/**
 * Course Schedule II
 * -----------------------------------------------------------------------------
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example:
 *      Example 1
 *      Input: 2, [[1,0]] 
 *      Output: [0,1]
 *      Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
 *                   course 0. So the correct course order is [0,1] .
 *      Example 2
 *      Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 *      Output: [0,1,2,3] or [0,2,1,3]
 *      Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
 *                   courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
 *                   So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 *      Note:
 *      	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *      	You may assume that there are no duplicate edges in the input prerequisites.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/course-schedule-ii/
 * @since   2020-03-09 00:28:18
 */
public class L0210_Course_Schedule_II {
    /**
     * 算法等同 L0207_Course_Schedule，依次添加入度为 0 的结点到结果中即可。
     */
    static class Solution {
        public int[] findOrder(int numCourses, int[][] pre) {
            int[] rs = new int[numCourses];

            // 创建图
            ArrayList<HashSet<Integer>> graph = new ArrayList<>(numCourses+1);
            for (int i = 0; i < numCourses; i++) graph.add(new HashSet<>());
            for (int[] ints : pre) graph.get(ints[1]).add(ints[0]);

            // 统计结点的入度
            int[] numPre = new int[numCourses];
            for (HashSet<Integer> adj : graph)
                for (int after : adj)
                    numPre[after]++;

            // 入度为 0 的结点放入 BFS 的起始队列
            Queue<Integer> sortCourse = new ArrayDeque<>();
            for(int i = 0;i < numCourses; i++)
                if(numPre[i] == 0)
                    sortCourse.offer(i);

            // BFS
            int count = 0;
            while(!sortCourse.isEmpty()){
                int v = sortCourse.poll();
                for(int w : graph.get(v)){
                    numPre[w]--;
                    if(numPre[w] == 0) sortCourse.offer(w);
                }
                rs[count] = v;
                count++;
            }
            return count == numCourses ? rs : new int[0];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
