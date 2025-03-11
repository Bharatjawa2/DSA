class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                ans+=solve(freq);
            }
        }
        return ans;
    }
    
    int solve(int[] freq){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                max=Math.max(max,freq[i]);
                min=Math.min(min,freq[i]);
            }
        }
        if(min==Integer.MAX_VALUE || max==Integer.MIN_VALUE) return 0;
        return max-min;
    }
}
