class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int[] cnt=new int[n+1];
        for(int i:arr){
            cnt[i]++;
        }
        for(int i=1;i<cnt.length;i++){
            if(cnt[i]>1){
                ans.add(i);
                break;
            }
        }
        for(int i=1;i<cnt.length;i++){
            if(cnt[i]==0){
                ans.add(i);
                break;
            }
        }
        return ans;
    }
}
