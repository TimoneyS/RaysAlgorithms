package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;
import com.ray.util.Timer;

/**
 * 描述：
 *      给定一个整数数组，寻找两个数字，这两个数字的和正好是给定的值。
 *      
 * 用例：
 *      Example1:
 *      numbers=[2, 7, 11, 15], target=9
 *      return [0, 1]
 *      
 *      Example2:
 *      numbers=[15, 2, 7, 11], target=9
 *      return [1, 2]
 *
 * 挑战：
 *      - O(n) 空间复杂度, O(nlogn) 时间复杂度
 *      - O(n) 空间复杂度, O(n) 时间复杂度
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/two-sum/description
 * @date   2019-07-11 18:17:06
 */
public class L_0056_Two_Sum {

    /**
     * 
     * 如果 a + b = target
     * 则    a = target - b
     * 
     * 如果知道了 a， 那么只要在数组中寻找 target - b 即可。
     * 
     * 可以构建一个数组值到坐标的映射，然后对于每个 a 寻找否存在 target - b 到坐标的映射
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> remain = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                if (remain.containsKey(numbers[i])) {
                    return new int[]{remain.get(numbers[i]), i};
                }
                remain.put(target-numbers[i], i);
            }
            return new int[]{-1, -1};
        }
        
    }
    
    public static void main(String[] args) {
        
        int n = 10;
        int[] numbers = ArrayUtil.intArr(n);
        int target = 2  * n - 1 ;
        
//        int[] numbers = {1,2,3,5};
//        int target = 7;
        
        Out.p(numbers);
        
        Timer.CLICK();
        Out.p(new Solution().twoSum(numbers, target));
        Timer.STOP();
    }

}
