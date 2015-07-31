/******************************Question********************************
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-01
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode myhead = new ListNode(0);
        myhead.next = head;
        ListNode t1 = myhead;
        int count = 0;
        while(count<m-1){
            t1 = t1.next;
            count++;
        }
        ListNode rec = t1.next;
        ListNode prev = null;
        ListNode curr = t1.next;
        ListNode next = curr.next;
        while(count<n){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
            count++;
        }
        t1.next = prev;
        rec.next = curr;
        return myhead.next;
    }
}
