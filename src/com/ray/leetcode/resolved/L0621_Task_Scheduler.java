package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Task Scheduler
 * -----------------------------------------------------------------------------
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example:
 *      Example 1
 *      Input: tasks = [A,A,A,B,B,B], n = 2
 *      Output: 8
 *      Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *      Constraints:
 *      	The number of tasks is in the range [1, 10000].
 *      	The integer n is in the range [0, 100].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/task-scheduler/
 * @since   2020-03-31 22:23:45
 */
public class L0621_Task_Scheduler {
    /**
     * 贪心选择
     *
     * 记录每个任务剩余的待执行的数量和冷却时间
     * 每次选择冷却时间最短（立即执行的冷却时间为1）的且执行数量最多的任务，选择了该任务表示时间轴前进了 x
     * 因此需要将其他冷却中（冷却时间不为1）的任务的冷却时间缩短 x
     * 
     */
    static class Solution {
        public int leastInterval(char[] tasks, int n) {

            // 第1位是权，第2位是剩余可用统计
            Map<Character, int[]> hash = new HashMap<>();
            for (char c : tasks) {
                hash.putIfAbsent(c, new int[] {1, 0} );
                hash.get(c)[1] ++;
            }

            int rs = 0;
            while (!hash.isEmpty()) {

                char  baseChar = ' ';
                int[] baseArr  = null;
                for (Map.Entry<Character, int[]> e : hash.entrySet()) {
                    int[] arr = e.getValue();
                    if (baseArr == null || baseArr[0] > arr[0] || baseArr[0] == arr[0] && baseArr[1] < arr[1]) {
                        baseArr = arr;
                        baseChar = e.getKey();
                    }
                }

                int gap = baseArr[0];

                rs += baseArr[0];
                for (Map.Entry<Character, int[]> e : hash.entrySet()) {
                    if (e.getValue()[0] != 1) {
                        e.getValue()[0] = e.getValue()[0] - gap;
                    }
                }

                if (baseArr[1] == 1) {
                    hash.remove(baseChar);
                } else {
                    baseArr[0] = n + 1;
                    baseArr[1] --;
                }

            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
