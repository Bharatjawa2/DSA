class Solution {
    public int amountOfTime(TreeNode root, int start) {
        int time=0;
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        HashMap<TreeNode,Boolean> vis=new HashMap<>();
        makeparent(parent,root);

        Queue<TreeNode> q=new LinkedList<>();
        TreeNode starting=find(start,root);
        q.add(starting);
        vis.put(starting,true);

        while(!q.isEmpty()){
            time++;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(node.left!=null && !vis.containsKey(node.left)){
                    q.add(node.left);
                    vis.put(node.left,true);
                }
                if(node.right!=null && !vis.containsKey(node.right)){
                    q.add(node.right);
                    vis.put(node.right,true);
                }
                if(parent.containsKey(node) && !vis.containsKey(parent.get(node))){
                    q.add(parent.get(node));
                    vis.put(parent.get(node),true);
                }
            }
        }
        return time==0?0:time-1;
    }
    void makeparent(HashMap<TreeNode,TreeNode> parent,TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                q.add(node.left);
                parent.put(node.left,node);
            }
            if(node.right!=null){
                q.add(node.right);
                parent.put(node.right,node);
            }
        }
    }
    TreeNode find(int start,TreeNode root){
        if(root==null) return null;
        if(root.val==start) return root;

        TreeNode left=find(start,root.left);
        if(left!=null) return left;

        return find(start,root.right);
    }
}
