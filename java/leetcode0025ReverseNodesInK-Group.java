/* *******************************Question*******************************
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * **********************************************************************/

/**
 * @author Horst Xu
 * @date 2015-04-21
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
		ListNode headbp = head;
		while(headbp != null){
			len++;
			headbp = headbp.next;
		} 
		if(len < 2){return head;}
		
		int reverseTimes = (len / k);
		
	    ListNode myhead = new ListNode(0);
	    myhead.next = head;
	    ListNode curr = myhead;
	    ListNode next = head;
	    ListNode prev = null;
	    ListNode rhead = curr;
	    ListNode rtail = curr.next;
	    
	    for(int j=0;j<reverseTimes;j++){
	    	rhead = curr; 
	        rtail = curr.next; 
	        curr = curr.next; 	        
	        next = curr;
	        for (int i = 0; i < k; i++) {
	            next = next.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        rhead.next = prev;
	        rtail.next = next;
	        prev = null;
	        curr = rtail;
	    }
	    return myhead.next;
    }
}
