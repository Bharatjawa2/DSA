class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode curr=head;
        while(curr!=null && count<k){
            curr=curr.next;
            count++;
        }
        if(count<k) return head;
        ListNode newHead=reverse(head,curr);
        head.next=reverseKGroup(curr,k);
        return newHead;
    }
    ListNode reverse(ListNode left,ListNode right){
        ListNode prev=null;
        ListNode curr=left;
        while(curr!=right){
            ListNode next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        return prev;
    }
}
