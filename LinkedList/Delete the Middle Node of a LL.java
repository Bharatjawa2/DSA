class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;
        
        ListNode curr=head;
        ListNode slow=head;
        ListNode fast=head;
      
        while(fast!=null && fast.next!=null){
            curr=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
      
        curr.next=curr.next.next;
        return head;
    }
}
