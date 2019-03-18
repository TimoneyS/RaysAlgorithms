package com.ray.LintCode.resolved;

import java.util.HashSet;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 *  the wheels of the lock will stop turning and you will be unable to open it.
 *  
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * 
 * @author rays1
 *
 */
public class L_0796_Open_the_Lock {

    /**
     * A * 算法
     * 
     * 记录每个状态从0状态而来需要转动的次数和预期转动到目标状态所需的次数 step + diff
     * 每次选择 step+diff 最小的状态。
     * 每个状态可以到达新的8个状态，这些状态中有些是无效的（会锁住，或者一定达到过的状态）。
     * 将这些新的状态加入队列
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        class Phase {
            int   steps;
            int   diff;
            String   stat;
            public Phase(int steps, int diff, String stat) {
                this.steps = steps;
                this.stat = stat;
                this.diff = diff;
            }
            @Override
            public String toString() {
                return stat;
            }
        }
        
        public int openLock(String[] deadends, String target) {
            HashSet<String> marked = new HashSet<>();
            for (String dn : deadends) marked.add(dn);
            
            PriorityQueue<Phase> pq = new PriorityQueue<>((p1, p2) -> p1.steps+p1.diff - p2.steps - p2.diff);
            if (marked.contains("0000")) return -1;
            
            
            pq.add(new Phase(0, diff("0000", target), "0000"));
            marked.add("0000");
            
            while (!pq.isEmpty()) {
                Phase p = pq.poll();
                if (p.stat.equals(target)) {
                    return p.steps;
                }
                Out.p(pq);
                
                if (marked.contains(target)) continue;
                adj(p, target, pq, marked);
            }
            
            return -1;
        }
        
        private void adj(Phase p, String target, PriorityQueue<Phase> pq, HashSet<String> marked) {
            for (int i = 0; i < 4; i++) {
                String next = next(p.stat, i, true);
                if (!marked.contains(next)) {
                    marked.add(next);
                    pq.add(new Phase(p.steps+1, diff(next, target), next));
                }
                next = next(p.stat, i, false);
                if (!marked.contains(next)) {
                    marked.add(next);
                    pq.add(new Phase(p.steps+1,diff(next, target), next));
                }
            }
        }
        
        private String next(String s1, int i, boolean flag) {
            char c = s1.charAt(i);
            if (flag) {
                if (c == '9') c = '0';
                else c = (char) (c + 1);
            } else {
                if (c == '0') c = '9';
                else c = (char)(c - 1);
            }
            return s1.substring(0,i) + c + s1.substring(i+1);
        }
        
        private int diff(String s1, String s2) {
            int diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                diff += Math.abs(s1.charAt(i) - s2.charAt(i));
            }
            return diff;
        }
        
    }
    
    public static void main(String[] args) {
        
        String[] deadends = {"2110","2000","0000","2111","1110"};
        String target = "0012";
        
        Out.p(new Solution().openLock(deadends, target));
        
    }

}
