package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent
 *      different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval,
 *      CPU could finish one task or just be idle.
 *      
 *      However, there is a non-negative cooling interval `n` that means between two `same tasks`,
 *      there must be at least n intervals that CPU are doing different tasks or just be idle.
 *      
 *      You need to return the `least` number of intervals the CPU will take to finish all the given tasks.
 *
 *      给定一个字符串，表示CPU需要执行的任务。 这个字符串由大写字母A到Z构成，不同的字母代表不同的任务。完成任务不需要按照给定的顺序。 
 *      每项任务都可以在一个单位时间内被完成。 在每个单位时间，CPU可以选择完成一个任务或是不工作。
 *
 *      但是，题目会给定一个非负的冷却时间“n”，表示在执行两个“相同的任务”之间，必须至少有n个单位时间，此时CPU不能执行该任务，只能执行其他任务或者不工作。
 *      您需要返回CPU完成所有给定任务所需的最少单位时间数。
 *
 * 用例：
 *      **用例1**
 *      输入: tasks = ['A','A','A','B','B','B'], n = 2
 *      输出: 8
 *      解释:
 *      A -> B -> idle -> A -> B -> idle -> A -> B.
 *      
 *      **用例2**
 *      输入: tasks = ['A','A','A','B','B','B'], n = 1
 *      输出: 6
 *      解释:
 *      A -> B -> A -> B -> A -> B.
 *      
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/task-scheduler/description
 * @date   2019-07-21 18:02:01
 */
public class L_0945_Task_Scheduler {

    /**
     * 贪心选择
     * 
     * 记录每个任务剩余的待执行的数量和冷却时间
     * 每次选择冷却时间最短（立即执行的冷却时间为1）的且执行数量最多的任务，选择了该任务表示时间轴前进了 x
     * 因此需要将其他冷却中（冷却时间不为1）的任务的冷却时间缩短 x
     * 
     * @author rays1
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
        
        char[] tasks = "AAAAAABCDEFG".toCharArray();
        int n = 2;
        
        Out.p(new Solution().leastInterval(tasks, n));
        
    }

}
