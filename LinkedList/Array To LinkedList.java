class Solution {
    static Node constructLL(int arr[]) {
        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newhead=new Node(arr[i]);
            temp.next=newhead;
            temp=newhead;
        }
        return head;
    }
}
