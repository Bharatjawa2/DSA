class Solution {
    Node insertAtEnd(Node head, int x) {
        Node temp=head;
        Node newNode=new Node(x);
        if (head==null) {
            head=newNode;
        }
        else{
            while(temp.next!=null){
              temp=temp.next;
            }
            temp.next=newNode;
        }
        return head;
    }
}
