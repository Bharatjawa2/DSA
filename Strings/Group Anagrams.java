class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String a=new String(c);
            if(!map.containsKey(a)){
                map.put(a,new ArrayList<>());
            }
            map.get(a).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
