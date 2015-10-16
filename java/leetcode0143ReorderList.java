/* *********************************************Question***********************************************
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * ****************************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-10-16
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * */
public class Solution {
    
    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode myhead = head;
        while(myhead != null){
            len ++;
            myhead = myhead.next;
        }
        if(len <= 2){
            return;
        }
        int half = len / 2;
        myhead = head;
        while(len - half > 1){
            myhead = myhead.next;
            half ++;
        }
        ListNode merge = head;
        ListNode part1 = head.next;
        ListNode part2 = myhead.next;
        myhead.next = null;
        part2 = reverseList(part2);
        
        for(int i = 1; i < len;){
            merge.next = part2;
            part2 = part2.next;
            merge = merge.next;
            i++;
            if(i < len){
                merge.next = part1;
                part1 = part1.next;
                merge = merge.next;
                i++;
            }
        }
    }
}
