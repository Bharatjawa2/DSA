class Solution {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] res=new int[N];
        List<Integer> list=new ArrayList<>();
        for(int i=N-1;i>=0;i--){
            int element=arr[i];
            int index=solve(list,element);
            res[i]=list.size()-index;
            list.add(index,element);
        }
        
        int[] ans=new int[queries];
        for(int i=0;i<queries;i++){
            ans[i]=res[indices[i]];
        }
        return ans;
    }
    public static int solve(List<Integer> list,int element){
        int low=0;
        int high=list.size()-1;
        int ans=list.size();
        while(low<=high){
            int mid=low+(high-low)/2;
            if(list.get(mid)>element){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
