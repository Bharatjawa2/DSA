class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashMap<Character,Character> rev=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i); 
            char b=t.charAt(i); 
            if(map.containsKey(a) && map.get(a)!=b) return false;
            if(rev.containsKey(b) && rev.get(b)!=a) return false;
            map.put(a,b); 
            rev.put(b,a);
        }
        return true;
    }
}
