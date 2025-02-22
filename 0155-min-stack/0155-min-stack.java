class MinStack {
    private Stack<Integer> stk;
    private PriorityQueue<Integer> pq;
    public MinStack() {
        pq = new PriorityQueue<>();
        stk = new Stack<>();
    }
    public void push(int val) {
        pq.add(val);
        stk.add(val);
    }
    
    public void pop() {
        int val = stk.pop();
        pq.remove(val);
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */