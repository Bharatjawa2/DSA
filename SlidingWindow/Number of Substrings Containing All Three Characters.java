class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int left=0;
        int[] freq=new int[3];
        int ans=0;
        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            freq[c-'a']++;
            while(solve(freq)){
                ans+=(n-right);
                char ch=s.charAt(left);
                left++;
                freq[ch-'a']--;
            }
        }
        return ans;
    }
    boolean solve(int[] freq){
        return freq['a'-'a']>0 && freq['b'-'a']>0 && freq['c'-'a']>0;
    }
}

// Approach is same
