class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] prev=intervals[0];
        List<int[]> list=new ArrayList<>();


        for(int i=1;i<n;i++){
            int[] curr=intervals[i];
            if(prev[1]>=curr[0]){
                prev[1]=Math.max(prev[1],curr[1]);
            }else{
                list.add(prev);
                prev=curr;
            }
        }
        list.add(prev);

        int m=list.size();
        int c=0;
        int[][] ans=new int[m][2];
        for(int[] i:list){
            ans[c][0]=i[0];
            ans[c][1]=i[1];
            c++;
        }
        return ans;
    }
}
