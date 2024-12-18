class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int idx = 0;
        int len = nums1.length;
        int sum = 0;
        int answer = 0;
        Pair[] pairs = new Pair[len];
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (p1, p2) -> p1.num1 - p2.num1);

        for(int i = 0; i < len; i++){
            Pair p = new Pair(nums1[i],nums2[i]);
            pairs[i] = p;
        }

        Arrays.sort(pairs,(p1,p2)-> p2.num2 - p1.num2);

        for(int i = 0; i < len; i++){
                
            if(pq.size() < k){
                pq.offer(pairs[i]);
                sum+=pairs[i].num1;
            }
            else if(pq.peek().num1 < pairs[i].num1){
                sum-=pq.poll().num1;
                sum+=pairs[i].num1;
                pq.add(pairs[i]);
            }
            if(pq.size() == k ) answer = Math.max(sum * pairs[i].num2,answer);
            

        }
            return answer;

        


    }
    class Pair  {
        private int num1;
        private int num2;

        public Pair(int num1, int num2){
            this.num1 = num1;
            this.num2 = num2;
        }


    }
}