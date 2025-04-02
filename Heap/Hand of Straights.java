class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;
        Arrays.sort(hand);
        for(int i=0;i<n;i++){
            if(hand[i]>=0){
                if(!solve(i,hand,groupSize,n)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean solve(int i,int[] arr,int size,int n){
        int find=arr[i]+1;
        arr[i]=-1;
        int count=1;
        i++;
        while(i<n && count<size){
            if(arr[i]==find){
                find=arr[i]+1;
                arr[i]=-1;
                count++;
            }
            i++;
        }
        if(count==size) return true;
        return false;
    }
}
