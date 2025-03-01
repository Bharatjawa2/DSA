class Solution { // 132
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int find=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                find=i;
                break;
            }
        }
        if(find==-1){
            reverse(nums,0,n-1);
            return ;
        }
        for(int i=n-1;i>find;i--){
            if(nums[i]>nums[find]){
                swap(nums,find,i);
                break;
            }
        }

        reverse(nums,find+1,n-1);
    }

    void swap(int[] nums,int start,int end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }

    void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start++,end--);
        }
    }
}
