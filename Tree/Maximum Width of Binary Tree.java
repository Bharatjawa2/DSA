class Pair{
    TreeNode node;
    int value;
    Pair(TreeNode node,int value){
        this.node=node;
        this.value=value;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int max=0;

        while(!q.isEmpty()){
            int size=q.size();
            int end=q.peek().value;
            int value=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.peek().node;
                value=q.peek().value;
                q.remove();
                if(node.left!=null) q.add(new Pair(node.left,2*value));
                if(node.right!=null) q.add(new Pair(node.right,2*value+1));
            }
            max=Math.max(max,value-end+1);
        }
        return max;
    }
}
