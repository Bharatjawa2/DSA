class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int leftMax=height[0];
        int rightMax=height[n-1];
        int ans=0;

        while(left<right){
            if(leftMax<rightMax){
                left++;
                leftMax=Math.max(leftMax,height[left]);
                ans+=leftMax-height[left];
            }else{
                right--;
                rightMax=Math.max(rightMax,height[right]);
                ans+=rightMax-height[right];
            }
        }
        return ans;
    }
}
