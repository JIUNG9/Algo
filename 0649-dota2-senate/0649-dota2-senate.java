class Solution {
    public String predictPartyVictory(String s) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int idx = 0;
        for(char c : s.toCharArray()){
            if(c == 'R') q1.add(idx++);
            else{
                q2.add(idx++);
            }
        }

        while(!q1.isEmpty() && !q2.isEmpty()){
            if(q1.peek() < q2.peek()){
                q1.add(idx++);
            }
            else{
                q2.add(idx++);
            }
            q1.poll();
            q2.poll();
        }   
        return q1.isEmpty() ? "Dire" : "Radiant";

    }
}