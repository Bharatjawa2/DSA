class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans= new ArrayList<>();
        if (digits == null || digits.isEmpty()) return ans;
        HashMap<Character,String> map=new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        return solve(digits,0,map,ans,new StringBuilder());
    }

    List<String> solve(String a,int index,HashMap<Character,String> map,List<String> ans,StringBuilder sb){
        if(index==a.length()){
            ans.add(sb.toString());
            return ans;
        }

        char ch=a.charAt(index);
        String digit=map.get(ch);

        for(char c:digit.toCharArray()){
            sb.append(c);
            solve(a,index+1,map,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return ans;
    }
}
