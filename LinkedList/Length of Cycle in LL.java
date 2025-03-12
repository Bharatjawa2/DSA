class Solution {
    public int countNodesinLoop(Node head) {
        Node slow=head;
        Node fast=head;
        int size=0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                int count=1;
                Node temp=slow;
                while(temp.next!=fast){
                    count++;
                    temp=temp.next;
                }
                return count;
            }
        }
        return 0;
    }
}
