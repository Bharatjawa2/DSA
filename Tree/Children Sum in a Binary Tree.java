class Solution{
    public static int isSumProperty(Node root){
        return solve(root)==-1?0:1;
    }
    public static int solve(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.data;
        int left=solve(root.left);
        int right=solve(root.right);
        if(left==-1 || right==-1) return -1;
        if(root.data!=left+right) return -1;
        return root.data;
    }
}
