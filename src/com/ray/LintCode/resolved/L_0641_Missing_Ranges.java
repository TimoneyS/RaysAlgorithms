package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个排序后的整数数组，元素的范围在 [lower, upper] 之间（包含边界）
 * 返回缺少的范围
 * 
 * 例如：
 *      输入：
 *          nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
 *      输出：
 *          ["2", "4->49", "51->74", "76->99"]
 *      解释：
 *          在区间[0,99]中，缺失的区间有：[2,2]，[4,49]，[51,74]和[76,99]
 *
 * @author rays1
 *
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
        
        int[] nums = {2147483647};
        int lower = 0;
        int upper = 2147483647;
        
        Out.p(new Solution().findMissingRanges(nums, lower, upper));
        
    }

}
