package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Consecutive Numbers
 * -----------------------------------------------------------------------------
 * Write a SQL query to find all numbers that appear at least three times consecutively.
 * +----+-----+
 * | Id | Num |
 * +----+-----+
 * | 1  |  1  |
 * | 2  |  1  |
 * | 3  |  1  |
 * | 4  |  2  |
 * | 5  |  1  |
 * | 6  |  2  |
 * | 7  |  2  |
 * +----+-----+
 * For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.
 * +-----------------+
 * | ConsecutiveNums |
 * +-----------------+
 * | 1               |
 * +-----------------+
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/consecutive-numbers/
 * @since   2020-03-08 19:44:49
 */
public class L0180_Consecutive_Numbers {
//        SELECT DISTINCT a.Num AS ConsecutiveNums
//        FROM Logs a
//        JOIN Logs b
//        ON (a.Num = b.Num
//                AND b.Id >= a.Id - 2
//                AND b.Id <= a.Id)
//        GROUP BY a.Id
//        HAVING COUNT(*) >= 3
}
