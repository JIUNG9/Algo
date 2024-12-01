class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        //심을 수 있는 경우, 심고 난 이후 표시
        //심지 못 하는 경우 현재 것이 1이거나 좌, 우에 1이 있는 경우, 범위체크
        for(int i = 0; i < f.length; i++){
            if(f[i]==1 || (i > 0 && f[i-1]==1) || (i + 1 < f.length && f[i+1]==1)) continue;
                n--;
                f[i]=1;
        }        
        return n > 0 ? false : true;
    }
}