class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();
        NSE(st,heights,right,n);
        st.clear();
        PSE(st,heights,left,n);
        int ans=0;
        for(int i=0;i<n;i++){
            int total=(i-left[i])+(right[i]-i)-1;
            ans=Math.max(ans,total*heights[i]);
        }
        return ans;
    }
    void NSE(Stack<Integer> st,int[] arr,int[] right,int n){
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()) right[i]=n;
            else right[i]=st.peek();

            st.push(i);
        }
    }
    void PSE(Stack<Integer> st,int[] arr,int[] left,int n){
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()) left[i]=-1;
            else left[i]=st.peek();

            st.push(i);
        }
    }
}
