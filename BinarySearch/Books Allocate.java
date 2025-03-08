import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m>n) return -1;
        int low=0;
        int high=0;
        for(int i:arr){
            low=Math.max(low,i);
            high+=i;
        }

        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(arr,m,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static boolean solve(ArrayList<Integer>arr,int m,int mid){
        int student=1;
        int page=0;
        for(int i=0;i<arr.size();i++){
            if(page+arr.get(i)>mid){
                page=arr.get(i);
                student++;
                if(student>m) return false;
            }
            else page+=arr.get(i);
        }
        return true;
    }
}
