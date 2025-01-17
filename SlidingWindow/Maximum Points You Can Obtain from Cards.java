class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int lsum=0;
        for(int i=0;i<k;i++) lsum+=cardPoints[i];
        int max=lsum;

        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            lsum+=cardPoints[--n];
            max=Math.max(max,lsum);
        }
        return max;
    }
}
