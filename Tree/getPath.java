class Solution {
    public ArrayList<Integer> Path(TreeNode root, TreeNode target) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        solve(root,target,ans);
        return ans;
    }
    boolean solve(TreeNode root,TreeNode find,List<Integer> list){
        if(root==null) return false;
        list.add(root.val);
        if(root==find) return true;

        if(solve(root.left,find,list) || solve(root.right,find,list)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}
