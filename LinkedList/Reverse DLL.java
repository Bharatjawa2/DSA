class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        if(head==null || head.next==null) return head;
        
        DLLNode curr=head;
        DLLNode prev=null;
        
        while(curr!=null){
            DLLNode next=curr.next;
            curr.next=curr.prev;
            curr.prev=next;
            
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
