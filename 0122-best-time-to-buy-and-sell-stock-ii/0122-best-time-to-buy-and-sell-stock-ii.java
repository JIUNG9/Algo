class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0 ; i < prices.length; i++){
            if(i==0) stk.push(prices[i]);
            else{
                if(stk.peek() > prices[i]) {stk.pop(); stk.push(prices[i]);}
                else{
                    answer+=(prices[i] - stk.pop());
                    stk.push(prices[i]);
                }
            }
        }
        return answer;

    }
}