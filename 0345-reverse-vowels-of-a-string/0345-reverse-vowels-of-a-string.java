class Solution {
    List<Character> v = List.of('a','e','i','o','u','A','E','I','O','U');
    public String reverseVowels(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(v.contains(c)){
                stk.push(c);
            }
        }
          for(char c : s.toCharArray()){
            if(v.contains(c)){
                sb.append(String.valueOf(stk.pop()));
            }
            else{
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();


    }
}