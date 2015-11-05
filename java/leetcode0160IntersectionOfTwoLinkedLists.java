/* ******************************Question***********************************
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * *************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-11-05
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        int lenA = 0;
        int lenB = 0;
        ListNode temp = headA;
        ListNode temp2;
        while(temp != null){
            lenA ++;
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            lenB ++;
            temp = temp.next;
        }
        
        int diff = (lenA > lenB)?(lenA-lenB):(lenB-lenA);
        temp = (lenA > lenB)?(headA):(headB);
        temp2 = (lenA >lenB)?(headB):(headA);
        
        while(diff>0){
            temp = temp.next;
            diff --;
        }
        while(temp != temp2){
            temp = temp.next;
            temp2 = temp2.next;
        }
        return temp;
    }
}
