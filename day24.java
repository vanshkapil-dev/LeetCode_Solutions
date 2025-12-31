class Twitter {
    private static class tweet{
        int id;
        int time;
        tweet(int id, int time){
            this.id=id;
            this.time=time;
        }
    }
    private HashMap<Integer,List<tweet>> tweetMap;
    private HashMap<Integer,Set<Integer>> followMap;
    private int time;

    public Twitter() {
        tweetMap=new HashMap<>();
        followMap=new HashMap<>();
        time=0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new tweet(tweetId,time++));
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<tweet> maxHeap=new PriorityQueue<>((e1,e2)->e2.time-e1.time);

        if(tweetMap.containsKey(userId)){
            maxHeap.addAll(tweetMap.get(userId));
        }

        if(followMap.containsKey(userId)){
            for(int followee:followMap.get(userId)){
                if(tweetMap.containsKey(followee)){
                    maxHeap.addAll(tweetMap.get(followee));
                }
            }
        }
        List<Integer> result=new ArrayList<>();
        while(!maxHeap.isEmpty() && result.size()<10){
            result.add(maxHeap.poll().id);
        }
        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
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