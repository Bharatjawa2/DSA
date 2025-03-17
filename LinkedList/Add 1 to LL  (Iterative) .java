// TC: O(3N)
// SC: O(1)

class Solution {
    public Node addOne(Node head) {
        Node rev=reverse(head);
        Node curr=rev;
        int carry=1;
        while(curr!=null){
            curr.data=curr.data+carry;
            if(curr.data>=10){
                curr.data=0;
                carry=1;
            }else{
                carry=0;
                break;
            }
            curr=curr.next;
        }
        Node result;
        if(carry==1){
            Node newNode=new Node(1);
            newNode.next=reverse(rev);
            result=newNode;
        }else{
            result=reverse(rev);
        }
        return result;
    }
    Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node next=head.next;
            head.next=prev;
            
            prev=head;
            head=next;
        }
        return prev;
    }
}
