// Lower-Bound or Floor is the largest element less than or equal than an element
class Solution {
    static int findFloor(int[] arr, int x) {
        int n=arr.length;
        int low=0;
        int ans=-1;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=x){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
