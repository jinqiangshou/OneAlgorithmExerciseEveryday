/* **********************************Question***************************************
 * Given a linked list and a value x, partition it such that all nodes less than x come 
 *before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * *********************************************************************************/
 

/* *
 * @author Horst Xu
 * @date 2015-07-26
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode s = small;
        ListNode b = big;
        while(head != null){
            if(head.val < x){
                s.next = head;
                s = s.next;
            }else{
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }
        b.next = null;
        s.next = big.next;
        return small.next;
    }
}
