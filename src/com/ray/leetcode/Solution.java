package com.ray.leetcode;

import com.ray.io.Out;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] rs = new int[num_people];
        int n = 1;
        while (true) {
            if (candies >= n) {
                rs[(n-1)%num_people] += n;
                candies -= n;
            } else {
                rs[(n-1)%num_people] += candies;
                break;
            }
            n++;
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] rs = new Solution().distributeCandies(7, 4);
        Out.p(rs);

    }
}