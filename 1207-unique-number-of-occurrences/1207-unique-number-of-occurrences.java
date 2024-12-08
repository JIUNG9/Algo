class Solution {
    public boolean uniqueOccurrences(int[] arr) {


        if(arr.length == 2 && arr[0] != arr[1]) return false;

        int[] freq = new int[1001];
        Arrays.sort(arr);
        int idx = 1;

        while(idx < arr.length){
            int count = 1;
            while(idx < arr.length && arr[idx-1] == arr[idx]){
                idx++;
                count++;
            }
            freq[count]++;
            if(freq[count]!=1) return false;
            idx++;
        }
        
        return true;
     


        }
            

    }
