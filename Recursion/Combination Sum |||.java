class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,arr,ans,k,n,new ArrayList<>());
        return ans;
    }
    void solve(int index,int[] arr,List<List<Integer>> ans,int n,int target,List<Integer> list){
        if(target==0 && list.size()==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || list.size()>n || index==arr.length) return;

        for(int i=index;i<arr.length;i++){
            list.add(arr[i]);
            solve(i+1,arr,ans,n,target-arr[i],list);
            list.remove(list.size()-1);
        }
    }
}
