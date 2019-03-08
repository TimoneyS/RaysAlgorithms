package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * n 个不同的课程标记为 1 到 n，每个课程会持续一定的时间 t 并且有一个截至日期 d，用户参加课程必须在 d 天或之前结束。
 * 
 * 给定 n 个成对的 课程持续时间 和 课程截止时间 寻找最多可学习的课程数量。
 * @author rays1
 *
 */
public class L_0696_Course_Schedule_III {

    /**
     * 贪心算法
     * 
     * 只要在截至日期内，课程的过程就像可以随意移动的滑块。
     * 这些滑块可以是按照顺序先后排列的，当遇到一个新的滑块，如果这个滑块不能和已经排列的滑块兼容，则用这个滑块替换最长的滑块。
     * 这样排列后的滑块整体会后移，后移长度为两个滑块之差。
     * 
     *               ||||====             ========
     *               ====|||===           ===|||====
     *               =======||=      ==>  ======||==
     *               =========||          ========||=
     *               =====|||=====        |||==========
     * 
     * 这样就构成了该截至日期内最优解。依次寻找每个截止日期的最优解，最终可以寻找到包含最后截至的课程的最优解，也就是问题的最优解。
     * 
     * 
     * dp[j] = dp[i] + 1 （课程 i 和 dp[i] 兼容）
     *         dp[j] = dp[i] （课程 i 和 dp[i] 不兼容，用课程 i 替换最大课程）
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int scheduleCourse(int[][] courses) {
            
            // 排序
            Arrays.sort(courses, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
            
            // PQ
            PriorityQueue<Integer> pq = new PriorityQueue<>( (o1, o2) -> o2- o1);
            
            int timeline = 0;
            for (int i = 0; i < courses.length; i++) {
                if (courses[i][0] > courses[i][1]) continue;
                
                // 不兼容
                if (timeline + courses[i][0] > courses[i][1]) {
                    if (courses[i][0] < pq.peek()) {
                        timeline += courses[i][0] - pq.poll();
                        pq.add(courses[i][0]);
                    }
                } else {
                    timeline += courses[i][0];
                    pq.add(courses[i][0]);
                }
                
            }
            
            return pq.size();
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] courses = {{5203,1109},{8489,6849},{4713,2057},{8485,916},{2654,2360},{3365,1191},{3535,2559},{2061,6094},{2660,7103},{4732,2648},{3574,2125},{6778,3114},{6412,1559},{653,9401},{5776,5764},{8654,6477},{7914,5507},{2366,2152},{8219,617},{6941,5892},{9540,1875},{4773,1978},{3832,794},{7823,2382},{7990,1689},{4155,9769},{1490,4734},{6087,6415},{8510,6932},{1501,578},{7143,5099},{7117,6454},{5094,4587},{2163,5171},{1073,7825},{5771,2878},{6723,805},{94,4789},{6246,1433},{1397,8807},{3094,9880},{2245,2535},{2906,6055},{9446,1447},{5246,250},{4379,4343},{1457,204},{3745,7666},{673,7645},{4674,5780},{4050,9124},{1179,4453},{4934,4178},{6699,3309},{7999,8923},{7762,4781},{1348,318},{3897,6683},{8966,9570},{333,7526},{64,4375},{5022,1803},{8122,9173},{5543,7028},{2313,7345},{4247,4354},{6794,4207},{5313,5462},{9997,7927},{8490,1542},{4263,5930},{7514,6472},{300,7130},{105,3965},{3229,6656},{6326,3871},{4714,533},{6883,1279},{537,1104},{356,8770},{5015,9858},{7222,1448},{1762,5989},{9338,6619},{7914,4801},{8746,7522},{8836,4870},{3160,2919},{4358,6501},{3761,3587},{1296,8479},{5142,5929},{1491,2861},{516,8107},{6281,3472},{9168,1764},{5599,2837}};
        
        Out.p(new Solution().scheduleCourse(courses));
        
    }

}
