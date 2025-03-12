class Solution {
    Node constructDLL(int arr[]) {
        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newhead=new Node(arr[i]);
            head.next=newhead;
            newhead.prev=head;
            head=newhead;
        }
        return temp;
    }
}
