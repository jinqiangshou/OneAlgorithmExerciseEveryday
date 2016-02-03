/* *********************************Question************************************
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * *****************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-02-03
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
            return null;
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
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode myhead = new ListNode(0);
        myhead.next = head;
        ListNode fast = myhead;
        ListNode slow = myhead;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part1 = head;
        ListNode part2 = slow.next;
        part2 = reverseList(part2);
        while(part1 != null && part2 != null){
            if(part1.val != part2.val){
                return false;
            }
            part1 = part1.next;
            part2 = part2.next;
        }
        return true;
    }
}
