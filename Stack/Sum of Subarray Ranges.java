class Solution {
    public long subArrayRanges(int[] nums) {
        return (long)(sumMax(nums)-sumMin(nums));
    }
    long sumMax(int[] nums){
        int n=nums.length;
        long[] left=new long[n];
        long[] right=new long[n];
        NLE(nums,right,n);
        PLE(nums,left,n);
        long ans=0;
        for(int i=0;i<n;i++){
            ans=(ans+(long)(nums[i]*(i-left[i])*(right[i]-i)));
        }
        return (long)ans;
    }
    long sumMin(int[] nums){
        int n=nums.length;
        long[] left=new long[n];
        long[] right=new long[n];
        NSE(nums,right,n);
        PSE(nums,left,n);
        long ans=0;
        for(int i=0;i<n;i++){
            ans=(ans+(long)(nums[i]*(i-left[i])*(right[i]-i)));
        }
        return (long)ans;
    }
    void NLE(int[] nums,long[] right,int n){
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }

            if(st.isEmpty()) right[i]=n;
            else right[i]=st.peek();

            st.push(i);
        }
    }
    void NSE(int[] nums,long[] right,int n){
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }

            if(st.isEmpty()) right[i]=n;
            else right[i]=st.peek();

            st.push(i);
        }
    }
    void PLE(int[] nums,long[] left,int n){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }

            if(st.isEmpty()) left[i]=-1;
            else left[i]=st.peek();

            st.push(i);
        }
    }
    void PSE(int[] nums,long[] left,int n){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }

            if(st.isEmpty()) left[i]=-1;
            else left[i]=st.peek();

            st.push(i);
        }
    }
}
