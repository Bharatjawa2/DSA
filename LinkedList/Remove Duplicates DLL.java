class Solution{
    Node removeDuplicates(Node head){
        if(head==null) return null;
        
        Node left=head;
        
        while(left!=null && left.next!=null){
            if(left.data==left.next.data){
                Node temp=left.next;
                left.next=temp.next;
                if(temp.next!=null){
                    temp.next.prev=left;
                }
                temp.prev=null;
                temp.next=null;
            }else{
                left=left.next;
            }
        }
        return head;
    }
}
