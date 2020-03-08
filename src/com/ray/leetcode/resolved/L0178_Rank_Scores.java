package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Rank Scores
 * -----------------------------------------------------------------------------
 * Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no holes between ranks.
 * +----+-------+
 * | Id | Score |
 * +----+-------+
 * | 1  | 3.50  |
 * | 2  | 3.65  |
 * | 3  | 4.00  |
 * | 4  | 3.85  |
 * | 5  | 4.00  |
 * | 6  | 3.65  |
 * +----+-------+
 * For example, given the above Scores table, your query should generate the following report (order by highest score):
 * +-------+------+
 * | Score | Rank |
 * +-------+------+
 * | 4.00  | 1    |
 * | 4.00  | 1    |
 * | 3.85  | 2    |
 * | 3.65  | 3    |
 * | 3.65  | 3    |
 * | 3.50  | 4    |
 * +-------+------+
 *
 * select s1.Score,count(distinct(s2.score)) Rank
 * from
 * Scores s1,Scores s2
 * where
 * s1.score<=s2.score
 * group by s1.Id
 * order by Rank;
 *      
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/rank-scores/
 * @since   2020-03-08 19:08:09
 */
public class L0178_Rank_Scores {
// select s1.Score,count(distinct(s2.score)) Rank
// from
// Scores s1,Scores s2
// where
// s1.score<=s2.score
// group by s1.Id
// order by Rank;
    
}
