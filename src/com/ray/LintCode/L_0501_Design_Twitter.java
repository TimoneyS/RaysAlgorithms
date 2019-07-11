package com.ray.LintCode;

import com.ray.io.Out;

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

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
