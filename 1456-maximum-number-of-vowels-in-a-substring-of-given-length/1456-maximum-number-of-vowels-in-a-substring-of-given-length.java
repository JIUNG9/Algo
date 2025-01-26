class Solution {
    
    public int maxVowels(String s, int k) {
        int[] arr = new int[26];
        int count = 0;
        int answer = 0;
        arr['a'-97]++;
        arr['e' - 97]++;
        arr['i' - 97]++;
        arr['o' - 97]++;
        arr['u' - 97]++;

    

        int right = 0;
        int left = 0;

        while(right < s.length())
        {
            while(right < k){
                if(arr[s.charAt(right++) - 97] == 1) count++;
            }
            
            answer = Math.max(count, answer);

            if(arr[s.charAt(left++) - 97] == 1) count--;
            if(arr[s.charAt(right++) - 97] == 1) count++;

            answer = Math.max(count, answer);
        }
        return answer;
    }
}