class Pair{
    Node node;
    int val;
    Pair(Node node,int val){
        this.node=node;
        this.val=val;
    }
}
class Solution {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Node node=q.peek().node;
            int value=q.peek().val;
            q.remove();
            
            if(!map.containsKey(value)){
                map.put(value,node.data);
            }
            if(node.left!=null) q.add(new Pair(node.left,value-1));
            if(node.right!=null) q.add(new Pair(node.right,value+1));
        }
        for(int i:map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }
}
