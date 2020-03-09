package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * First Bad Version
 * -----------------------------------------------------------------------------
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *      Example 1
 *      Given n = 5, and version = 4 is the first bad version.
 *      call isBadVersion(3) -> false
 *      call isBadVersion(5) -> true
 *      call isBadVersion(4) -> true
 *      Then 4 is the first bad version. 
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/first-bad-version/
 * @since   2020-03-10 01:34:12
 */
public class L0278_First_Bad_Version {
    /* The isBadVersion API is defined in the parent static class VersionControl.
          boolean isBadVersion(int version); */
    public static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            long start = 1, end = n;
            while (start < end) {
                long mid = (start + end)/2;
                if (isBadVersion((int)mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return (int)start;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }

    private static class VersionControl {
        boolean isBadVersion(int version) {
            return version == 1000;
        }
    }
}
