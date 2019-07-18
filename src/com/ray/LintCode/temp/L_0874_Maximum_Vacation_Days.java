package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      LintCode wants to give one of its best employees the option to travel among `N` cities to collect algorithm problems. But all work and no play makes Jack a dull boy, you could take vacations in some particular cities and weeks. Your job is to schedule the traveling to maximize the number of vacation days you could take, but there are certain rules and restrictions you need to follow.
 *      
 *      **Rules and restrictions:**
 *      1. You can only travel among `N` cities, represented by indexes from 0 to N-1. Initially, you are in the city indexed 0 on **Monday**.
 *      2. The cities are connected by flights. The flights are represented as a `N*N` matrix (not necessary symmetrical), called **flights** representing the airline status from the city i to the city j. If there is no flight from the city i to the city j, **flights[i][j] = 0**; Otherwise, **flights[i][j] = 1**. Also, **flights[i][i] = 0** for all i.
 *      3. You totally have `K` weeks (**each week has 7 days**) to travel. You can only take flights at most once **per day** and can only take flights on each week's **Monday** morning. Since flight time is so short, we don't consider the impact of flight time.
 *      4. For each city, you can only have restricted vacation days in different weeks, given an `N*K` matrix called **days** representing this relationship. For the value of `days[i][j]`, it represents the maximum days you could take vacation in the city `i` in the week `j+1`.
 *      You're given the **flights** matrix and **days** matrix, and you need to output the maximum vacation days you could take during `K` weeks.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：flights = [[0,1,1],[1,0,1],[1,1,0]]，days = [[1,3,1],[6,0,3],[3,3,3]]
 *      Output：12
 *      Explanation：
 *      Ans = 6 + 3 + 3 = 12. 
 *      
 *      One of the best strategies is:
 *      1st week : fly from city 0 to city 1 on Monday, and play 6 days and work 1 day. 
 *      (Although you start at city 0, we could also fly to and start at other cities since it is Monday.) 
 *      2nd week : fly from city 1 to city 2 on Monday, and play 3 days and work 4 days.
 *      3rd week : stay at city 2, and play 3 days and work 4 days.
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input： flights = [[0,0,0],[0,0,0],[0,0,0]]，days = [[1,1,1],[7,7,7],[7,7,7]]
 *      Output：3
 *      Explanation：
 *      Ans = 1 + 1 + 1 = 3. 
 *      
 *      Since there is no flights enable you to move to another city, you have to stay at city 0 for the whole 3 weeks. 
 *      For each week, you only have one day to play and six days to work. 
 *      So the maximum number of vacation days is 3.
 *      ```
 *      
 *      **Example 3:**
 *      ```
 *      Input：flights = [[0,1,1],[1,0,1],[1,1,0]]，days = [[7,0,0],[0,7,0],[0,0,7]]
 *      Output：21
 *      Explanation：
 *      Ans = 7 + 7 + 7 = 21
 *      
 *      One of the best strategies is:
 *      1st week : stay at city 0, and play 7 days. 
 *      2nd week : fly from city 0 to city 1 on Monday, and play 7 days.
 *      3rd week : fly from city 1 to city 2 on Monday, and play 7 days.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-vacation-days/description
 * @date   2019-07-11 18:38:11
 */
public class L_0874_Maximum_Vacation_Days {

    /**
     * 深度优先搜索，需要注意的是，虽然图中没有给出到达本地的航班，但是实际上的结点可以选择留在原地。
     * 效果和本地到本地的航班是一致的。因此需要考虑 i->i的情况
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        int[][] mem;
        
        public int maxVacationDays(int[][] flights, int[][] days) {
            mem = new int[flights.length][days[0].length];
            return dfs(flights, days, 0, 0, 0);
        }
        
        /**
         * 第 i 天 在城市 j，已经休假 base 天后，可以得到的最大值。
         * 
         * @param flights
         * @param days
         * @param week
         * @param week
         * @param base
         * @return
         */
        private int dfs(int[][] flights, int[][] days, int i, int week,  int base) {
            if (week >= days[0].length) return base;
            if (mem[i][week] == 0) {
                int rs = base;
                for (int j = 0; j < flights[i].length; j++) {
                    if (flights[i][j] == 1) {
                        rs = Math.max(rs, dfs(flights, days, j, week+1, base + days[j][week]));
                    }
                }
                rs = Math.max(rs, dfs(flights, days, i, week+1, base + days[i][week]));
                
                mem[i][week] = rs - base;
            }
            return base + mem[i][week];
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
