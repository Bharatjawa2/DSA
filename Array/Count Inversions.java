class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int n=arr.length;
        return mergeSort(arr,0,n-1);
    }
    static int mergeSort(int[] arr,int low,int high){
        int cnt=0;
        if(low>=high) return cnt;
        int mid=low+(high-low)/2;
        cnt+=mergeSort(arr,low,mid);
        cnt+=mergeSort(arr,mid+1,high);
        cnt+=merge(arr,low,mid,high);
        return cnt;
    }
    static int merge(int[] arr,int low,int mid,int high){
        ArrayList<Integer> list=new ArrayList<>();
        int left=low;
        int right=mid+1;
        int cnt=0;
        
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                cnt+=(mid-left+1);
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
        return cnt;
    }
}
