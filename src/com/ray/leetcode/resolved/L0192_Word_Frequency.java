package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Word Frequency
 * -----------------------------------------------------------------------------
 * Write a bash script to calculate the frequency of each word in a text file words.txt.
 * For simplicity sake, you may assume:
 * 	words.txt contains only lowercase characters and space ' ' characters.
 * 	Each word must consist of lowercase characters only.
 * 	Words are separated by one or more whitespace characters.
 *
 * Example:
 *      Example 1
 *      Assume that words.txt has the following content:
 *      the day is sunny the the
 *      the sunny is is
 *      Your script should output the following, sorted by descending frequency:
 *      the 4
 *      is 3
 *      sunny 2
 *      day 1
 *      Note:
 *      	Don't worry about handling ties, it is guaranteed that each word's frequency count is unique.
 *      	Could you write it in one-line using Unix pipes?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/word-frequency/
 * @since   2020-03-08 21:23:15
 */
public class L0192_Word_Frequency {
//    cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{print $2" "$1}'
}
