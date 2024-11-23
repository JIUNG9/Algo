class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //타겟과 가장 값이 근접한 3개의 원소의 합
        //모든 원소를 순회하면서기준을 기준 값을 기준으로 세 개의 합이 target보다 크다면 right pointer를 왼쪽, 크다면 left 포인터를 오른쪽으로 움직인다. 움직이면서 세 개의 합과 매번 타겟과의 거리를 측정해, 세 개의 합과 타겟과의 거리가 가장 가깝다면 정답 값을 !세 개의 합!으로 업데이트한다.

        int closest = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            int left = i+1;
            int right = len-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int distance = Math.abs(target-sum);
                if(closest > distance) {
                    answer = sum;
                    closest = distance;
                }

                if(sum <= target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
                    return answer;


    }
}