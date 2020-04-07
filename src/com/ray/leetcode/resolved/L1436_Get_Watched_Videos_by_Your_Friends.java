package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Get Watched Videos by Your Friends
 * -----------------------------------------------------------------------------
 * There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends respectively for the person with id = i.
 * Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on. In general, the level k of videos are all watched videos by people with the shortest path exactly equal to k with you. Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing). For videos with the same frequency order them alphabetically from least to greatest. 
 *
 * Example:
 *      Example 1
 *      Input: watchedVideos = [[A,B],[C],[B,C],[D]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 *      Output: [B,C] 
 *      Explanation: 
 *      You have id = 0 (green color in the figure) and your friends are (yellow color in the figure):
 *      Person with id = 1 -> watchedVideos = [C] 
 *      Person with id = 2 -> watchedVideos = [B,C] 
 *      The frequencies of watchedVideos by your friends are: 
 *      B -> 1 
 *      C -> 2
 *      Example 2
 *      Input: watchedVideos = [[A,B],[C],[B,C],[D]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 *      Output: [D]
 *      Explanation: 
 *      You have id = 0 (green color in the figure) and the only friend of your friends is the person with id = 3 (yellow color in the figure).
 *      Constraints:
 *      	n == watchedVideos.length == friends.length
 *      	2 <= n <= 100
 *      	1 <= watchedVideos[i].length <= 100
 *      	1 <= watchedVideos[i][j].length <= 8
 *      	0 <= friends[i].length < n
 *      	0 <= friends[i][j] < n
 *      	0 <= id < n
 *      	1 <= level < n
 *      	if friends[i] contains j, then friends[j] contains i
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/get-watched-videos-by-your-friends/
 * @since   2020-04-07 22:11:56
 */
public class L1436_Get_Watched_Videos_by_Your_Friends {
    static class Solution {
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
            int n = watchedVideos.size();
            boolean[] marked = new boolean[n];
            // BFS 搜索出所有指定 level 的好友
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(id);
            int size = q.size();
            marked[id] = true;
            while (!q.isEmpty()) {
                id = q.poll();
                if (friends[id] != null) {
                    for (int fid : friends[id]) {
                        if (!marked[fid]) {
                            q.offer(fid);
                            marked[fid] = true;
                        }
                    }
                }
                size --;
                if (size == 0) {
                    size = q.size();
                    level --;
                }
                if (level == 0) break;
            }

            // 统计好友观看的所有视频
            Map<String, Integer> count = new HashMap<>();
            while (!q.isEmpty()) {
                id = q.poll();
                if (watchedVideos.get(id) != null) {
                    watchedVideos.get(id).forEach(video -> {
                        count.put(video, count.getOrDefault(video, 0) + 1);
                    });
                }
            }
            List<String> rs = new ArrayList<>(count.keySet());
            // 排序
            rs.sort((a,b) -> count.get(a).equals(count.get(b)) ? a.compareTo(b) : count.get(a) - count.get(b));
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
