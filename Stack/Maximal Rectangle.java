class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        if(matrix==null || m==0 || n==0) return 0;

        int[] arr=new int[m];
        int ans=0;

        for(int row=0;row<n;row++){
            for(int i=0;i<m;i++){
                if(matrix[row][i]=='1') arr[i]=arr[i]+1;
                else arr[i]=0;
            }
            ans=Math.max(ans,Histo(arr));
        }
        return ans;
    }
    int Histo(int[] arr){
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();
        NSE(st,arr,right,n);
        st.clear();
        PSE(st,arr,left,n);
        int ans=0;
        for(int i=0;i<n;i++){
            int total=(i-left[i])+(right[i]-i)-1;
            ans=Math.max(ans,total*arr[i]);
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
