
class Solution {
    public int maxDepth(TreeNode root) {
        return solve(root);
    }
    int solve(TreeNode root){
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        return Math.max(left,right)+1;
    }
}
