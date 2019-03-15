package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 约翰想在他家后面的空地上建一个后花园，现在有两种砖，高度 3 和 高度 7 的高度。
 * 约翰想围成高度 x 的墙。如果约翰能做到，输出YES，否则输出NO。
 *
 * @author rays1
 *
 */
public class L_0749_Johns_backyard_garden {

    /**
     * 任意数模 7 的结果一定是 0 1 2 3 4 5 6
     *  0 3 6 的情况，可以
     *  2 4 5 的情况只要挪一个7或者两个7到余数中，就能成立
     * @author rays1
     *
     */
    static class Solution {
    
        public String isBuild(int x) {
            int t = x % 7;
            if (t%3 == 0 || x/t >2)
                return "YES";
            return "NO";
        }
    
    }
    
    public static void main(String[] args) {
        
        int x = 19;
        
        Out.p(new Solution().isBuild(x));
        
    }

}
