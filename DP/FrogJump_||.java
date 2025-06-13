class Solution {
    public int maxJump(int[] stones) {
        int n=stones.length;
        int max=stones[1]-stones[0];
        int maxx=stones[n-1]-stones[n-2];
        for(int i=2;i<n;i++){
            max=Math.max(max,stones[i]-stones[i-2]);
        }
        for(int i=n-1;i>=2;i--){
            maxx=Math.max(maxx,stones[i]-stones[i-2]);
        }
        return Math.max(max,maxx);
    }
}
