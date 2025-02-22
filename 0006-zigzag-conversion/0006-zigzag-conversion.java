class Solution {
    public String convert(String s, int numRows) {
        boolean isUpStream = true;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        List<List<Character>> list = new ArrayList<>();
        if(numRows == 1) return s;

        
        for(char c: s.toCharArray()){
            if(isUpStream){
                if(list.size() <= idx) list.add(new ArrayList<>());
                list.get(idx++).add(c);
            }
            else{
                list.get(idx--).add(c);
            }

            if(idx == numRows){
                idx-=2;
                isUpStream =false;
            }
            else if(idx == -1){
                idx+=2;
                isUpStream =true;
            }
        }

        for(List<Character> li : list){
            for(char c: li){
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}