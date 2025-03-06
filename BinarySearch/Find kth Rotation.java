class Solution {
    public int findKRotation(List<Integer> arr) {
        int c=-1;
        int n=arr.size();
        for(int i=0;i<n-1;i++){
            if(arr.get(i)>arr.get(i+1)){
                c=i;
                break;
            }
        }
        return c+1;
    }
}
