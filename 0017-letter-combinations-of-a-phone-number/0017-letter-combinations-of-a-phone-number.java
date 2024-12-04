class Solution {
    public List<String> letterCombinations(String digits) {
        String[] pat ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> answerList = new ArrayList<>();
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
            answerList = new ArrayList<>(temp);
        }
        return answerList;
    }
}