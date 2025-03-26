class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<int[]> dq=new LinkedList<>();
        int[] res=new int[n-k+1];
        int size=0;

        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()[1]<i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.peekLast()[0]<=nums[i]){
                dq.pollLast();
            }

            dq.offerLast(new int[]{nums[i],i});
            if(i>=k-1){
                res[size++]=dq.peekFirst()[0];
            }
        }
        return res;
    }
}
