/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n=0,m=0;
        ListNode curr=headA;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        curr=headB;
        while(curr!=null){
            m++;
            curr=curr.next;
        }

        while(n>m){
            headA=headA.next;
            n--;
        }
        while(m>n){
            headB=headB.next;
            m--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
