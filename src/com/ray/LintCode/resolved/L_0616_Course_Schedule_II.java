package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 总共有 n 项课程需要学习，标记为 0 到 n-1
 * 一些课程必须要先学习，比如在学习 0 之前需要先学习 1，这种情况表示为 [0, 1]
 * 给定课程总数（n）和课程关系的列表（prerequisites），返回课程学习的顺序。
 * 可能有多种顺序，只要返回可行的顺序即可。如果没有可行的课程学习路线，返回空数组。
 *
 * 例如：
 *      n = 2, prerequisites = [[1,0]] 
 *      输出：[ 0, 1 ]
 *      
 *      n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]] 
 *      输出：[0,1,2,3] 或者 [0,2,1,3]
 *      
 * @author rays1
 *
 */
public class L_0616_Course_Schedule_II {

    /**
     * 算法等同 L_0615_Course_Schedule ， 依次添加入度为 0 的结点到结果中即可。
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] rs = new int[numCourses];
            
            // 创建图
            ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>(numCourses+1);
            for (int i = 0; i < numCourses; i++)
                graph.add(new HashSet<Integer>());
            for (int i = 0; i < prerequisites.length; i++)
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
            // 统计结点的入度
            int[] numPre = new int[numCourses];
            for (HashSet<Integer> adj : graph)
                for (int after : adj)
                    numPre[after]++;
            
            // 入度为 0 的结点放入 BFS 的起始队列
            Queue<Integer> sortCourse = new ArrayDeque<Integer>();
            for(int i = 0;i<numCourses;i++)
                if(numPre[i] == 0)
                    sortCourse.offer(i);
            
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
