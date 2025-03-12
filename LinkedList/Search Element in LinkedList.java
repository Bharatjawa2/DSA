class Solution {
    static boolean searchKey(int n, Node head, int key) {
        while(head.next!=null){
            if(head.data==key) return true;
            head=head.next;
        }
        if(head.data==key) return true;
        return false;
    }
}
