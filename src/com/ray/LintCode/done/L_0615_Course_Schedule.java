package com.ray.LintCode.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 描述：
 *      There are a total of n courses you have to take, labeled from `0` to `n - 1`.
 *      
 *      Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *      
 *      Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: n = 2, prerequisites = [[1,0]] 
 *      Output: true
 *      ```
 *      Example 2:
 *      ```
 *      Input: n = 2, prerequisites = [[1,0],[0,1]] 
 *      Output: false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/course-schedule/description
 * @date   2019-07-11 18:34:30
 */
public class L_0615_Course_Schedule {

    /**
     * 学习课程 [0, 1] 可记为 边 0 -> 1，最终课程的关系构成了一张图。
     * 能够完成所有课程的唯一条件就是所有边不会组成环。
     * 
     * 算法原理：
     *      统计所有结点的入度
     *      使用 BFS 搜索图
     *      BFS 的起点是所有入度为 0 的结点，表示该课程当前可以直接学习
     *      每搜索到一个结点表示学习该课程，将后续课程的入度减 1
     *      如果后续课程的入度为 0 表示可以学习后续课程，将后续课程也加入学习队列。
     *      记录算法过程中所有入度为 0 的结点，如果最终计数
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>(numCourses+1);
            
            for (int i = 0; i < numCourses; i++)
                graph.add(new HashSet<Integer>());
            
            for (int i = 0; i < prerequisites.length; i++)
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
            // 统计结点的入度
            int[] numPre = new int[numCourses];
            for (HashSet<Integer> adj : graph) {
                for (int after : adj) {
                    numPre[after]++;
                }
            }
            
            // 入度为 0 的结点放入 BFS 的起始队列
            Queue<Integer> sortCourse = new ArrayDeque<Integer>();
            for(int i = 0;i<numCourses;i++){
                if(numPre[i] == 0){
                    sortCourse.offer(i);
                }
            }
            
            // BFS
            int count = 0;
            while(!sortCourse.isEmpty()){
                int v = sortCourse.poll();
                for(int w : graph.get(v)){
                    numPre[w]--;
                    if(numPre[w] == 0){
                        sortCourse.offer(w);
                    }
                }
                count++;
            }
            
            return count == numCourses ? true : false;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
