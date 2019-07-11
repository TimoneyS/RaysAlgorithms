package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.
 *      
 *      You can call `isBadVersion` to help you determine which version is the first bad one. The details interface can be found in the code's annotation part.
 *
 * 用例：
 *      ```
 *      Given n = 5:
 *      
 *          isBadVersion(3) -> false
 *          isBadVersion(5) -> true
 *          isBadVersion(4) -> true
 *      
 *      Here we are 100% sure that the 4th version is the first bad version.
 *      ```
 *
 * 挑战：
 *      You should call *isBadVersion* as few as possible.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/first-bad-version/description
 * @date   2019-07-11 18:29:51
 */
public class L_0074_First_Bad_Version {

    static class Solution {
        /**
         * @param n: An integer
         * @return: An integer which is the first bad version.
         */
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
