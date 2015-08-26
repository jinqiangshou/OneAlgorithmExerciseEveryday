/* ************************************Question************************************
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * ********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-26
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * */
/* *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return new TreeNode(head.val);
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.next.val);
        root.right = sortedListToBST(slow.next.next);
        slow.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
