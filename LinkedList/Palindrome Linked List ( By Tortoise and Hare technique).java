class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newhead=reverse(slow);
        ListNode left=head;
        ListNode right=newhead;
        while(right!=null){
            if(left.val!=right.val){
                reverse(newhead);
                return false;
            }
            left=left.next;
            right=right.next;
        }
        reverse(newhead);
        return true;
    }
    ListNode reverse(ListNode temp){
        if(temp==null || temp.next==null){
            return temp;
        }
        ListNode newhead=reverse(temp.next);
        temp.next.next=temp;
        temp.next=null;
        return newhead;
    }
}
