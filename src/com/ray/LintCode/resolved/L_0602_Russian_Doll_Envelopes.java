package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.Comparator;

import com.ray.io.Out;

/**
 * 给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。一个信封的宽高均大于另一个信封时可以放下另一个信封。
 * 求最大的信封嵌套层数。
 * 
 * 如:
 *      给一些信封 [[5,4],[6,4],[6,7],[2,3]]
 *      返回 3  ([2,3] => [5,4] => [6,7])
 * 
 * @Url https://www.lintcode.com/problem/russian-doll-envelopes/description
 * @author rays1
 *
 */
public class L_0602_Russian_Doll_Envelopes {

    /**
     * 将信封的长宽看做是坐标，则问题实际可以转换为二维平面上一些列的点，求最大的连续递增的点集。
     * 
     * 然后将信封按照宽度排序，再按照高度逆排序，可以形成一个高度的数组
     * 
     * 按照顺序，如果高度大于之前的高度，其对应的信封的宽度也一定大于之前的信封的宽度。因此只要寻找最大的高度递增子集即可。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int maxEnvelopes(int[][] envelopes) {
            
            Arrays.sort(envelopes, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]);
                }
            });
            
            
            int dp[] = new int[envelopes.length];
            int rs = 0;
            for(int[] envelope : envelopes){
                int index = Arrays.binarySearch(dp, 0, rs, envelope[1]);
                if(index < 0) index = -index - 1;
                dp[index] = envelope[1];
                if (index == rs) rs++;
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] envelopes = {
                {15,8},
                {2,20},
                {2,14},
                {4,17},
                {8,19},
                {8,9},
                {5,7},
                {11,19},
                {8,11},
                {13,11},
                {2,13},
                {11,19},
                {8,11},
                {13,11},
                {2,13},
                {11,19},
                {16,1},
                {18,13},
                {14,17},
                {18,19}
                };
        
        Out.p(new Solution().maxEnvelopes(envelopes));
        
    }

}
