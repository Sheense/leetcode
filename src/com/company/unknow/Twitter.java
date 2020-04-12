package com.company.unknow;

import java.util.*;

public class Twitter {


    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(2,5);
        t.postTweet(1,3);
        t.postTweet(1,101);
        t.postTweet(2,23);
        t.postTweet(2,10);
        t.postTweet(1,2);
        t.postTweet(2,94);
        t.postTweet(2,505);
        t.postTweet(1,333);
        t.postTweet(1,22);
        System.out.println(t.getNewsFeed(2));
        t.follow(2,1);
        System.out.println(t.getNewsFeed(2));
    }

    private Map<Integer, Set<Integer>> follow;

    private Map<Integer, List<Integer>> priMessage;

    private List<Integer> messages;


    /** Initialize your data structure here. */
    public Twitter() {
        follow = new HashMap<>();
        priMessage = new HashMap<>();
        messages = new ArrayList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!follow.containsKey(userId)) {
            follow.put(userId, new HashSet<>());
            priMessage.put(userId, new ArrayList<>());
        }
        messages.add(tweetId);
        priMessage.get(userId).add(messages.size()-1);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!follow.containsKey(userId)) {
            follow.put(userId, new HashSet<>());
            priMessage.put(userId, new ArrayList<>());
            return new ArrayList<>();
        }
        Set<Integer> set = follow.get(userId);
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i:set) {
            map.put(i,priMessage.get(i).size());
        }
        map.put(userId,priMessage.get(userId).size());
        List<Integer> res = new ArrayList<>();
        while(res.size()!=10) {
            int index = -1;
            int byId = -1;
            for(int id:map.keySet()) {
                int size = map.get(id);
                if(size!=0) {
                    if(priMessage.get(id).get(size-1)>index) {
                        index= priMessage.get(id).get(size-1);
                        byId = id;
                    }
                }
            }
            if(index==-1) break;
            else {
                res.add(messages.get(index));
                map.put(byId,map.get(byId)-1);
            }
            index = -1;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId)) {
            follow.put(followerId ,new HashSet<>());
            priMessage.put(followerId, new ArrayList<>());
        }
        if(!follow.containsKey(followeeId)) {
            follow.put(followeeId ,new HashSet<>());
            priMessage.put(followeeId, new ArrayList<>());
        }
        follow.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId)) {
            follow.put(followerId ,new HashSet<>());
            priMessage.put(followerId, new ArrayList<>());
        }
        if(!follow.containsKey(followeeId)) {
            follow.put(followeeId ,new HashSet<>());
            priMessage.put(followeeId, new ArrayList<>());
        }
        if(follow.get(followerId).contains(followeeId)) follow.get(followerId).remove(followeeId);
    }
}
