class Solution {
    public List<Integer> DFSTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        preorder(root,list);
        postorder(root,list);
        return list;
    }
    void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    void preorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
    void postorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }
}
