class RecentCounter {
    private PriorityQueue<Integer> q;
    private int[] times;
    public RecentCounter() {
        q = new PriorityQueue<>();
    }
    
    public int ping(int t) {
        while(!q.isEmpty() && t-3000 > q.peek()){
            q.poll();
        }
        q.add(t);
        return q.size();
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */