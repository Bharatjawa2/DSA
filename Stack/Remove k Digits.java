class Solution {
    public String removeKdigits(String num, int k) {
        int m=k;
        Stack<Character> st=new Stack<>();
        for(char c:num.toCharArray()){
            if(k>0){
                while(!st.isEmpty() && st.peek()-'0'>c-'0'){
                    k--;
                    st.pop();
                    if(k==0) break;
                }
                st.push(c);
            }else{
                st.push(c);
            }
        }
        while(k-->0) st.pop();
        StringBuilder sb=new StringBuilder();
        boolean flag=true;
        for(char c:st){
            if(flag && c=='0') continue;
            else{
                sb.append(c);
                flag=false;
            }
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}
