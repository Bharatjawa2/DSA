class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        HashMap<TreeNode,Boolean> vis=new HashMap<>();
        makeparent(parent,root);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        vis.put(target,true);
        int dist=0;
        while(!q.isEmpty()){
            int n=q.size();
            if(dist==k) break;
            dist++;
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
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
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
}
