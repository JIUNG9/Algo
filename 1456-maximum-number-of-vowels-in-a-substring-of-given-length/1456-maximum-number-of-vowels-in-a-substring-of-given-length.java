class Solution {
    private List<Character> vowels = List.of('a','e','i','o','u');
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int len = s.length();
        int counter = 0;
        int answer =0;

        while(right< k){
            if(vowels.contains(s.charAt(right++))) counter++;
        }
        right--;

        answer = Math.max(answer,counter);

        while(right + 1 < len){
            char leftC = s.charAt(left);
            char movedRightC = s.charAt(right + 1);
            if(vowels.contains(leftC)) counter--;
            if(vowels.contains(movedRightC)) counter++;
            answer = answer = Math.max(answer,counter);
            left++;
            right++;

        }
        return answer;
    }
}