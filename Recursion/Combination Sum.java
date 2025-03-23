class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,candidates,ans,target,new ArrayList<>());
        return ans;
    }
    void solve(int index,int[] arr,List<List<Integer>> ans,int target,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(index==arr.length || target<0) return;
        
        for(int i=index;i<arr.length;i++){
            list.add(arr[i]);
            solve(i,arr,ans,target-arr[i],list);
            list.remove(list.size()-1);
        }
    }
}
