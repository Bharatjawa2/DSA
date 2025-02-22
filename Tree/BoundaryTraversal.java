class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
       ArrayList<Integer> ans=new ArrayList<>();
       if(isLeaf(node)==false) ans.add(node.data);
       addLeftBoundary(node,ans);
       addLeaves(node,ans);
       addRightBoundary(node,ans);
       return ans;
    }
    
    void addLeftBoundary(Node root,ArrayList<Integer> ans){
        Node curr=root.left;
        while(curr!=null){
            if(isLeaf(curr)==false) ans.add(curr.data);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    
    void addRightBoundary(Node root,ArrayList<Integer> ans){
        Node curr=root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(isLeaf(curr)==false) temp.add(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
        }
        
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }
    
    void addLeaves(Node root,ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null) addLeaves(root.left,ans);
        if(root.right!=null) addLeaves(root.right,ans);
    }
    
    boolean isLeaf(Node root){
        if(root.left==null && root.right==null) return true;
        return false;
    }
}
