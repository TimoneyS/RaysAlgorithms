package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Design Twitter
 * -----------------------------------------------------------------------------
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。
 * 你的设计需要支持以下的几个功能：
 *      postTweet(userId, tweetId): 创建一条新的推文
 *      getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
 *                           推文必须按照时间顺序由最近的开始排序。
 *      follow(followerId, followeeId): 关注一个用户
 *      unfollow(followerId, followeeId): 取消关注一个用户
 *
 * Example:
 *      Example 1
 *      Twitter twitter = new Twitter();
 *      // User 1 posts a new tweet (id = 5).
 *      twitter.postTweet(1, 5);
 *      // User 1's news feed should return a list with 1 tweet id -> [5].
 *      twitter.getNewsFeed(1);
 *      // User 1 follows user 2.
 *      twitter.follow(1, 2);
 *      // User 2 posts a new tweet (id = 6).
 *      twitter.postTweet(2, 6);
 *      // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 *      // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 *      twitter.getNewsFeed(1);
 *      // User 1 unfollows user 2.
 *      twitter.unfollow(1, 2);
 *      // User 1's news feed should return a list with 1 tweet id -> [5],
 *      // since user 1 is no longer following user 2.
 *      twitter.getNewsFeed(1);
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/design-twitter/
 * @since   2020-03-16 23:06:28
 */
public class L0355_Design_Twitter {
    static class Twitter {

        Map<Integer, List<int[]>> tweetMap = new HashMap<>();
        Map<Integer, Set<Integer>>  watchMap = new HashMap<>();
        static int time = 0;

        /** Initialize your data structure here. */
        public Twitter() {
        }
        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            tweetMap.putIfAbsent(userId, new ArrayList<>());
            tweetMap.get(userId).add(new int[]{time++, tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
            pollTweet(userId, pq);
            if (watchMap.containsKey(userId)) {
                for (int id : watchMap.get(userId)) {
                    pollTweet(id, pq);
                }
            }
            List<Integer> rs = new ArrayList<>(10);
            while (!pq.isEmpty())
                rs.add(0, pq.poll()[1]);
            return rs;
        }

        private void pollTweet(int userId, PriorityQueue<int[]> pq) {
            if (!tweetMap.containsKey(userId)) return;
            List<int[]> l = tweetMap.get(userId);
            for (int i = 0; i < 10 && i < l.size(); i++) {
                pq.add(l.get(l.size() - i - 1));
                if (pq.size() > 10) pq.poll();
            }
        }

        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) return;
            watchMap.putIfAbsent(followerId, new HashSet<>());
            watchMap.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (watchMap.containsKey(followerId))
                watchMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {

        Twitter t = new Twitter();

        t.postTweet(1,5);
        t.postTweet(2,3);
        t.postTweet(1,101);
        t.postTweet(2,13);
        t.postTweet(2,10);
        t.postTweet(1,2);
        t.postTweet(1,94);
        t.postTweet(2,505);
        t.postTweet(1,333);
        t.postTweet(2,22);
        t.postTweet(1,11);
        t.postTweet(1,205);
        t.postTweet(2,203);
        t.postTweet(1,201);
        t.postTweet(2,213);
        t.postTweet(1,200);
        t.postTweet(2,202);
        t.postTweet(1,204);
        t.postTweet(2,208);
        t.postTweet(2,233);
        t.postTweet(1,222);
        t.postTweet(2,211);
        Out.p(t.getNewsFeed(1));; // [222,204,200,201,205,11,333,94,2,101]
        t.follow(1,2);
        Out.p(t.getNewsFeed(1));; // [211,222,233,208,204,202,200,213,201,203]
        t.unfollow(1,2);
        Out.p(t.getNewsFeed(1));; // [222,204,200,201,205,11,333,94,2,101]
    }
}
