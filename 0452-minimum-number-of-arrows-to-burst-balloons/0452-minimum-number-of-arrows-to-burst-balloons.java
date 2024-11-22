class Solution {
    public int findMinArrowShots(int[][] points) {
      //한 번 쏠 때, 가장 겹치는 부분이 많게 해서 쏜다
      //끝 지점을 기준으로 오름차순 정렬하고, 현재 끝 지점이 이후에 오는 시작지점보다 크다면, 활을 쏘지 않고, 그렇지 않다면 활을 쏜다. 활을 쏜 이후에 끝지점을 업데이트하여 지속적으로 현재 풍선을 쏘는 끝지점과 시작 지점을 확인하여라  마지막에 총 활을 쏜 개수를 구하여라.
      //처음에 한 개는 쏜다고 가정하고, 이후의 두 번째부터 확인하면서 넘어간다.
      int answer = 1;
      
      Arrays.sort(points,(arr1,arr2)->{
        return Integer.compare(arr1[1],arr2[1]);
      });
      int position = points[0][1];
      for(int i = 0; i < points.length; i++){
        if(position >= points[i][0]) continue;
        else{
            position = points[i][1];
            answer++;
        }
      }
      return answer;
    }
}