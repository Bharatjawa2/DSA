class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return res.next;        
    }
}


// we make Dummy Node to handle Edge Cases :  - Removing the head node of the list.
//                                              - Handling cases where the list is very short.


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        
        if(n==size) return head.next;

        int target=size-n;
        curr=head;
        for(int i=0;i<target-1;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
}
