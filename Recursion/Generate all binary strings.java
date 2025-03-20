class Solution {
    public static List<String> generateBinaryStrings(int n) {
        List<String> ans=new ArrayList<>();
        solve(0,n,ans,new StringBuilder());
        return ans; 
    }
    public static void solve(int index,int n,List<String> ans,StringBuilder sb){
        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }
        
        sb.append('0');
        solve(index+1,n,ans,sb);
        sb.deleteCharAt(sb.length()-1);
        
        if(sb.length()==0 || sb.charAt(sb.length()-1)=='0'){
            sb.append('1');
            solve(index+1,n,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
