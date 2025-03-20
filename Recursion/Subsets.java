class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,nums,ans,new ArrayList<>());
        return ans;
    }
    void solve(int index,int[] nums,List<List<Integer>> ans,List<Integer> list){
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]); // Take
        solve(index+1,nums,ans,list); // Trust
        list.remove(list.size()-1); // Undo
        solve(index+1,nums,ans,list);
    }
}
