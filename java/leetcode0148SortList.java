/* **************************************Question***************************************
 * Sort a linked list in O(n log n) time using constant space complexity.
 ***************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-10-23
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        return mergeList(list1, list2);
    }
    
    ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while(l1 != null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2 != null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return result.next;
    }
}
