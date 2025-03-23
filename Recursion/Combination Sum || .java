class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
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
            if(i>index && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            solve(i+1,arr,ans,target-arr[i],list);
            list.remove(list.size()-1);
        }
    }
}
