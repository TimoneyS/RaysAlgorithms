package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述 ：
 *   n个不同面值的硬币排成一行，两个玩家轮流从左侧拿走一到两个硬币。直到所有硬币被拿完，最后拿到硬币价值最高的玩家胜利。
 *   如果玩家A先拿硬币，判断玩家A是否一定能够胜利。
 *
 * 用例：
 *   用例一：
 *      输入：[1, 2, 2]
 *      输出：true
 *      解释：
 *          玩家A直接拿走两个硬币
 *   
 *   用例二：
 *      输入：[1, 2, 4]
 *      输出：false
 *      解释：
 *          无论玩家A拿取几个硬币，玩家B都能够胜利。
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/coins-in-a-line-ii/description

 * @date   2019-07-09 16:32:40
 */
public class L_0395_Coins_in_a_Line_II {

    /**
     * f[i] 表示玩家 A 从 i 开始比赛能够取得的最大钱数
     * v[i] 表示位置 i 的硬币的面值
     * 
     * 则有，讨论从 i 开始比赛
     *          
     *     (1). A 拿走一个硬币
     *         如果B拿走一个，等于从 i+2开始比赛，A还能得到 f[i+2]
     *         如果B拿走两个，等于从 i+3开始比赛，A还能得到 f[i+3]
     *         B 会选择能够让A拿到最少的硬币的策略，因此A之后能拿到的是 min {f[i+2], f[i+3]}
     *         因此A能够拿到的价值是 v[i] + min {f[i+2], f[i+3]}
     *         
     *     (2). A 拿走两个硬币
     *         如果B拿走一个，等于从 i+3开始比赛，A还能得到 f[i+3]
     *         如果B拿走两个，等于从 i+4开始比赛，A还能得到 f[i+4]
     *         B 会选择能够让A拿到最少的硬币的策略，因此A之后能拿到的是 min {f[i+3], f[i+4]}
     *         因此A能够拿到的价值是 v[i] + v[i+1] + min {f[i+3], f[i+4]}
     *    
     *    综合两种情况，A应该选择两种情况中较大的一种策略。      
     *         f[i] = max {
     *               v[i] + min {f[i+2], f[i+3]},
     *               v[i] + v[i+1] + min {f[i+3], f[i+4]}
     *         }
     *    
     * @author rays1
     *
     */
    static class Solution1 {
    
        public boolean firstWillWin(int[] v) {
            if (v.length <= 2) return true;
            int n = v.length, sum = 0;
            int[] f = new int[n+1];
            
            f[n - 1] = v[n - 1];            // 从到数第一个硬币开始，直接全部拿走
            f[n - 2] = v[n - 2] + v[n - 1]; // 从倒数第二个硬币开始，全部拿走
            f[n - 3] = v[n - 3] + v[n - 2]; // 从到数第三个硬币开始，拿两个，否则B会拿两个。
            
            for (int i = n - 4; i >= 0; --i) {
                f[i] = Math.max(
                        v[i] + Math.min(f[i + 2], f[i + 3]),
                        v[i] + v[i + 1] + Math.min(f[i + 3], f[i + 4])
                );
            }
            for (int d : v) sum += d;
            return sum - f[0] < f[0];
        }
    
    }
    
    /**
     * f[i] 表示从玩家从i开始拿取，最终能够比另一个玩家多拿的硬币数。
     * 
     * 如讨论位置 i 时，可能有两种情况
     *      1. A 拿取 1个
     *          B 从i+1开始，能够比A多拿f[i+1]
     *          则 f[i] = values[i] - f[i+1]
     *          
     *      2. A 拿取 2个
     *          B 从i+2开始，能够比A多拿 f[i+2]
     *          则 f[i] = values[i] + values[i+1] - f[i+2]
     *          
     * 那么 A 选择两个可能结果的最大值
     *      f[i] = max { 
     *          values[i] - f[i-1], 
     *          values[i] + values[i+1] - f[i-2]
     *      }
     * 
     * @author rays1
     *
     */
    static class Solution2 {
        public boolean firstWillWin(int[] values) {
            int n = values.length;
            int[] f = new int[n + 1];
            
            f[n-1] = values[n-1] - f[n];
            for (int i = n - 2; i >= 0; i--){
                f[i] = Math.max(
                        values[i] - f[i + 1],
                        values[i] + values[i + 1] - f[i + 2]);
            }
            return f[0] >= 0;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution1());
        
    }

}
