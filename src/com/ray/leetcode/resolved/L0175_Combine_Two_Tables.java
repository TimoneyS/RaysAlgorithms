package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Combine Two Tables
 * -----------------------------------------------------------------------------
 * Table: Person
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId is the primary key column for this table.
 * Table: Address
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId is the primary key column for this table.
 * Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:
 * FirstName, LastName, City, State
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/combine-two-tables/
 * @since   2020-03-08 18:51:58
 */
public class L0175_Combine_Two_Tables {
//    select FirstName,LastName,City,State
//    from
//    person p left join address a
//    on
//    p.personid=a.personid;

}
