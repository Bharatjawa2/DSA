class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int max=0;
        int maxfreq=0;
        int[] freq=new int[26];

        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            freq[c-'A']++;
            if(max-maxfreq>k){
                char d=s.charAt(left);
                freq[d-'A']--;
                left++;
                
            }
            maxfreq=Math.max(maxfreq,freq[c-'A']);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
