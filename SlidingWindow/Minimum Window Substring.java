class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[] freq=new int[256];
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int left=0;
        int start=0;
        int length=Integer.MAX_VALUE;
        String ans="";

        int x=0;
        int y=map.size();

        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            freq[c]++;
            if(map.containsKey(c) && freq[c]==map.get(c)){
                x++;
            }
            while(x==y){
                if(right-left+1<length){
                    length=right-left+1;
                    start=left;
                }
                char d=s.charAt(left);
                freq[d]--;
                if(map.containsKey(d) && freq[d]<map.get(d)){
                    x--;
                }
                left++;
            }
            
        }
        return length==Integer.MAX_VALUE ? "" : s.substring(start,start+length);
    }
}
