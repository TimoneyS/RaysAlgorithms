package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a sorted integer array where **the range of elements are in the inclusive range [lower, upper]**, return its missing ranges.
 *
 * 用例：
 *      **Example 1**
 *      ```
 *      Input:
 *      nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
 *      Output:
 *      ["2", "4->49", "51->74", "76->99"]
 *      Explanation:
 *      in range[0,99],the missing range includes:range[2,2],range[4,49],range[51,74] and range[76,99]
 *      ```
 *      **Example 2**
 *      ```
 *      Input:
 *      nums = [0, 1, 2, 3, 7], lower = 0 and upper = 7
 *      Output:
 *      ["4->6"]
 *      Explanation:
 *      in range[0,7],the missing range include range[4,6]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/missing-ranges/description
 * @date   2019-07-11 18:34:41
 */
public class L_0641_Missing_Ranges {

    /**
     * 算法保存左边界，若当前元素和左边界可以连续，则左边界蔓延到当前元素
     * 否则将当前元素-1 作为右边界加入结果。
     * 
     * 实际算法中需要注意 int 类型的 最小值和最大值的问题，数字可能溢出。
     * 这里用long类型屏蔽溢出，勤快的解决方案是条件判断。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            
            List<String> rs = new ArrayList<>();
            
            long left = lower, right;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > left) {
                    right = nums[i];
                    right --;
                    rs.add(left == right ? left +"" : left +"->"+right);
                }
                left = nums[i];
                left++;
            }
            if (upper >= left) {
                right = upper;
                rs.add(left == right ? left +"" : left +"->"+right);
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
