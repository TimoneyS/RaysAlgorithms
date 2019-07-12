package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 描述：
 *      Implement a simple twitter. Support the following method:
 *      
 *      1. `postTweet(user_id, tweet_text)`. Post a tweet.
 *      2. `getTimeline(user_id)`. Get the given user's most recently 10 tweets posted by himself, order by timestamp from most recent to least recent.
 *      3. `getNewsFeed(user_id)`. Get the given user's most recently 10 tweets in his news feed (posted by his friends and himself). Order by timestamp from most recent to least recent.
 *      4. `follow(from_user_id, to_user_id)`. from_user_id followed to_user_id.
 *      5. `unfollow(from_user_id, to_user_id)`. from_user_id unfollowed to to_user_id.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *        postTweet(1, "LintCode is Good!!!")
 *        getNewsFeed(1)
 *        getTimeline(1)
 *        follow(2, 1)
 *        getNewsFeed(2)
 *        unfollow(2, 1)
 *        getNewsFeed(2)
 *      Output:
 *        1
 *        [1]
 *        [1]
 *        [1]
 *        []
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        postTweet(1, "LintCode is Good!!!")
 *        getNewsFeed(1)
 *        getTimeline(1)
 *        follow(2, 1)
 *        postTweet(1, "LintCode is best!!!")
 *        getNewsFeed(2)
 *        unfollow(2, 1)
 *        getNewsFeed(2)
 *      Output:
 *        1
 *        [1]
 *        [1]
 *        2
 *        [2,1]
 *        []
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/design-twitter/description
 * @date   2019-07-11 18:33:33
 */
public class L_0501_Design_Twitter {

    /**
     * 
     * 用 map 保存每个用户的推文
     * 用 map 保存每个用户关注的用户
     * 
     * getTimeline 拉取用户的最后10条推文
     * getNewsFeed 拉取用户自己和关注用户的 最后10条推文,然后按照时间顺序从中拣选10条
     * 
     * @author rays1
     *
     */
    public static class Tweet {
        public static int id_gen = 0;
        public int id;
        public int user_id;
        public String text;
        public static Tweet create(int user_id, String tweet_text) {
            Tweet t = new Tweet();
            t.id = ++id_gen;
            t.user_id = user_id;
            t.text = tweet_text;
            
            return t;
        }
    }
    
    static class MiniTwitter {
        
        Map<Integer, List<Tweet>>   tweetMap;
        Map<Integer, Set<Integer>> followMap;
        
        public MiniTwitter() {
            tweetMap = new HashMap<>();
            followMap = new HashMap<>();            
        }

        public Tweet postTweet(int user_id, String tweet_text) {
            Tweet t = Tweet.create(user_id, tweet_text);
            getTweetList(user_id).add(t);
            return t;
        }

        public List<Tweet> getNewsFeed(int user_id) {
            Set<Integer> followSet = getFollowSet(user_id);
            followSet.add(user_id);
            
            @SuppressWarnings("unchecked")
            List<Tweet>[] ts = new List[followSet.size()];
            int[] idxs = new int[followSet.size()];
            int idx = 0;
            for (int id : followSet) {
                ts[idx] = getTweetList(id);
                idxs[idx] = ts[idx].size()-1;
                idx++;
            }
            
            List<Tweet> rs = new ArrayList<>();
            for (int i = 0; i < 10; i ++) {
                idx = -1;
                for (int j = 0; j < ts.length; j ++) {
                    if (idxs[j] < 0) continue;
                    if (idx == -1  || ts[idx].get(idxs[idx]).id < ts[j].get(idxs[j]).id ) idx = j;
                }
                if (idx == -1) break;
                rs.add(ts[idx].get(idxs[idx]));
                idxs[idx] --;
            }
            
            return rs;
        }

        public List<Tweet> getTimeline(int user_id) {
            List<Tweet> list = getTweetList(user_id);
            List<Tweet> rs = new ArrayList<>();
            int end = list.size() - 1;
            for (int i = list.size() - 1; i >= Math.max(0, end - 9); i -- ) {
                rs.add(list.get(i));
            }
            return rs;
        }

        public void follow(int from_user_id, int to_user_id) {
            getFollowSet(from_user_id).add(to_user_id);
        }
        
        public void unfollow(int from_user_id, int to_user_id) {
            getFollowSet(from_user_id).remove(to_user_id);
        }
        
        private Set<Integer> getFollowSet(int user_id) {
            Set<Integer> followSet = null;
            if (!followMap.containsKey(user_id)) {
                followSet = new HashSet<>();
                followMap.put(user_id, followSet);
            } else {
                followSet = followMap.get(user_id);
            }
            return followSet;
        }
        
        private List<Tweet> getTweetList(int user_id) {
            List<Tweet> tweetList = null;
            if (!tweetMap.containsKey(user_id)) {
                tweetList = new ArrayList<>();
                tweetMap.put(user_id, tweetList);
            } else {
                tweetList = tweetMap.get(user_id);
            }
            return tweetList;
        }
        
    }
    
    public static void main(String[] args) {
        
    }

}
