class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] arr=new int[n+m];
        int i=0,j=0;
        int c=0;
        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                arr[c++]=nums1[i];
                i++;
            }else{
                arr[c++]=nums2[j];
                j++;
            }
        }
        for(int k=i;k<n;k++) arr[c++]=nums1[k];
        for(int k=j;k<m;k++) arr[c++]=nums2[k];

        if((m+n)%2!=0) return (double)arr[(m+n)/2];
        else return (double)(arr[(m+n)/2]+arr[(m+n)/2-1])/2;

    }
}
