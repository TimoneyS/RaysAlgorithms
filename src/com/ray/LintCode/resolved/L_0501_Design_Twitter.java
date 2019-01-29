package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ray.io.Out;

/**
 *
 * 实现一个简单的 twitter，支持以下方法：
 *      1. postTweet(user_id, tweet_text)
 *          发送推文
 *      2. getTimeline(user_id)
 *          获取用户的最近 10 条自己发送的推文, 按照时间由近到远排序.
 *      3. getNewsFeed(user_id)
 *          获取用户的最近 10 条消息推送,包括自己发送和朋友发送的, 按照时间由近到远排序.
 *      4. follow(from_user_id, to_user_id)
 *          用户关注
 *      5. unfollow(from_user_id, to_user_id)
 *          取消关注
 *
 * @author rays1
 *
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
        
        Out.p(new MiniTwitter());
        
    }

}
