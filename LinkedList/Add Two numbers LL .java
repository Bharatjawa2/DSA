class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode left=l1;
        ListNode right=l2;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;

        while(left!=null || right!=null){
            int sum=carry;
            if(left!=null) sum+=left.val;
            if(right!=null) sum+=right.val;
            ListNode newNode=new ListNode(sum%10);
            carry=sum/10;

            curr.next=newNode;
            curr=curr.next;

            if(left!=null) left=left.next;
            if(right!=null) right=right.next;
        }
        if(carry==1){
            ListNode newNode=new ListNode(1);
            curr.next=newNode;
        }
        return dummy.next;        
    }
}
