class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=1;
        }
        for(int i=0;i<n-1;i++){
            if(ratings[i]<ratings[i+1]){
                ans[i+1]=ans[i]+1;
            }
        }
        for(int i=n-1;i>0;i--){
            if((ratings[i]<ratings[i-1]) && (ans[i-1]<=ans[i])){
                ans[i-1]=ans[i]+1;
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=ans[i];
        }
        return sum;
    }
}
