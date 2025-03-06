// Lower-Bound or Ceil is the smallest element that is greater than or equals to an element.
class Solution {
    static int findCeil(int[] arr, int x) {
        int n=arr.length;
        int low=0;
        int ans=-1;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
