package com.ray.LintCode;

import com.ray.io.Out;

/**
 *
 * The code base version is an integer start from 1 to n. One day,
 *  someone committed a bad version in the code case,
 *  so it caused this version and the following versions are all failed in the unit tests.
 *  Find the first bad version.
 *
 * You can call isBadVersion to help you determine which version is the first bad one.
 *  The details interface can be found in the code's annotation part.
 *
 * @author rays1
 *
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
