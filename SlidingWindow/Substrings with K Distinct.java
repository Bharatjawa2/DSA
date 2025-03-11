class Solution {
    int countSubstr(String s, int k) {
        return atleast(s,k)-atleast(s,k+1);
    }
    int atleast(String s,int k){
        int n=s.length();
        int count=0;
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>=k){
                count+=(n-right);
                char c=s.charAt(left);
                left++;
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) map.remove(c);
            }
        }
        return count;
    }
}
