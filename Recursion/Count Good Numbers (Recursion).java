class Solution {
    public static List<String> generateBinaryStrings(int n) {
        List<String> ans=new ArrayList<>();
        solve(n,"",ans);
        return ans; 
    }
    public static void solve(int n,String curr,List<String> ans){
        if(curr.length()==n){
            ans.add(curr);
            return;
        }
        solve(n,curr+"0",ans);
        if(curr.length()==0 || curr.charAt(curr.length()-1)=='0')
        solve(n,curr+"1",ans);
    }
}
