class StockSpanner {
    private Stack<int[]> stk;
    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        int counter = 1;
        while(!stk.isEmpty() && stk.peek()[0] <= price){
            counter+=stk.pop()[1];
        }
        stk.push(new int[]{price,counter});
        return counter;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */