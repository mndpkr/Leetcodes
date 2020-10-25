//355. Design Twitter
//Runtime: 302 ms, Memory Usage: 45.3 MB

class Twitter {
    Map<Integer, LinkedList<Integer>> followee;
    PriorityQueue<tweet> pq;
    int timer;
    class tweet implements Comparable<tweet>{
        int time;
        int uid;
        int tid;
        tweet(int time, int t, int u){
            this.time = time;
            this.uid = u;
            this.tid = t;
        }
        public int compareTo(tweet t){
            return t.time - this.time;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        timer =0;
        followee = new HashMap<>();
        pq = new PriorityQueue<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        followee.putIfAbsent(userId, new LinkedList<>());  timer++;
        tweet t = new tweet(timer, tweetId, userId);
        pq.add(t);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> lst = followee.getOrDefault(userId, new LinkedList<>());
        int count = 0;
        LinkedList<Integer> linklst = new LinkedList<>();
        LinkedList<tweet> temp = new LinkedList<>();
        //Iterator itr = pq.iterator();
        //System.out.println("------"+lst); 
        while(count<10 && !pq.isEmpty()){
            tweet t = pq.poll();
            //System.out.println(t.tid+"  "+t.uid); 
            if(t.uid==userId || lst.contains(t.uid)){
                linklst.addLast(t.tid);
                count++;
            }
            temp.add(t);
        }
        for(tweet t: temp)
            pq.add(t);
        return linklst;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        LinkedList<Integer> lst = followee.getOrDefault(followerId, new LinkedList<>());
        lst.add(followeeId);
        followee.put(followerId, lst);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        LinkedList<Integer> lst = followee.get(followerId);
        if(lst != null){
            lst.removeFirstOccurrence(followeeId);
            followee.put(followerId, lst);
        }           
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
