class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first=0;
        int second=0;
        int[] ans=new int[m+n];
        int c=0;
        while(first<m && second<n){
            if(nums1[first]<=nums2[second]){
                ans[c++]=nums1[first];
                first++;
            }else{
                ans[c++]=nums2[second];
                second++;
            }
        }

        for(int i=first;i<m;i++) ans[c++]=nums1[i];
        for(int i=second;i<n;i++) ans[c++]=nums2[i];
        for(int i=0;i<n+m;i++) nums1[i]=ans[i];
    }
}
