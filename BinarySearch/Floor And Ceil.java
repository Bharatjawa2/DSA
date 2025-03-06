public class Solution {
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
      int[] ans=new int[2];
      int low=0;
      int high=n-1;
      Arrays.fill(ans,-1);

      while(low<=high){
          int mid=low+(high-low)/2;
          if(arr[mid]<=x){
              ans[0]=arr[mid];
              low=mid+1;
          }else{
              high=mid-1;
          }
      }
      low=0;
      high=n-1;
      while(low<=high){
          int mid=low+(high-low)/2;
          if(arr[mid]>=x){
              ans[1]=arr[mid];
              high=mid-1;
          }else{
              low=mid+1;
          }
      }
      return ans;
    }
    
}
