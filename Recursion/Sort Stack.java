class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        solve(s);
        return s;
    }
    void solve(Stack<Integer> st){
        if(st.isEmpty()) return;
        
        int top=st.pop();
        solve(st);
        insertAtBottom(st,top);
    }
    void insertAtBottom(Stack<Integer> st,int element){
        if(st.isEmpty() || st.peek()<element){
            st.push(element);
            return;
        }
        int top=st.pop();
        insertAtBottom(st,element);
        st.push(top);
    }
}
