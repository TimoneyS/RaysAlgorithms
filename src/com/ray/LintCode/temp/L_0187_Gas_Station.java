package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      There are _N_ gas stations along a circular route, where the amount of gas at station _i_ is `gas[i]`.
 *      
 *      You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from station i to its next station (_i_+1). You begin the journey with an empty tank at one of the gas stations.
 *      
 *      Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:gas[i]=[1,1,3,1],cost[i]=[2,2,1,1]
 *      Output:2
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:gas[i]=[1,1,3,1],cost[i]=[2,2,10,1]
 *      Output:-1
 *      ```
 *
 * 挑战：
 *      O(n) time and O(1) extra space
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/gas-station/description
 * @date   2019-07-11 18:31:45
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
