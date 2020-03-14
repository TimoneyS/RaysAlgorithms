package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Reconstruct Itinerary
 * -----------------------------------------------------------------------------
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * Note:
 * 	If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary [JFK, LGA] has a smaller lexical order than [JFK, LGB].
 * 	All airports are represented by three capital letters (IATA code).
 * 	You may assume all tickets form at least one valid itinerary.
 *
 * Example:
 *      Example 1
 *      Input: [[MUC, LHR], [JFK, MUC], [SFO, SJC], [LHR, SFO]]
 *      Output: [JFK, MUC, LHR, SFO, SJC]
 *      Example 2
 *      Input: [[JFK,SFO],[JFK,ATL],[SFO,ATL],[ATL,JFK],[ATL,SFO]]
 *      Output: [JFK,ATL,JFK,SFO,ATL,SFO]
 *      Explanation: Another possible reconstruction is [JFK,SFO,ATL,JFK,ATL,SFO].
 *                   But it is larger in lexical order.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/reconstruct-itinerary/
 * @since   2020-03-14 13:43:47
 */
public class L0332_Reconstruct_Itinerary {
    static class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, Queue<String>> map = new HashMap<>();
            for (List<String> t : tickets) {
                if (!map.containsKey(t.get(0))) map.put(t.get(0), new PriorityQueue<>());
                map.get(t.get(0)).offer(t.get(1));
            }
            List<String> rs = new ArrayList<>();
            dfs("JFK", map, rs, tickets.size());
            return rs;
        }

        private void dfs(String dst, Map<String, Queue<String>> map, List<String> rs, int limit) {
            if (map.containsKey(dst)&&!map.get(dst).isEmpty()) {
                Queue<String> q = map.get(dst);
                while (!q.isEmpty()) {
                    dfs(q.poll(), map, rs, limit - 1);
                }
            }
            rs.add(0, dst);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
