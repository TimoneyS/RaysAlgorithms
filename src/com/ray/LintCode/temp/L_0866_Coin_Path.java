package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array `A` (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer `B`. The integer B denotes that from any place (suppose the index is `i`) in the array `A`, you can jump to any one of the place in the array `A` indexed `i+1`, `i+2`, …, `i+B` if this place can be jumped to. Also, if you step on the index `i`, you have to pay Ai coins. If Ai is -1, it means you can’t jump to the place indexed `i` in the array.
 *      
 *      Now, you start from the place indexed `1` in the array `A`, and your aim is to reach the place indexed `N` using the minimum coins. You need to return the path of indexes (starting from 1 to N) in the array you should take to get to the place indexed `N` using minimum coins.
 *      
 *      If there are multiple paths with the same cost, return the lexicographically smallest such path.
 *      
 *      If it's not possible to reach the place indexed N then you need to return an empty array.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[1,2,3,4,5]，B=2
 *      Output：[1,3,5]
 *      Explanation：9 is the smallest cost
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：[1,2,4,-1,2]，B=1
 *      Output：[]
 *      Explanation：There is no path from 1 to n
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/coin-path/description
 * @date   2019-07-11 18:38:06
 */
public class L_0866_Coin_Path {

    /**
     * dp[i] = min { dp[i-k] + v[i]}
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> cheapestJump(int[] A, int B) {
            int N = A.length;
            
            @SuppressWarnings("unchecked")
            List<Integer>[] dpl = new List[N];
            int[] dpv           = new int[N];
            dpl[0] = new ArrayList<>();
            dpl[0].add(1);
            dpv[0] = A[0];
            
            for (int i = 1; i < N; i++) {
                if (A[i] == -1) {
                    continue;
                }
                
                int j = -1;
                for (int k = 1; k <= B; k++) {
                    if (i - k < 0) break;
                    if (A[i-k] == -1) continue;
                    if (j == -1 || dpv[i-k] < dpv[j] || dpv[i-k] == dpv[j] && min(dpl[i-k], dpl[j]))
                        j = i-k;
                }
                
                if (j == -1) return new ArrayList<>();
                
                dpl[i] = new ArrayList<>(dpl[j]);
                dpl[i].add(i+1);
                dpv[i] = dpv[j] + A[i];
            }
            return dpl[N-1];
        }

        private boolean min(List<Integer> list, List<Integer> list2) {
            int i = 0;
            while (i < list.size() && i < list2.size()) {
                if (list.get(i) > list2.get(i)) return false;
                i++;
            }
            if (list.size() >= list2.size()) return true;
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
