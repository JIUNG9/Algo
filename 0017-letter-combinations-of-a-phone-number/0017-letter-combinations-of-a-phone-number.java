class Solution {
    public List<String> letterCombinations(String digits) {
        String[] pat ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> answerList = new ArrayList<>();
        //append 하는 방식 -> 기존의 존재하는 list에 digits의 각 문자별로 존재하는 String pat의 문자를 하나씩 리스트에 넣는다. 이후 다음 문자 또한 String의 존재하는 문자를 이미 존재했던 리스트에 전부 추가하고, 다른 문자 또한 모두 추가한다. 
        //Impl -> 

        if(digits.length()==0) return answerList;

        answerList.add("");

        for(char c : digits.toCharArray()){
            String s = pat[c-'0'];
            List<String> temp = new ArrayList<>();
            for(char ch: s.toCharArray()){
                for(String st : answerList){
                    temp.add(st + String.valueOf(ch));
                }       
            }
            answerList = temp;
        }
        return answerList;
    }
}