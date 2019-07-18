package com.ray.LintCode.temp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      In this problem, each process has a unique **PID (process id)** and **PPID (parent process id)**.
 *      
 *      Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.
 *      
 *      We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.
 *      
 *      Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: PID = [1, 3, 10, 5], PPID = [3, 0, 5, 3], killID = 5
 *      Output: [5, 10]
 *      Explanation: Kill 5 will also kill 10.
 *           3
 *         /   \
 *        1     5
 *             /
 *            10
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: PID = [1, 2, 3], PPID = [0, 1, 1], killID = 2
 *      Output: [2]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/kill-process/description
 * @date   2019-07-11 18:38:10
 */
public class L_0872_Kill_Process {

    static class Solution {
    
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            List<Integer> rs = new ArrayList<>();
            
            Map<Integer, Set<Integer>> map = new HashMap<>();
            
            for (int i = 0; i < ppid.size(); i++) {
                int ppidNum = ppid.get(i);
                int pidNum = pid.get(i);
                map.putIfAbsent(ppidNum, new HashSet<>());
                map.get(ppidNum).add(pidNum);
            }
            
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(kill);
            
            while (!queue.isEmpty()) {
                int id = queue.poll();
                rs.add(id);
                if (map.containsKey(id))
                    queue.addAll(map.get(id));
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
