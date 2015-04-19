/* *******************Question************************
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * ***************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-19
 * @desc divide and conquer
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
    
    public static ListNode merge2Lists(ListNode ln1, ListNode ln2){
        if(ln1 == null) return ln2;
        if(ln2 == null) return ln1;
        ListNode result;
        if(ln1.val > ln2.val){
            result = ln2; 
            ln2=ln2.next;
        }else{
            result = ln1;
            ln1=ln1.next;
        }
        ListNode resultBackup = result;
        while(ln1 != null && ln2 != null){
            if(ln1.val > ln2.val){
                result.next = ln2;
                ln2=ln2.next;
            }else{
                result.next = ln1;
                ln1 =ln1.next;
            }
            result = result.next;
        }
        if(ln1 != null){
            result.next = ln1;
        }
        if(ln2 != null){
            result.next = ln2;
        }
        return resultBackup;
    }
    
    public ListNode mergeKLists(List<ListNode> lists) {
        int len = lists.size();
        if(len == 0){
            return null;
        }else if(len == 1){
            return lists.get(0);
        }else if(len == 2){
            return merge2Lists(lists.get(0), lists.get(1));
        }
        return merge2Lists(mergeKLists(lists.subList(0, len/2)), mergeKLists(lists.subList(len/2, len)));
    }
}
