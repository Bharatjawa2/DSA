class Solution {
    public int sumSubarrayMaxs(int[] arr) {
        int n=arr.length;
        int MOD=1000000007;
        long[] left=new long[n];
        long[] right=new long[n];
        NGE(arr,right,n);
        PGE(arr,left,n);
        long ans=0;
        for(int i=0;i<n;i++){
            ans=(ans+(long)arr[i]*(i-left[i])*(right[i]-i))%MOD;
        }
        return (int)ans;
    }
    void PGE(int[] arr,long[] left,int n){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.isEmpty()) left[i]=-1;
            else left[i]=st.peek(); 

            st.push(i);
        }
    }
    void NGE(int[] arr,long[] right,int n){
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }

            if(st.isEmpty()) right[i]=n;
            else right[i]=st.peek();
            st.push(i);
        }
    }
}
