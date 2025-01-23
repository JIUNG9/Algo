class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> setA = new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        Set<Integer> setB = new HashSet<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        Set<Integer> copiedA = new HashSet<>(setA);
        Set<Integer> copiedB = new HashSet<>(setB);

        for(Integer i : setA){
            if(setB.contains(i)) copiedA.remove(i);
        }
        for(Integer i : setB){
            if(setA.contains(i)) copiedB.remove(i);
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(copiedA));
        answer.add(new ArrayList<>(copiedB));
        return answer;
    }


}