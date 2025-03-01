class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int left=0,mid=0,right=n-1;
        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,left,mid);
                mid++;
                left++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,right);
                right--;
            }
        }
    }
    void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}
