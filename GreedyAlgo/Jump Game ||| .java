class Solution {
    public boolean canReach(int[] nums, int start) {
        int n=nums.length;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int index=q.poll();
                if(index-nums[index]>=0){
                    if(nums[index-nums[index]]==0) return true;
                    else if(nums[index-nums[index]]>0) q.add(index-nums[index]);
                }
                if(index+nums[index]<n){
                    if(nums[index+nums[index]]==0) return true;
                    else if(nums[index+nums[index]]>0) q.add(index+nums[index]);
                }
                nums[index]=-1;
            }
        }
        return false;
    }
}
