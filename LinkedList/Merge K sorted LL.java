class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        for(ListNode node:lists){
            while(node!=null){
                temp.next=node;
                temp=node;
                node=node.next;
            }
        }
        return sort(dummy.next);
    }
    ListNode sort(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode l1=head;
        ListNode l2=slow.next;
        slow.next=null;

        l1=sort(l1);
        l2=sort(l2);

        return merge(l1,l2);
    }
    ListNode merge(ListNode l1,ListNode l2){
        ListNode left=l1;
        ListNode right=l2;
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
            }else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        if(left!=null){
            temp.next=left;
        }
        if(right!=null){
            temp.next=right;
        }
        return dummy.next;
    }
}
