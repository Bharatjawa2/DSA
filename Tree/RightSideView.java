class Pair{
    TreeNode node;
    int value;
    Pair(TreeNode node,int value){
        this.node=node;
        this.value=value;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            TreeNode node=q.peek().node;
            int value=q.peek().value;
            q.remove();

            map.put(value,node.val);
            if(node.left!=null) q.add(new Pair(node.left,value+1));
            if(node.right!=null) q.add(new Pair(node.right,value+1));
        }
        for(int i:map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }
}
