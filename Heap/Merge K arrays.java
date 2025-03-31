class Solution{
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[0].length;j++){
               pq.add(arr[i][j]);
           }
       }
       ArrayList<Integer> ans=new ArrayList<>();
       while(!pq.isEmpty()){
           ans.add(pq.poll());
       }
       return ans;
    }
}
