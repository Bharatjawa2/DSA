class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int ans=0;
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>intervals[i][0]) ans++;
            else{
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        return ans;
    }
}
