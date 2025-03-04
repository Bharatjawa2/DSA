class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue; // remove duplicates
            for(int j=i+1;j<n-1;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue; // remove duplicates
                int x=-(nums[i]+nums[j]);
                if(solve(nums,j+1,n-1,x)){
                    ans.add(Arrays.asList(nums[i],nums[j],x));
                }
            }
        }
        return ans;
    }
    boolean solve(int[] nums,int start,int end,int target){
        int low=start;
        int high=end;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
