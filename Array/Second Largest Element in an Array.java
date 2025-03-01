class Solution {
    public int getSecondLargest(int[] arr) {
        if(arr==null || arr.length<2){
            return -1;
        }
        int largest=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]>largest){
                second=largest;
                largest=arr[i];
            }
            else if(arr[i]>second && arr[i]<largest){
                second=arr[i];
            }
        }
        return second==Integer.MIN_VALUE ? -1:second;
    }
}
