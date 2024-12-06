class Solution {
    public int compress(char[] chars) {
    
        int idx = 0;
        int i = 0;
        if(chars.length==1){
            return chars.length;
        }

        while(i < chars.length){
            char temp = chars[i];
            int count = 0;
            while(i < chars.length && temp == chars[i]){
                i++;
                count++;
            }
            if(count!=1){
                String strCount = String.valueOf(count);
                chars[idx++] = temp;
                for(char c : strCount.toCharArray()){
                    chars[idx++]=c;
                }
            }
            else{
                chars[idx++] = temp;
            }
            
        }
        char[] answer = new char[idx];

        for(int j =0; j < idx; j++){
            answer[j] = chars[j];
        }

        return answer.length;
    }
}