class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int left=0;
        for(int i=0;i<k;i++) left+=cardPoints[i];
        int max=left;

        for(int i=k-1;i>=0;i--){
            left-=cardPoints[i];
            left+=cardPoints[--n];
            max=Math.max(max,left);
        }
        return max;
    }
}
