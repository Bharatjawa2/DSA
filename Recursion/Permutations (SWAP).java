class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,nums,ans);
        return ans;
    }
    void solve(int index,int[] arr,List<List<Integer>> ans){
        if(index==arr.length-1){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(list);
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            solve(index+1,arr,ans);
            swap(arr,i,index);
        }
    }
    void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}
