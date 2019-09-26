package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      代码是基础版本是从 1 到 n，有一天一个人提交了一个坏版本导致后序版本的单元测试失败。
 *      找到第一个坏版本。
 *      
 *      可以调用 isBadVersion 来判断某个版本是否是坏版本。
 *
 * 用例：
 *      ```
 *      Given n = 5:
 *          isBadVersion(3) -> false
 *          isBadVersion(5) -> true
 *          isBadVersion(4) -> true
 *      
 *      Here we are 100% sure that the 4th version is the first bad version.
 *      ```
 *
 * 挑战：
 *      尽可能少的调用 isBadVersion
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/first-bad-version/description
 * @date   2019-07-11 18:29:51
 */
public class L_0074_First_Bad_Version {

    /**
     * 二分搜索
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int findFirstBadVersion(int n) {
            
            long start = 1, end = n;
            while (start < end) {
                long mid = (start + end)/2;
                if (SVNRepo.isBadVersion((int)mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            
            return (int)start;
        }
        
    }
    
    static class SVNRepo {
        static int badVersion = 100000000;
        public static boolean isBadVersion(int k) {return k >= badVersion;}
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().findFirstBadVersion(100000000));
    }

}
