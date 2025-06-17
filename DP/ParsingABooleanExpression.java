class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        for(char c:expression.toCharArray()){
            if(c=='(' || c=='|' || c=='&' || c=='!' || c=='t' || c=='f'){
                st.push(c);
            }
            else{
                if(c==')'){
                    int countTrue=0,countFalse=0;
                    while(st.peek()!='('){
                        char b=st.pop();
                        if(b=='t') countTrue++;
                        if(b=='f') countFalse++;
                    }
                    st.pop();
                    char operator=st.pop();
                    if(operator=='!'){
                        if(countFalse>0) st.push('t');
                        else st.push('f');
                    }
                    else if(operator=='&'){
                        if(countFalse==0) st.push('t');
                        else st.push('f');
                    }
                    else{
                        if(countTrue>0) st.push('t');
                        else st.push('f');
                    }
                }
            }
        }
        return st.pop()=='t';
    }
}
