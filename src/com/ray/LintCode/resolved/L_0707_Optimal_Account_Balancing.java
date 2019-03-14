package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 给定一个有向图，每个边由一个元组表示，比如 [u, v, w] 表示从 u 到 v 有一条边，权重为 w
 * 你需要计算至少需要添加多少边，能够保证每个顶点的权重是平衡的。
 * 平衡的意思是，所有指向该顶点的边的权重之和，等于该顶点去向其他顶点的边的权重之和。
 * 
 * 示例
 *      输入：
 *          图[[0,1,10],[2,0,5]]
 *      输出：
 *          2
 *          2 --5--> 0 -- 10 -- > 1
 *          可以看到图中所有的顶点都是不平衡的，但是只要添加边 [1,0,5] 和 [1,2,5] 之后所有的顶点的入权和出权一致。
 * 
 * @author rays1
 *
 */
public class L_0707_Optimal_Account_Balancing {

    /**
     * 这个题目的愿意是一群人原本互不相欠，然后经过互相帮助比如A帮B付了午餐钱，B帮C付了打车钱之后
     * 他们之间出现了欠债关系，现在每个人要付清自己欠的钱，问最少需要多少次转账。
     * 
     * 比如 A 帮 B 付了 10元的午餐，B 帮 C 付了 10 元 的打车之后，只要 C 转账给 A 10 元即可，只要一次转账。
     * 
     * 这里可以将每个人的账户列出一个账单，账单为负数表示这个人要等待别人还钱，账单为正表示这个人要还别人钱。
     * 可以将账单为正和负分开放可以发现如下关系：
     *          1. 所有债主的账单之和 + 所有负债人的账单之和 = 0;
     *          2. 债主可以接受多个负债人的交易，负债人也可以向多个负债人还款，他们的关系是多对多的关系。
     *          3. 债主在还债时，应该尽可能多的还债。
     *          
     *  最小交易就是债务人和债主之间尽可能的简化后的最小债务关系。        
     *          
     * 1. 读完题我们会发现每个人都有一个借钱的数量和一个还钱的数量(有可能是0)，如果这个人的这两个值的和为0，那么他就不需要还钱或者借钱给别人了。
     * 证明：假设此人在借还之和为0的情况下收到 X 的钱，那么为了收支平衡，必定要把这些钱给另外一个人 Y，那么这样不会比X把钱直接给 Y 得到的答案更优。
     * 比如，设三个人的收支情况为[-2,0,2]，那么第3个人把2转移到第2个人，再由第2个人转移到第1个人，需要2次交易，但是第3个人直接转移给第1个人那么只需要1次。
     * 
     * 2. 接下来我们只需要处理所有收支不为0的那些人。我们发现，(在数据合法的情况下)所有人的收支情况的和也是0，那么我们就来分析一下如何让答案最小。
     * 对于预处理完收支情况的一个数组[ 2 , 3 , -2 , -3 ] (用正数表示收入，负数表示支出)，显而易见答案是2 （2 → -2 , 3 → -3 ），但是还有一种不是最优的答案3（3 → -2 , 1 → -3 , 2 → -2）。那么我们就能发现，最优答案是2个子问题([2,-2],[3,-3])的最优解的和。
     * 我们可以用集合枚举所有的子集，找到每个子集的最优解从而解得总问题的最优解。在这里我们可以把一个集合的子集定义为一个只有 0,1 的向量，
     * 比如一个有3个元素的集合，他们的子集分别是000(空集),001,010,100,011,110,101,111(全集)，'1'代表这个子集里有这个元素，'0'代表这个子集里没有这个元素。
     * 再利用一个1~n循环来判断这个子集里有哪些元素，如101代表这个子集里有第1个和第3个元素。
     * 
     * 3. 接下来我们分析这种解法的时间复杂度，假设去除所有收支平衡以后的人数为n，枚举子集的时间复杂度为O(2^n),
     * 对每个子集进行最优解分析也需要枚举它的所有子集(这些子集的最优解已经计算完成)，需要的时间复杂度也为O(2^n),最终的时间复杂度为O(4^n)。
     * 空间复杂度为O(2^n)
     *          
     * @author rays1
     *
     */
    static class Solution {
    
        public int balanceGraph(int[][] edges) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] edge : edges) {
                map.put(edge[0], map.getOrDefault(edge[0], 0) - edge[2]);
                map.put(edge[1], map.getOrDefault(edge[1], 0) + edge[2]);                
            }
            
            int[] acct = new int[map.size()];
            int len = 0;
            for (int v : map.values()) {
                if(v != 0)acct[len++] = v;
            }
            
            if (len == 0) return 0;
            
            int[] dp = new int[1 << len];
            Arrays.fill(dp, Integer.MAX_VALUE/2);
            for (int i = 1;i < dp.length; i++) {
                int sum = 0, count = 0;
                for (int j = 0; j < len; j++) {
                    if ( (1<<j & i)!= 0) {
                        sum += acct[j];
                        count ++;
                    }
                }
                
                if (sum == 0) {
                    dp[i] = count - 1;
                    for (int j = 1; j < i; j++) {
                        if ( ((i&j)==j) && dp[j] + dp[i-j] < dp[i]) {
                            dp[i] = dp[j] + dp[i-j]; 
                        }
                    }
                }
                
            }
            
            return dp[dp.length-1];
        }
        
        // 递归解法，复杂度O(n!)
        public int help(int[] acct, int start, int base) {
            while (start < acct.length && acct[start] == 0 ) start++;
            if (start >= acct.length) return base;
            
            int min = Integer.MAX_VALUE;
            for (int i = start+1; i < acct.length; i ++) {
                if (acct[i]*acct[start] < 0) {
                    acct[i] += acct[start];
                    min = Math.min(min,  help(acct, start+1, base + 1));
                    if (acct[i] == 0) {
                        acct[i] -= acct[start];
                        break;
                    } else {
                        acct[i] -= acct[start];
                    }
                }
            }
            return min;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] edges = {{7,6,1},{4,6,59},{8,9,46},{7,5,92},{14,13,92},{2,1,93},{9,8,19},{14,13,72},{9,8,68},{12,16,4},{14,15,74},{1,3,54},{3,0,63},{5,7,24},{5,6,17},{12,14,89},{8,10,65},{2,1,91},{6,5,94},{1,3,85},{8,10,77},{15,16,40},{11,9,39},{10,9,42},{7,6,5},{9,10,74},{9,8,73},{9,8,87},{9,8,56},{12,16,32},{2,1,25},{10,11,92},{14,15,84},{5,6,22},{2,1,69},{3,2,56},{11,8,38},{3,1,3},{11,8,75},{0,1,49}};
        
//        int[][] edges = {{0,1,10},{1,2,5},{2,7,20},{3,4,100}}; 
        
        Timer.CLICK();
        Out.p(new Solution().balanceGraph(edges));
        Timer.STOP();
    }

}