package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Duplicate Emails
 * -----------------------------------------------------------------------------
 * Write a SQL query to find all duplicate emails in a table named Person.
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 * For example, your query should return the following for the above table:
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 * Note: All emails are in lowercase.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/duplicate-emails/
 * @since   2020-03-08 19:50:27
 */
public class L0182_Duplicate_Emails {
//    select distinct(Email) from Person group by Email having count(Email) > 1;
}
