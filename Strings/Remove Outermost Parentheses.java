class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int left=0,right=0,start=0;
        for(char c:s.toCharArray()){
            if(start==0 && c=='('){
                start++;
                left=0;
                right=0; 
            }else{
                if(c==')') right++;
                if(right>left) start--;
                if(c=='(') left++;
                if(left>=right) sb.append(c); 
            }
        }
        return sb.toString();
    }
}
