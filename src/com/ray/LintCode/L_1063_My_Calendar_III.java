package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Implement a `MyCalendarThree` class to store your events. A new event can **always** be added.

Your class will have one method, `book(int start, int end)`. Formally, this represents a booking on the half open interval `[start, end)`, the range of real numbers `x` such that `start <= x < end`.

A K-booking happens when **K** events have some non-empty intersection (ie., there is some time that is common to all K events.)

For each call to the method `MyCalendar.book`, return an integer `K` representing the largest integer such that there exists a `K`-booking in the calendar.

Your class will be called like this: `MyCalendarThree cal = new MyCalendarThree(); MyCalendarThree.book(start, end)`
 *
 * Example :
 *   **Example 1**

```plain
Input:
MyCalendarThree()
book(10,20)
book(50,60)
book(10,40)
book(5,15)
book(5,10)
book(25,55)

Output: [1,1,2,3,3,3]
Explanation: 
The first two events can be booked and are disjoint, so the maximum K-booking is a 1-booking.
The third event [10, 40) intersects the first event, and the maximum K-booking is a 2-booking.
The remaining events cause the maximum K-booking to be only a 3-booking.
Note that the last event locally causes a 2-booking, but the answer is still 3 because
eg. [10, 20), [10, 40), and [5, 15) are still triple booked.
```

**Example 2**

```plain
Input:
MyCalendarThree()
book(1,2)
book(1,2)
book(2,3)

Output: [1,2,2]
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/my-calendar-iii/description
 * @date   2019-07-03 17:37:40
 */
public class L_1063_My_Calendar_III {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
