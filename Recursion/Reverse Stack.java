class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty()) return;
        int top=s.pop();
        reverse(s);
        insertAtBottom(s,top);
    }
    static void insertAtBottom(Stack<Integer> s,int top){
        if(s.isEmpty()){
            s.push(top);
            return;
        }
        int t=s.pop();
        insertAtBottom(s,top);
        s.push(t);
    }
}
