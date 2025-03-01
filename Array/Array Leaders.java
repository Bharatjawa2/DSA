class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int n=arr.length;
        int[] res=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,arr[i]);
            res[i]=max;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]==res[i]) ans.add(arr[i]);
        }
        return ans;
    }
}
