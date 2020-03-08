package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Department Top Three Salaries
 * -----------------------------------------------------------------------------
 * The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.
 * +----+-------+--------+--------------+
 * | Id | Name  | Salary | DepartmentId |
 * +----+-------+--------+--------------+
 * | 1  | Joe   | 85000  | 1            |
 * | 2  | Henry | 80000  | 2            |
 * | 3  | Sam   | 60000  | 2            |
 * | 4  | Max   | 90000  | 1            |
 * | 5  | Janet | 69000  | 1            |
 * | 6  | Randy | 85000  | 1            |
 * | 7  | Will  | 70000  | 1            |
 * +----+-------+--------+--------------+
 * The Department table holds all departments of the company.
 * +----+----------+
 * | Id | Name     |
 * +----+----------+
 * | 1  | IT       |
 * | 2  | Sales    |
 * +----+----------+
 * Write a SQL query to find employees who earn the top three salaries in each of the department. For the above tables, your SQL query should return the following rows (order of rows does not matter).
 * +------------+----------+--------+
 * | Department | Employee | Salary |
 * +------------+----------+--------+
 * | IT         | Max      | 90000  |
 * | IT         | Randy    | 85000  |
 * | IT         | Joe      | 85000  |
 * | IT         | Will     | 70000  |
 * | Sales      | Henry    | 80000  |
 * | Sales      | Sam      | 60000  |
 * +------------+----------+--------+
 * Explanation:
 * In IT department, Max earns the highest salary, both Randy and Joe earn the second highest salary, and Will earns the third highest salary. There are only two employees in the Sales department, Henry earns the highest salary while Sam earns the second highest salary.
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/department-top-three-salaries/
 * @since   2020-03-08 19:56:55
 */
public class L0185_Department_Top_Three_Salaries {
    //    如果【跟我一个部门而且工资比我高的人数】不超过2个，那么我一定是部门工资前三
//    select d.Name as Department,e.Name as Employee,e.Salary as Salary
//    from Employee as e left join Department as d
//    on e.DepartmentId = d.Id
//    where e.Id in
//            (
//                    select e1.Id
//                    from Employee as e1 left join Employee as e2
//                    on e1.DepartmentId = e2.DepartmentId and e1.Salary < e2.Salary
//                    group by e1.Id
//                    having count(distinct e2.Salary) <= 2
//            )
//    and e.DepartmentId in (select Id from Department)
//    order by d.Id asc,e.Salary desc
}
