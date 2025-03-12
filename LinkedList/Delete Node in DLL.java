class Solution {
    public Node deleteNode(Node head, int x) {
        if(head==null) return null;
        
        if(x==1){
            head=head.next;
            if(head!=null) head.prev=null;
            return head;
        }
        
        Node temp=head;
        
        for(int i=1;i<x-1;i++){
            if(temp.next==null) return head;
            temp=temp.next;  
        }   
        
        if(temp.next!=null){
            temp.next=temp.next.next;
            if(temp.next!=null){
                temp.next.prev=temp;
            }
        }
        return head;
    }
}
