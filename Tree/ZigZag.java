class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=true;

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                list.add(node.val);

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                
            }
            if(flag==false) Collections.reverse(list);
            result.add(list);
            flag=!flag;
        }
        return result;
    }
}
