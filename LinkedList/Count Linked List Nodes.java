class Solution {
    public int getCount(Node head) {
        int size=1;
        while(head.next!=null){
            size++;
            head=head.next;
        }
        return size;
    }
}
