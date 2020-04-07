package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Reformat Department Table
 * -----------------------------------------------------------------------------
 * Table: Department
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | revenue       | int     |
 * | month         | varchar |
 * +---------------+---------+
 * (id, month) is the primary key of this table.
 * The table has information about the revenue of each department per month.
 * The month has values in [Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec].
 * Write an SQL query to reformat the table such that there is a department id column and a revenue column for each month.
 * The query result format is in the following example:
 * Department table:
 * +------+---------+-------+
 * | id   | revenue | month |
 * +------+---------+-------+
 * | 1    | 8000    | Jan   |
 * | 2    | 9000    | Jan   |
 * | 3    | 10000   | Feb   |
 * | 1    | 7000    | Feb   |
 * | 1    | 6000    | Mar   |
 * +------+---------+-------+
 * Result table:
 * +------+-------------+-------------+-------------+-----+-------------+
 * | id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
 * +------+-------------+-------------+-------------+-----+-------------+
 * | 1    | 8000        | 7000        | 6000        | ... | null        |
 * | 2    | 9000        | null        | null        | ... | null        |
 * | 3    | null        | 10000       | null        | ... | null        |
 * +------+-------------+-------------+-------------+-----+-------------+
 * Note that the result table has 13 columns (1 for the department id + 12 for the months).
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reformat-department-table/
 * @since   2020-04-07 22:12:45
 */
public class L1301_Reformat_Department_Table {
//    # Write your MySQL query statement below
//    SELECT id,
//    MAX(CASE month WHEN 'Jan' THEN revenue END) Jan_Revenue,
//    MAX(CASE month WHEN 'Feb' THEN revenue END) Feb_Revenue,
//    MAX(CASE month WHEN 'Mar' THEN revenue END) Mar_Revenue,
//    MAX(CASE month WHEN 'Apr' THEN revenue END) Apr_Revenue,
//    MAX(CASE month WHEN 'May' THEN revenue END) May_Revenue,
//    MAX(CASE month WHEN 'Jun' THEN revenue END) Jun_Revenue,
//    MAX(CASE month WHEN 'Jul' THEN revenue END) Jul_Revenue,
//    MAX(CASE month WHEN 'Aug' THEN revenue END) Aug_Revenue,
//    MAX(CASE month WHEN 'Sep' THEN revenue END) Sep_Revenue,
//    MAX(CASE month WHEN 'Oct' THEN revenue END) Oct_Revenue,
//    MAX(CASE month WHEN 'Nov' THEN revenue END) Nov_Revenue,
//    MAX(CASE month WHEN 'Dec' THEN revenue END) Dec_Revenue
//    FROM Department
//    GROUP BY
//    id;
}
