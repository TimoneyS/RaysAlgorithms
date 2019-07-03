package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
 *   
 *   A student attendance record is a string that only contains the following three characters:
 *   
 *   1. 'A' : Absent.
 *   2. 'L' : Late.
 *   3. 'P' : Present.
 *   
 *   A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * Example :
 *   **Example 1:**
```
Input：1
Output：3
Explanation：'A','P','L'will be rewarded.
```


**Example 2:**
```
Input：2
Output：8
Explanation：
There are eight rewarding records :
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL".
Only "AA" will not be rewarded because it has been absent more than once.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/student-attendance-record-ii/description
 * @date   2019-07-03 17:40:26
 */
public class L_1177_Student_Attendance_Record_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
