class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        solve(root,ans,new ArrayList<Integer>());
        return ans;
    }
    public static void solve(Node root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> list){
        if(root==null) return;
        list.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(list));
        }else{
            if(root.left!=null) solve(root.left,ans,list);
            if(root.right!=null) solve(root.right,ans,list);
        }
        list.remove(list.size()-1);
    }
}
