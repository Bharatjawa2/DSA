class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans=new ArrayList<>();
        int sum=0,j=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>s && j<i){     // Here i do always mistake Remember!!!!
                sum-=arr[j];
                j++;
            }
            if(sum==s){
                ans.add(j+1);
                ans.add(i+1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }
} 
