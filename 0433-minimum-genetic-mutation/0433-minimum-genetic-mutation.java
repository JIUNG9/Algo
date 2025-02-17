class Solution {
    public int minMutation(String s, String e, String[] b) {
        Queue<String> q = new LinkedList<>();
        boolean[] visited= new boolean[b.length];
        q.add(s);
        int count = 0;
        while(!q.isEmpty()){
            Queue<String> temp = new LinkedList<>();
            while(!q.isEmpty()){
                String polledStr = q.poll();
                if(polledStr.equals(e)) return count;
                else{
                    for(int i = 0; i < b.length; i++){
                        String bStr = b[i];
                        int idx = 0;
                        int differentCount = 0;
                        for(char c : bStr.toCharArray()){
                            if(c != polledStr.charAt(idx++)){
                                differentCount++;
                            }
                        }

                        if(differentCount == 1 && !visited[i]) {temp.add(bStr); visited[i] = true;}
                    }
                    
                }
            }
                q = temp;
                count++;
        }
        return -1;
    }
}