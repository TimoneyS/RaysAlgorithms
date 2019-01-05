package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 
 * 环路上有N的加油站，每个加油站的储量是 gas[i]。从加油站i到加油站i+1需要耗费汽油cost[i]。在其中的某个加油站开始，油箱为空。
 * 计算从哪个起点开始，可以绕环线一周。没有则返回-1
 * 
 * 如 4 个加油站 gas[i] = [1,1,3,1]
 * 消耗是 cost[i]=[2,2,1,1]
 * 则从 2 开始可以绕环线一周。
 * 
 * O(n) time and O(1) extra space
 * 
 * @author rays1
 *
 */
public class L_0187_Gas_Station {

    /**
     * 环绕时，如果有油箱可以抵达下个目标则经过数+1，否则从下个目标重新开始
     * @author rays1
     *
     */
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int past = 0, remain = 0;
            int i = 0, n = gas.length;
            for (; i < n*2; i++) {
                remain += gas[i%n] - cost[i%n];
                if (remain >= 0) {
                    past ++;
                } else {
                    past = 0;
                    remain = 0;
                }
                if (past == n) {
                    return (i+1)%n;
                }
            }
            return -1;
        }
    }
    
    public static void main(String[] args) {
        
        int[] gas = {1,1,3,1};
        int[] cost = {2,2,1,1};
        
        Out.p(new Solution().canCompleteCircuit(gas, cost));
        
    }

}
