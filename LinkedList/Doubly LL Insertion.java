class Solution {
    Node addNode(Node head, int p, int x) {
        Node temp=head;
        for(int i=0;i<p;i++){
            temp=temp.next;
        }
        Node newNode=new Node(x);
        newNode.next=temp.next;
        temp.next=newNode;
        newNode.prev=temp;
        return head;
    }
}
