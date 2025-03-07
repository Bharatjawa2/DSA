class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int miss=arr[mid]-mid-1;
            if(miss<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return k+high+1;
    }
}
