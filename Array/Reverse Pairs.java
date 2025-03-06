class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }
    int mergeSort(int[] nums,int low,int high){
        int cnt=0;
        if(low>=high) return cnt;
        int mid=low+(high-low)/2;
        cnt+=mergeSort(nums,low,mid);
        cnt+=mergeSort(nums,mid+1,high);
        cnt+=count(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }
    int count(int[] arr,int low,int mid,int high){
        int cnt=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && arr[i]>2L*arr[right]){
                right++;
            }
            cnt+=(right-(mid+1));
        }
        return cnt;
    }
    void merge(int[] arr,int low,int mid,int high){
        List<Integer> list=new ArrayList<>();
        int left=low;
        int right=mid+1;

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                list.add(arr[left]);
                left++;
            }
            else{
                list.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            list.add(arr[left]);
            left++;
        }
        while(right<=high){
            list.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=list.get(i-low);
        }
    }
}
