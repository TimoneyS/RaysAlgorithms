package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      翻转游戏的规则如下：
 *          给定一个字符串只包含 + 和 -
 *          玩家可以将连续的 ++ 变成 --
 *          当一个玩家无法进行翻转时，游戏结束，并且另一个玩家为胜利。
 *      设计算法判断先开始的玩家能否保证胜利。
 *
 * 用例：
 *   用例一：
 *      输入： s = "++++"
 *      输出：true
 *      解释：
 *          先开始的玩家可以将字符串变为 +--+
 *   
 *   用例二：
 *      输入：s = "+++++"
 *      输出：false
 *      解释：
 *          先开始的玩家无法保证胜利
 *          "+++--" --> "+----"
 *          "++--+" --> "----+"
 *
 * 挑战：
 *  推断出算法的复杂度。
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flip-game-ii/description
 * @date   2019-07-03 17:34:20
 */
public class L_0913_Flip_Game_II {
    
    /**
     * 
     * 设 f(s) 表示字符串为s时，玩家先手能否胜利
     * 设 sub[i] 表示 s 能够翻转的结果
     * 
     * 基于最优策略先开始的玩家要保证自己胜利，则需要保证翻转后结果字符串，使得另一个玩家的结果一定是输。
     * 则
     *      若 f(s) = true 一定存在 sub[i] 使得 f(sub[i]) = false
     *      
     * f(s) = !f(sub[0]) || !f(sub[1]) || ... || !f(sub[i]) ..     
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean canWin(String s) {
            HashMap<String, Boolean> mem = new HashMap<>();
            return f(s, mem);
        }
        
        public boolean f(String s, Map<String, Boolean> mem) {
            if(!mem.containsKey(s)) { 
                List<String> list = generatePossibleNextMoves(s);
                boolean rs = false;
                for (String sub : list) {
                    rs |= !f(sub, mem);
                } 
                mem.put(s, rs);
            }
            return mem.get(s);
        }
        
        public List<String> generatePossibleNextMoves(String s) {
            List<String> rs = new ArrayList<>();
            char bak = ' ', c = ' ';
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c == '+' && bak == '+') {
                    rs.add(s.substring(0, i-1) + "--" + s.substring(i+1));
                }
                bak = c;
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "+++++";
        
        Out.p(new Solution().canWin(s));
        
    }

}
