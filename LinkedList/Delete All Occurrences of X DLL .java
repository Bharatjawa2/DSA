class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        while(head!=null && head.data==x){
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                Node prev=temp.prev;
                Node next=temp.next;
                
                if(prev!=null) prev.next=next;
                if(next!=null) next.prev=prev;
                temp=next;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }
}
