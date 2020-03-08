package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

/**
 * Course Schedule
 * -----------------------------------------------------------------------------
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example:
 *      Example 1
 *      Input: 2, [[1,0]] 
 *      Output: true
 *      Explanation: There are a total of 2 courses to take. 
 *                   To take course 1 you should have finished course 0. So it is possible.
 *      Example 2
 *      Input: 2, [[1,0],[0,1]]
 *      Output: false
 *      Explanation: There are a total of 2 courses to take. 
 *                   To take course 1 you should have finished course 0, and to take course 0 you should
 *                   also have finished course 1. So it is impossible.
 *      Note:
 *      	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *      	You may assume that there are no duplicate edges in the input prerequisites.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/course-schedule/
 * @since   2020-03-09 00:06:13
 */
public class L0207_Course_Schedule {
    /**
     * 学习课程 [0, 1] 可记为 边 0 -> 1，最终课程的关系构成了一张图。
     * 能够完成所有课程的唯一条件就是所有边不会组成环。
     *
     * 算法原理：
     *      从所有入度为0的结点开始搜索（入度为 0 表示该课程不需要前置）
     *      每搜索到一个结点表示学习该课程，将后续课程的入度减 1
     *      如果后续课程的入度为 0 表示可以学习后续课程，将后续课程也加入学习队列。
     *      记录算法过程中所有入度为 0 的结点，如果最终计数
     */
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<HashSet<Integer>> graph = new ArrayList<>(numCourses+1);

            for (int i = 0; i < numCourses; i++) graph.add(new HashSet<>());
            for (int[] prerequisite : prerequisites) graph.get(prerequisite[1]).add(prerequisite[0]);

            // 统计结点的入度
            int[] numPre = new int[numCourses];
            for (HashSet<Integer> adj : graph)
                for (int after : adj)
                    numPre[after]++;

            // 入度为 0 的结点放入 BFS 的起始队列
            Queue<Integer> sortCourse = new ArrayDeque<>();
            for(int i = 0;i < numCourses;i++)
                if(numPre[i] == 0)
                    sortCourse.offer(i);

            // BFS
            int count = 0;
            while(!sortCourse.isEmpty()){
                int v = sortCourse.poll();
                for(int w : graph.get(v)) {
                    numPre[w]--;
                    if(numPre[w] == 0) sortCourse.offer(w);
                }
                count++;
            }
            return count == numCourses;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
