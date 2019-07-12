package com.ray.LintCode.done;

import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where `N = stations.length`.
 *      
 *      Now, we add `K` more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.
 *      
 *      Return the smallest possible value of D.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]，K = 9
 *      Output：0.50
 *      Explanation：The distance between adjacent gas stations is 0.50
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：stations = [3,6,12,19,33,44,67,72,89,95]，K = 2
 *      Output：14.00
 *      Explanation：construction of gas stations at 86 locations
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimize-max-distance-to-gas-station/description
 * @date   2019-07-11 18:37:34
 */
public class L_0848_Minimize_Max_Distance_to_Gas_Station {

    /**
     * 考虑分配后的方案，那么新的汽油站一定位于两个汽油站之间。
     * 试想两个旧的站点之间加入了k个站点，那么这 k 个站点一定是均匀分布的。
     * 
     * 第一个站点，一定加入距离最大的两个站点
     * 第二个站点，由于第一个站点的加入，最大的站点的距离变为原本的一半，这时候有两种情况
     *      1. 最大站点距离的一般仍然大于其他结点，则将第二个站点仍然加入到最远站点之间，这样最远站点的距离变成了原本的 1/3
     *      2. 最远站点的距离小于其他 两个站点，则加入其他两个站点之间。
     *      
     * 因此可以总结，算法选择的下一个可以加入的气站是  旧站距离 / （新站数 + 1） = dist / (n+1) 最大的站点 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        class Gap {
            double dist, n;
            public Gap(int d) { dist = d; }
            double weight() { return dist/ (n+1);}
        }
        
        public double minmaxGasDist(int[] stations, int k) {
            PriorityQueue<Gap> pq = new PriorityQueue<>((a, b) ->{ return Double.compare(b.weight(), a.weight()); });
            
            for (int i = 1; i < stations.length; i++)
                pq.add(new Gap(stations[i] - stations[i-1]));
            
            
            while (k > 0) {
                Gap g = pq.poll();
                g.n ++;
                k --;
                pq.add(g);
            }
            
            return pq.peek().weight();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
