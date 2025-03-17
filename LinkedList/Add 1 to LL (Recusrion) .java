// TC: O(N)
// SC: O(N)
class Solution {
    public Node addOne(Node head) {
        int carry=solve(head);
        if(carry==1){
            Node newNode=new Node(1);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }
    int solve(Node head){
        if(head==null){
            return 1;
        }
        int carry=solve(head.next);
        head.data=head.data+carry;
        if(head.data<10) return 0;
        head.data=0;
        return 1;
    }
}
