public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int n=A.size();
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=A.get(i)){
                st.pop();
            }
            
            if(st.isEmpty()) ans.add(-1);
            else ans.add(st.peek());
            st.push(A.get(i));
        }
        return ans;
    }
}
