package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * X of a Kind in a Deck of Cards
 * -----------------------------------------------------------------------------
 * In a deck of cards, each card has an integer written on it.
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * 	Each group has exactly X cards.
 * 	All the cards in each group have the same integer.
 *
 * Example:
 *      Example 1
 *      Input: deck = [1,2,3,4,4,3,2,1]
 *      Output: true
 *      Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 *      Example 2
 *      Input: deck = [1,1,1,2,2,2,3,3]
 *      Output: false&acute;
 *      Explanation: No possible partition.
 *      Example 3
 *      Input: deck = [1]
 *      Output: false
 *      Explanation: No possible partition.
 *      Example 4
 *      Input: deck = [1,1]
 *      Output: true
 *      Explanation: Possible partition [1,1].
 *      Example 5
 *      Input: deck = [1,1,2,2,2,2]
 *      Output: true
 *      Explanation: Possible partition [1,1],[2,2],[2,2].
 *      Constraints:
 *      	1 <= deck.length <= 10^4
 *      	0 <= deck[i] < 10^4
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * @since   2020-03-27 22:52:11
 */
public class L0950_X_of_a_Kind_in_a_Deck_of_Cards {
    static class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            Arrays.sort(deck);
            int count = 0;
            int gcd = -1;
            for (int i = 0; i < deck.length; i++) {
                count ++;
                if (i + 1 >= deck.length || deck[i] != deck[i+1]) {
                    gcd = gcd == -1 ? count : gcd(gcd, count);
                    count = 0;
                }
            }
            return gcd > 1;
        }

        private int gcd(int a, int b) {
            return a < b ? gcd(b, a) : a % b == 0 ? b : gcd(b, a % b);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
