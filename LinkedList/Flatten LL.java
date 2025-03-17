class Solution {
    Node flatten(Node root) {
        Node dummy=new Node(-1);
        Node temp=dummy;
        Node curr=root;
        while(curr!=null){
            temp.bottom=curr;
            temp=curr;
            while(temp.bottom!=null){
                temp=temp.bottom;
            }
            curr=curr.next;
        }
        return sort(dummy.bottom);
    }
    Node sort(Node head){
        if(head==null || head.bottom==null) {
            return head;
        }
        Node fast=head.bottom;
        Node slow=head;
        while(fast!=null && fast.bottom!=null){
            fast=fast.bottom.bottom;
            slow=slow.bottom;
        }
        
        Node l1=head;
        Node l2=slow.bottom;
        slow.bottom=null;
        
        l1=sort(l1);
        l2=sort(l2);
        
        return merge(l1,l2);
    }
    Node merge(Node l1,Node l2){
        Node left=l1;
        Node right=l2;
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.bottom=left;
                left=left.bottom;
            }else{
                temp.bottom=right;
                right=right.bottom;
            }
            temp=temp.bottom;
        }
        if(left!=null){
            temp.bottom=left;
        }
        if(right!=null){
            temp.bottom=right;
        }
        return dummy.bottom;
    }
}
