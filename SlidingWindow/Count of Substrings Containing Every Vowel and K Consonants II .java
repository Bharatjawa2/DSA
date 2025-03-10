class Solution {
    public long countOfSubstrings(String word, int k) {
        return atleast(k,word)-atleast(k+1,word);
    }
    long atleast(int k,String word){
        long count=0;
        int consonantCount=0;
        int[] freq=new int[26];
        int n=word.length();
        int left=0;
        for(int right=0;right<n;right++){
            char ch=word.charAt(right); // Expand
            if(isConsonant(ch)) consonantCount++;
            freq[ch-'a']++;

            while(consonantCount>=k && allVowels(freq)){ // Shrink
                count+=(n-right);
                char c=word.charAt(left);
                if(isConsonant(c)) consonantCount--;
                freq[c-'a']--;
                left++;
            }
        }
        return count;
    }
    boolean isConsonant(char c){
        return c!='a' && c!='e' && c!='i' && c!='o' && c!='u';
    }
    boolean allVowels(int[] freq){
        return (freq['a'-'a']>0 && freq['e'-'a']>0 && freq['i'-'a']>0 && freq['o'-'a']>0 && freq['u'-'a']>0);
    }
}
