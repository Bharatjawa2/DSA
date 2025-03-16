class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null){
            int temp=slow.val;
            slow.val=fast.val;
            fast.val=temp;

            if(fast.next!=null && fast.next.next!=null){
                slow=slow.next.next;
                fast=fast.next.next;
            }else{
                break;
            }
        }
        return head;
    }
}
