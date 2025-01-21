class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> banRight = new LinkedList<>();
        Queue<Character> alive = new LinkedList<>();
        
        while(banRight.size() <= 0){
            for(char c : senate.toCharArray()){
                if(!banRight.isEmpty() && banRight.peek()!=c){
                    banRight.poll();
                }
                else{
                    banRight.add(c);
                    alive.add(c);
                }
                }
                StringBuilder sb = new StringBuilder();
                while(!alive.isEmpty()){
                    if(!banRight.isEmpty() && banRight.peek()!=alive.peek()){
                        alive.poll();
                        banRight.poll();
                    }
                    else{
                        sb.append(String.valueOf(alive.poll()));
                    }
                }
                senate = sb.toString();

        }
        return banRight.poll().equals('D') ? "Dire" : "Radiant";
    }
}