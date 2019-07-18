package com.ray.LintCode.temp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a directed graph where each edge is represented by a `tuple`, such as `[u, v, w] `represents an edge with a weight `w` from `u` to `v`.
 *      You need to calculate at least the need to add the number of edges to ensure that each point of the weight are balancing. That is, the sum of weight of the edge pointing to this point is equal to the sum of weight of the edge of the point that points to the other point.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: [[0,1,10],[2,0,5]]
 *      Output: 2
 *      Explanation:
 *      Two edges are need to added. There are [1,0,5] and [1,2,5]
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]
 *      Output: 1
 *      Explanation:
 *      Only one edge need to added. There is [1,0,4]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Super
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/optimal-account-balancing/description
 * @date   2019-07-11 18:35:43
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
        
        Out.p(new Solution());
        
    }

}
