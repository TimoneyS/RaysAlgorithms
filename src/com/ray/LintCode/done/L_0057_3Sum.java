package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组 S，大小为 n，寻找元素 a b c 使得  a + b + c = 0。
 *      寻找所有可能的不重复的组合。
 *
 * 用例：
 *      用例 1:
 *      输入:[2,7,11,15]
 *      输出:[]
 *      
 *      用例 2:
 *      输入:[-1,0,1,2,-1,-4]
 *      输出:	
 *              [
 *                  [-1, 0, 1],
 *                  [-1, -1, 2]
 *              ]
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/3sum/description
 * @date   2019-07-11 18:17:02
 */
public class L_0057_3Sum {

    /**
     * 对于任意数字 S[i] , 若存在 S[j] S[k] 使得
     *      S[i] + S[j] + S[k] = 0
     * 则
     *      S[i] =  - ( S[j] + S[k] )
     * 
     * 因此从 i 开始，要寻找包含 S[i] 的唯一组合，可以转变为在 S[i+1, n-1] 中寻找数字 S[j] + S[k] = -S[i]
     * 
     * 问题可以转化为若干个 Two_Sum 问题
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public List<List<Integer>> threeSum(int[] numbers) {
            
            List<List<Integer>> rs = new ArrayList<List<Integer>>();
            Set<Integer> hash = new HashSet<>();
            
            Arrays.sort(numbers);
            
            for (int i = 0; i < numbers.length; i++) {
                if (hash.contains(numbers[i])) {
                    continue;
                }
                twoSum(numbers, i, 0-numbers[i], hash, rs);
                hash.add(numbers[i]);
            }
         
            return rs;
        }
        
        private void twoSum(int[] numbers, int i, int target, Set<Integer> basemarked, List<List<Integer>> rs) {
            
            Set<Integer> marked = new HashSet<>();
            Map<Integer, Integer> remain = new HashMap<>();
            
            for (int j = i+1; j < numbers.length; j++) {
                
                if (marked.contains(numbers[j]) || basemarked.contains(numbers[j])) {
                    continue;
                }
                if (remain.containsKey(numbers[j])) {
                    int k = remain.get(numbers[j]);
                    List<Integer> l = new ArrayList<>(3);
                    l.add(numbers[i]);
                    l.add(numbers[k]);
                    l.add(numbers[j]);

                    marked.add(numbers[k]);
                    marked.add(numbers[j]);
                    
                    rs.add(l);
                }
                
                remain.put(target-numbers[j], j);
                
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};
        
        Out.p(new Solution().threeSum(numbers));
        
    }

}
