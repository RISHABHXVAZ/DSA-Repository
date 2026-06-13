class Twitter {
    Map<Integer, Set<Integer>> follow;
    Map<Integer, List<int[]>> tweets;
    int time;

    public Twitter() {
        follow = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] { time++, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<Integer> ans = new ArrayList<>();

        //khudki post
        if (tweets.containsKey(userId)) {
            for (int[] post : tweets.get(userId)) {
                pq.add(post);
            }
        }

        if (follow.containsKey(userId)) {
            for (int f : follow.get(userId)) {
                if (tweets.containsKey(f)) { // Check if they actually have tweets
                    for (int[] post : tweets.get(f)) {
                        pq.add(post);
                    }
                }
            }
        }

        while (!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll()[1]);
        }

        return ans;

    }

    public void follow(int followerId, int followeeId) {
        follow.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
    if (follow.containsKey(followerId)) {
        follow.get(followerId).remove(followeeId);
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