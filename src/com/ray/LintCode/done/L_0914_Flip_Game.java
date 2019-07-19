package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述 :
 *      翻转游戏的规则如下：
 *          给定一个字符串只包含 + 和 -
 *          玩家可以将连续的 ++ 变成 --
 *          当一个玩家无法进行翻转时，游戏结束，并且另一个玩家为胜利。
 *          
 *       编写方法来计算给定的字符串，所有可能的翻转结果。
 *
 * Example :
 *   **Example1**
 *   
 *   ```
 *   Input:  s = "++++"
 *   Output: 
 *   [
 *     "--++",
 *     "+--+",
 *     "++--"
 *   ]
 *   ```
 *   
 *   **Example2**
 *   
 *   ```
 *   Input: s = "---+++-+++-+"
 *   Output: 
 *   [
 *   	"---+++-+---+",
 *   	"---+++---+-+",
 *   	"---+---+++-+",
 *   	"-----+-+++-+"
 *   ]
 *   
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flip-game/description
 * @date   2019-07-03 17:34:21
 */
public class L_0914_Flip_Game {

    static class Solution {
    
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
        
        String s = "---+++-+++-+";
        
        Out.p(new Solution().generatePossibleNextMoves(s));
        
    }

}
